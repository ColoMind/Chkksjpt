/* Copyright 2015 Esri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package chkksjpt.colomind.chkksjpt.fragment;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.esri.android.map.Layer;
import com.esri.android.map.LocationDisplayManager;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISDynamicMapServiceLayer;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.android.map.event.OnSingleTapListener;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.map.CallbackListener;
import com.esri.core.map.FeatureEditResult;
import com.esri.core.map.FeatureSet;
import com.esri.core.map.FeatureTemplate;
import com.esri.core.map.FeatureType;
import com.esri.core.map.Graphic;
import com.esri.core.renderer.Renderer;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.core.symbol.Symbol;
import com.esri.core.symbol.SymbolHelper;
import com.esri.core.tasks.SpatialRelationship;
import com.esri.core.tasks.ags.query.Query;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.drawutil.DrawTool;
import chkksjpt.colomind.chkksjpt.drawutil.FeatureTypeData;
import chkksjpt.colomind.chkksjpt.drawutil.GetPolygonCoordsListener;
import chkksjpt.colomind.chkksjpt.entity.MercatorEntity;
import chkksjpt.colomind.chkksjpt.ui.MapChangeActivity;
import chkksjpt.colomind.chkksjpt.utils.ConstantVar;
import chkksjpt.colomind.chkksjpt.utils.DialogHelper;
import chkksjpt.colomind.chkksjpt.utils.SnackBarUtil;
import chkksjpt.colomind.chkksjpt.utils.ToastUtil;
import me.drakeet.materialdialog.MaterialDialog;

import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POINT;
import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POLYGON;
import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POLYLINE;


/* This fragment contains a MapView, and is added to the MapActivity. Temporary state such as map contents
 * and extent are preserved if, for example, the device is rotated.
 */
public class MapFragment extends Fragment implements GetPolygonCoordsListener, OnSingleTapListener {
    @BindView(R.id.layout_show_acreage)
    public RelativeLayout showAcreage;
    @BindViews({R.id.checkout_acreage, R.id.checkout_coordinate})
    List<TextView> views;

    long lx = 0l;
    long ly = 0l;
    String coordStr = "";
    String coordStr80 = "";

    MapChangeActivity rootActivity;

    private SharedPreferences layerListPreference;
    private SharedPreferences.Editor layerListEditor;

    public MapView mMapView;
    public DrawTool mDrawTool;

    private String serviceUrl;

    private String mMapState;

    public boolean drawEnd = false;

    public boolean featureInitialized = false;

    private final String SERVICE_URL = "serviceUrl";
    private final String MAP_STATE = "mapState";

    public static int graphicID = -1;//GraphicsLayer中指定Graphic的id

    public MaterialDialog coordinateDialog = null;
    public MaterialDialog clearDialog = null;

    public DialogHelper mDialogHelper;

    public OnStatusChangedListener.STATUS mapStatu;

    public ArcGISFeatureLayer roadPolylineLayer = new ArcGISFeatureLayer(ConstantVar.FEATURE_ROAD_POLYLINE_URL, ArcGISFeatureLayer.MODE.ONDEMAND);
    public ArcGISFeatureLayer pointLayer = new ArcGISFeatureLayer(ConstantVar.FEATURE_0_URL, ArcGISFeatureLayer.MODE.ONDEMAND);
    public ArcGISFeatureLayer polygonLayer = new ArcGISFeatureLayer(ConstantVar.FEATURE_6_URL, ArcGISFeatureLayer.MODE.ONDEMAND);

    public ArrayList<FeatureTemplate> mTemplateList = new ArrayList<>();
    public ArrayList<FeatureTypeData> mFeatureTypeList = new ArrayList<>();
    public ArrayList<ArcGISFeatureLayer> mFeatureLayerList = new ArrayList<>();

    private FeatureTemplate currentTemplate;

    private Graphic selectedGraphic = null;

    public Graphic getSelectedGraphic() {
        return selectedGraphic;
    }

    public int getSelectFeatureType() {
        return selectFeatureType;
    }

    private int selectFeatureType;

    private SimpleLineSymbol polylineOutLine;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the map fragment from the XML layout and get the MapView.
        View fragmentView = inflater.inflate(R.layout.map_fragment, container, false);
        ButterKnife.bind(this, fragmentView);
        showAcreage.setVisibility(View.GONE);
        if (savedInstanceState != null) {
            // If there is saved state, then the fragment will be re-created by the
            // android framework. Extract the saved state
            // of the fragment from the bundle parameter.
            serviceUrl = savedInstanceState.getString(SERVICE_URL, null);
            mMapState = savedInstanceState.getString(MAP_STATE, null);
        } else {
            // Retrieve the service url and extent from arguments provided by
            // MapActivity
            Bundle args = getArguments();
            serviceUrl = args.getString("MAPURL");
            mMapState = args.getString("MAPSTATE");
        }

        layerListPreference = getActivity().getApplicationContext().getSharedPreferences(getString(R.string.share_pref_layer_list), 0);
        layerListEditor = layerListPreference.edit();

        initOutLine();

        initMapView(fragmentView);

        // If map state (center and resolution) has been stored, update the MapView
        // with this state.
        if (!TextUtils.isEmpty(mMapState)) {
            mMapView.restoreState(mMapState);
        }
        // If a service URL has been set, add a map layer based on that service.
        // After the layer is added, this will ensure
        // the map has a spatial reference, and the full extent covers the entire
        // world, so wrap around map can be set.

        // Return the view for this Fragment.
        return fragmentView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootActivity = (MapChangeActivity) getActivity();
        mDialogHelper = new DialogHelper(rootActivity);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the URL of map service layer, and map state (map center and resolution).
        outState.putString(SERVICE_URL, serviceUrl);
        outState.putString(MAP_STATE, mMapView.retainState());
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.unpause();
    }


    @OnClick({R.id.checkout_acreage, R.id.checkout_coordinate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkout_coordinate:
                if (coordStr80 != null) {
                    if (coordinateDialog == null) {
                        coordinateDialog = mDialogHelper.buildMaterialDialog("查看坐标", coordStr80, true, null, null);
                    } else {
                        mDrawTool.getPoints();
                        coordinateDialog.setMessage(coordStr80);
                        coordinateDialog.show();
                    }
                }
                break;
            case R.id.checkout_acreage:
                mDialogHelper.buildMaterialDialog("查看面积", mDrawTool.calculatingArea(), true, null, null);
                break;
        }
    }

    private void initOutLine() {
        polylineOutLine = new SimpleLineSymbol(Color.YELLOW, 5);
        SimpleFillSymbol sfs = new SimpleFillSymbol(Color.TRANSPARENT);
        sfs.setOutline(polylineOutLine);
        polygonLayer.setSelectionSymbol(sfs);
        roadPolylineLayer.setSelectionSymbol(polylineOutLine);
    }

    private void listTemplates() {
        for (Layer l : mMapView.getLayers()) {
            if (l instanceof ArcGISFeatureLayer) {
                ArcGISFeatureLayer layer = (ArcGISFeatureLayer) l;
                FeatureType[] types = layer.getTypes();
                for (FeatureType type : types) {
                    addTemplates(layer, type.getTemplates());
                }
            }
        }
    }


    private void addTemplates(ArcGISFeatureLayer featureLayer, FeatureTemplate[] templates) {
        for (FeatureTemplate featureTemplate : templates) {
            String name = featureTemplate.getName();
            Graphic g = featureLayer.createFeatureWithTemplate(featureTemplate, null);
            Renderer renderer = featureLayer.getRenderer();
            Symbol symbol = renderer.getSymbol(g);

            final int WIDTH_IN_DP_UNITS = 30;
            final float scale = getResources().getDisplayMetrics().density;
            final int widthInPixels = (int) (WIDTH_IN_DP_UNITS * scale + 0.5f);
            Bitmap bitmap = SymbolHelper.getLegendImage(symbol, widthInPixels, widthInPixels);

            mFeatureTypeList.add(new FeatureTypeData(bitmap, name, symbol));
            mTemplateList.add(featureTemplate);
            mFeatureLayerList.add(featureLayer);
        }
    }

    public void syncEdit() {
        Graphic graphic = roadPolylineLayer.createFeatureWithTemplate(currentTemplate, mDrawTool.simplifiedGeometry);
        if (featureInitialized) {
            roadPolylineLayer.applyEdits(new Graphic[]{graphic}, null, null, new CallbackListener<FeatureEditResult[][]>() {
                FeatureEditResult[][] results;

                @Override
                public void onCallback(FeatureEditResult[][] featureEditResults) {
                    results = featureEditResults;
                    if (results != null) {
                        if (results[0][0].isSuccess()) {
                            SnackBarUtil.createSnackBar(getView(), "Feature Sync Succeed!", null);
                            mDrawTool.clearGraphics();
                        }
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    Log.i("Sync_Error", results[0][0].getError().getDescription());
                    SnackBarUtil.createSnackBar(MapFragment.this.getView(), throwable.getMessage(), null);
                }
            });
        } else {
            SnackBarUtil.createSnackBar(getView(), "FeatureLayer Not Initialized !", null);
        }
    }

    public void activateDrawTool(int type, FeatureTemplate template) {
        currentTemplate = template;
        mDrawTool = new DrawTool(this, this);
        graphicID = mDrawTool.activate(type);
        Log.i("graphicId", String.valueOf(graphicID));
    }

    private void initMapView(View rootView) {
        mMapView = rootView.findViewById(R.id.map);
        mMapView.setEsriLogoVisible(false);
        mMapView.enableWrapAround(false);
        mMapView.setOnStatusChangedListener(new OnStatusChangedListener() {
            public void onStatusChanged(Object source, STATUS status) {
                mapStatu = status;
                // 检查地图是否成功调用
                if (status == STATUS.INITIALIZED) {
                    Log.i("MapViewStatus", source.toString());
                    Log.i("MapViewStatus", "加载成功");
                    Log.i("SpatialReference", mMapView.getSpatialReference().toString());
                    /*locatePosition();*/
                    locateToCenter();
                    mMapView.addLayer(pointLayer);
                    mMapView.addLayer(polygonLayer);
                    mMapView.addLayer(roadPolylineLayer);
                    if (roadPolylineLayer.isInitialized()) {
                        featureInitialized = true;
                        SnackBarUtil.createSnackBar(getView(), "FeatureLayerInitailized", null);
                        listTemplates();
                        rootActivity.initTypeListWindow();
                    }
                } else if (status == STATUS.INITIALIZATION_FAILED || status == STATUS.LAYER_LOADING_FAILED) {
                    Log.i("MapViewStatus", source.toString());
                    Log.i("MapViewStatus", "加载失败");
                }
            }
        });
        mMapView.setOnSingleTapListener(this);
        if (!TextUtils.isEmpty(serviceUrl)) {
            if (serviceUrl.equals(ConstantVar.CHLIUYUURL)) {
                mMapView.addLayer(new ArcGISTiledMapServiceLayer(serviceUrl));
            } else {
                mMapView.addLayer(new ArcGISDynamicMapServiceLayer(serviceUrl));
            }
        }
    }

    public void quitEditMode() {
        mDrawTool.deactivate();
        rootActivity.editGraphic.setVisibility(View.GONE);
        rootActivity.chooseMap.setVisibility(View.VISIBLE);
        ToastUtil.show(rootActivity, "图形编辑完成");
        drawEnd = true;
    }

    public void onEditMode(boolean firstDraw) {
        mDrawTool.onEditStart(firstDraw);
        rootActivity.editGraphic.setVisibility(View.VISIBLE);
        rootActivity.chooseMap.setVisibility(View.GONE);
    }

    public void locatePosition() {
        LocationDisplayManager locationDisplayManager = mMapView.getLocationDisplayManager();//获取定位类
        locationDisplayManager.setAutoPanMode(LocationDisplayManager.AutoPanMode.LOCATION);//设置模式
        locationDisplayManager.start();//开始定位
        Point point = locationDisplayManager.getPoint();
        mMapView.zoomToResolution(point, 1);
        mMapView.setScale(3000);
    }

    public void locateToCenter() {
        Point point = new Point(3.542406739333833E7, 2970552.5513459514);
        //res的大小和缩放大小成正比
        mMapView.zoomToResolution(point, 4);
    }

    @Override
    public void handleLatLon(List<MercatorEntity> LatLonPoint_List) {
        coordStr = "";
        coordStr80 = "";
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.setMaximumFractionDigits(8);
        lx = 0;
        ly = 0;
        if (LatLonPoint_List != null && LatLonPoint_List.size() > 0) {
            for (MercatorEntity llp : LatLonPoint_List) {
                lx += llp.getX();
                ly += llp.getY();
                int WKID = mMapView.getSpatialReference().getLatestID();
                Point WGS84Point = (Point) GeometryEngine.project(new Point(llp.getX(), llp.getY()),
                        SpatialReference.create(WKID), SpatialReference.create(4326));
                Point XiAn80Point = (Point) GeometryEngine.project(new Point(llp.getX(), llp.getY()),
                        SpatialReference.create(WKID), SpatialReference.create(2359));
                coordStr += df.format(WGS84Point.getX()) + " " + df.format(WGS84Point.getY()) + ";";
                coordStr80 += df.format(XiAn80Point.getX()) + " " + df.format(XiAn80Point.getY()) + ";";
            }
            coordStr = coordStr.substring(0, coordStr.length() - 1);
            lx = lx / LatLonPoint_List.size();
            ly = ly / LatLonPoint_List.size();
            if (coordStr == null && coordStr.equals("")) {
                ToastUtil.show(rootActivity, "请先绘制完正确图形后再提交！");
            }
        }
    }


    @Override
    public void onSingleTap(float v, float v1) {
        Point pointTaped = mMapView.toMapPoint(v, v1);
        Graphic currentGraphic = null;
        final Query query = new Query();
        query.setOutFields(new String[]{"*"});
        query.setSpatialRelationship(SpatialRelationship.WITHIN);
        query.setReturnGeometry(true);
        query.setInSpatialReference(mMapView.getSpatialReference());

        selectFeatureType = layerListPreference.getInt(getString(R.string.key_pref_select_layer), -1);
        switch (selectFeatureType) {
            case POINT:
                roadPolylineLayer.clearSelection();
                polygonLayer.clearSelection();
                int[] pointIDs = pointLayer.getGraphicIDs(v, v1, 10, 1);
                if (pointIDs.length > 0) {
                    currentGraphic = pointLayer.getGraphic(pointIDs[0]);
                    selectedGraphic = currentGraphic;
                }
                if (currentGraphic != null) {
                    query.setGeometry(currentGraphic.getGeometry());
                }
                pointLayer.selectFeatures(query, ArcGISFeatureLayer.SELECTION_METHOD.NEW, new CallbackListener<FeatureSet>() {
                    @Override
                    public void onCallback(FeatureSet featureSet) {
                        if (featureSet.getGeometryType() != null) {
                            SnackBarUtil.createSnackBar(getView(), "Feature Selected", null);
                        }
                        Log.i("FeatureSet", featureSet.toString());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.i("SelectError", "Select Feature Error or Not Feature Here");
                        pointLayer.clearSelection();
                    }
                });
                break;
            case POLYLINE:
                pointLayer.clearSelection();
                polygonLayer.clearSelection();
                int[] polylineIDs = roadPolylineLayer.getGraphicIDs(v, v1, 10, 1);
                if (polylineIDs.length > 0) {
                    currentGraphic = roadPolylineLayer.getGraphic(polylineIDs[0]);
                    selectedGraphic = currentGraphic;
                }
                if (currentGraphic != null) {
                    query.setGeometry(currentGraphic.getGeometry());
                }
                roadPolylineLayer.selectFeatures(query, ArcGISFeatureLayer.SELECTION_METHOD.NEW, new CallbackListener<FeatureSet>() {
                    @Override
                    public void onCallback(FeatureSet featureSet) {
                        if (featureSet.getGeometryType() != null) {
                            SnackBarUtil.createSnackBar(getView(), "Feature Selected", null);
                            for (String field : query.getOutFields())
                                Log.i("Field", field);
                        }
                        /*Log.i("FeatureSet", featureSet.toString());*/
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.i("SelectError", "Select Feature Error or Not Feature Here");
                        roadPolylineLayer.clearSelection();
                    }
                });
                break;
            case POLYGON:
                pointLayer.clearSelection();
                roadPolylineLayer.clearSelection();
                query.setGeometry(pointTaped);
                polygonLayer.selectFeatures(query, ArcGISFeatureLayer.SELECTION_METHOD.NEW, new CallbackListener<FeatureSet>() {
                    @Override
                    public void onCallback(FeatureSet featureSet) {
                        if (featureSet.getGeometryType() != null) {
                            SnackBarUtil.createSnackBar(getView(), "Feature Selected", null);
                        }
                        Log.i("FeatureSet", featureSet.toString());
                        selectedGraphic = featureSet.getGraphics()[0];
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.i("SelectError", "Select Feature Error or Not Feature Here");
                        polygonLayer.clearSelection();
                    }
                });
                break;
        }


    }
}
