package chkksjpt.colomind.chkksjpt.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esri.android.runtime.ArcGISRuntime;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.map.CallbackListener;
import com.esri.core.map.FeatureEditResult;
import com.esri.core.map.FeatureTemplate;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.FillSymbol;
import com.esri.core.symbol.LineSymbol;
import com.esri.core.symbol.MarkerSymbol;
import com.esri.core.symbol.Symbol;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.PopupWindowAdapter;
import chkksjpt.colomind.chkksjpt.drawutil.DrawTool;
import chkksjpt.colomind.chkksjpt.drawutil.FeatureTypeData;
import chkksjpt.colomind.chkksjpt.drawutil.GetPolygonCoordsListener;
import chkksjpt.colomind.chkksjpt.entity.MercatorEntity;
import chkksjpt.colomind.chkksjpt.fragment.MapFragment;
import chkksjpt.colomind.chkksjpt.utils.BasePopupWindow;
import chkksjpt.colomind.chkksjpt.utils.ConstantVar;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chkksjpt.colomind.chkksjpt.adapter.MapListAdapter;
import chkksjpt.colomind.chkksjpt.utils.DividerDec;
import chkksjpt.colomind.chkksjpt.utils.SnackBarUtil;
import chkksjpt.colomind.chkksjpt.utils.ToastUtil;

import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POINT;
import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POLYGON;
import static chkksjpt.colomind.chkksjpt.drawutil.DrawTool.POLYLINE;

public class MapChangeActivity extends AppCompatActivity implements GetPolygonCoordsListener {
    @BindView(R.id.curr_map)
    TextView currentMap;
    @BindView(R.id.text_choose_map)
    public TextView chooseMap;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_edit_graphic)
    public LinearLayout editGraphic;

    @BindViews({R.id.edit_polygon_end})
    List<TextView> views;

    private MapFragment mapFrag;
    Bundle args = new Bundle();

    BasePopupWindow mapListWindow;
    BasePopupWindow templatesWindow;

    public static int graphicID = -1;//GraphicsLayer中指定Graphic的id

    public static final String TAG = MapChangeActivity.class.getSimpleName();

    private String mapUrl;

    long lx = 0l;
    long ly = 0l;
    String coordStr = "";
    String coordStr80 = "";

    boolean mapFirstLoad = true;

    DividerDec dec;

    String[] mapUrls = new String[]{
            ConstantVar.CHLIUYUURL,
            ConstantVar.CHDXTURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL
    };

    View.OnClickListener positiveListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mapFrag.mDrawTool.clearGraphics();
            coordStr80 = "";
            mapFrag.showAcreage.setVisibility(View.GONE);
            mapFrag.clearDialog.dismiss();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mapview);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        dec = new DividerDec(this, DividerDec.VERTICAL_LIST, R.drawable.divider);
        initMapListWindow();
        //去掉开发者Logo
        ArcGISRuntime.setClientId("1eFHW78avlnRUPHm");
        mapFirstLoad = false;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        currentMap.setText(getIntent().getStringExtra(getString(R.string.key_save_map_name)));
        mapUrl = getIntent().getStringExtra(getString(R.string.key_save_map_url));
        addMapFrag(mapUrl, true);
    }

    /*public void readMapInLocal() {
        File destination = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/BJApp/shape", "LXDT_XZQH.tpk");
        if (destination.exists()) {
            //存储切片文件路径
            String path = "file:///storage/sdcard0/BJApp/shape/LXDT_XZQH.tpk";
            //声明并实例化ArcGISLocalTiledLayer
            ArcGISLocalTiledLayer localMap = new ArcGISLocalTiledLayer(path);
            //将离线地图加载到MapView中
            mMapView.removeAll();
            mMapView.addLayer(localMap);
        }
    }*/

    private void addMapFrag(String mapUrl, boolean firstAdd) {
        mapFrag = new MapFragment();
        args.putString("MAPURL", mapUrl);
        mapFrag.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (firstAdd) {
            ft.add(R.id.fragment_container, mapFrag).commit();
        } else {
            ft.replace(R.id.fragment_container, mapFrag).commit();
        }

    }

    private void initMapListWindow() {
        getSupportActionBar().setTitle("");
        mapListWindow = new BasePopupWindow(this, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RecyclerView mapListView = new RecyclerView(this);
        mapListView.setBackgroundColor(getResources().getColor(R.color.white));
        mapListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mapListView.setHasFixedSize(true);
        PopupWindowAdapter mapListAdapter = new PopupWindowAdapter(new PopupWindowAdapter.PopupItemClickListener() {
            @Override
            public void onItemClick(int index, String itemText) {
                addMapFrag(mapUrls[index], false);
                currentMap.setText(itemText);
                mapListWindow.dismiss();
            }
        }, false, MapListAdapter.mapNameLists);
        mapListView.setAdapter(mapListAdapter);
        mapListView.addItemDecoration(dec);
        mapListWindow.setContentView(mapListView);
    }

    public void initTypeListWindow() {
        templatesWindow = new BasePopupWindow(this, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RecyclerView templateListView = new RecyclerView(this);
        templateListView.setBackgroundColor(getResources().getColor(R.color.white));
        templateListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        templateListView.setHasFixedSize(true);
        PopupWindowAdapter templateListAdapter = new PopupWindowAdapter(new PopupWindowAdapter.PopupItemClickListener() {
            @Override
            public void onItemClick(int index, String itemText) {
                FeatureTypeData featureType = mapFrag.mFeatureTypeList.get(index);
                FeatureTemplate currentTemplate = mapFrag.mTemplateList.get(index);
                Symbol symbol = featureType.getSymbol();
                if (symbol instanceof MarkerSymbol) {
                    mapFrag.activateDrawTool(POINT, currentTemplate);
                    SnackBarUtil.createSnackBar(getWindow().getDecorView(), "在地图上点选一个点，点提交结束", null);
                } else if (symbol instanceof LineSymbol) {
                    mapFrag.activateDrawTool(POLYLINE, currentTemplate);
                    SnackBarUtil.createSnackBar(getWindow().getDecorView(), "在地图上点选一个线条，点提交结束", null);
                } else if (symbol instanceof FillSymbol) {
                    mapFrag.activateDrawTool(POLYGON, currentTemplate);
                    SnackBarUtil.createSnackBar(getWindow().getDecorView(), "在地图上点选一个多边形，点提交结束", null);
                }
                mapFrag.onEditMode(true);
                templatesWindow.dismiss();
            }
        }, mapFrag.mFeatureTypeList);
        templateListView.setAdapter(templateListAdapter);
        templateListView.addItemDecoration(dec);
        templatesWindow.setContentView(templateListView);
    }

    private void showTypeListWindow() {
        if (templatesWindow == null) {
            initTypeListWindow();
        } else {
            templatesWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        }
    }

    @Override
    public void handleLatLon(List<MercatorEntity> LatLonPoint_List) {
        Polygon polygon = new Polygon();
        coordStr = "";
        coordStr80 = "";
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.setMaximumFractionDigits(8);
        lx = 0;
        ly = 0;
        int i = 0;
        if (LatLonPoint_List != null && LatLonPoint_List.size() > 0) {
            for (MercatorEntity llp : LatLonPoint_List) {
                lx += llp.getX();
                ly += llp.getY();
                int WKID = mapFrag.mMapView.getSpatialReference().getLatestID();
                Point WGS84Point = (Point) GeometryEngine.project(new Point(llp.getX(), llp.getY()),
                        SpatialReference.create(WKID), SpatialReference.create(4326));
                Point XiAn80Point = (Point) GeometryEngine.project(new Point(llp.getX(), llp.getY()),
                        SpatialReference.create(WKID), SpatialReference.create(2359));
                Point areaPoint = (Point) GeometryEngine.project(new Point(llp.getX(), llp.getY()),
                        SpatialReference.create(WKID), SpatialReference.create(3857));
                coordStr += df.format(WGS84Point.getX()) + " " + df.format(WGS84Point.getY()) + ";";
                coordStr80 += df.format(XiAn80Point.getX()) + " " + df.format(XiAn80Point.getY()) + ";";
                if (i == 0) {
                    polygon.startPath(areaPoint);
                } else {
                    polygon.lineTo(areaPoint);
                }
                i++;
            }
            coordStr = coordStr.substring(0, coordStr.length() - 1);
            lx = lx / LatLonPoint_List.size();
            ly = ly / LatLonPoint_List.size();
            if (coordStr == null && coordStr.equals("")) {
                ToastUtil.show(this, "请先绘制完正确图形后再提交！");
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.draw_start:
                showTypeListWindow();
                break;
            case R.id.submit_graphic:
                if (mapFrag.drawEnd) {
                    mapFrag.showAcreage.setVisibility(View.VISIBLE);
                    mapFrag.mDrawTool.getPoints();
                }
                break;
            case R.id.action_setting:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.delete_feature:
                if (mapFrag.getSelectedGraphic() != null) {
                    switch (mapFrag.getSelectFeatureType()) {
                        case POINT:
                            break;
                        case POLYLINE:
                            mapFrag.roadPolylineLayer.applyEdits(null, new Graphic[]{mapFrag.getSelectedGraphic()}, null, new CallbackListener<FeatureEditResult[][]>() {
                                @Override
                                public void onCallback(FeatureEditResult[][] featureEditResults) {
                                    if (featureEditResults[1][0].isSuccess()) {
                                        SnackBarUtil.createSnackBar(mapFrag.getView(), "Feature Deleted Succeed!", null);
                                    }
                                }

                                @Override
                                public void onError(Throwable throwable) {
                                    Log.i("Delete Error", throwable.getMessage());
                                }
                            });
                            break;
                        case POLYGON:
                            break;
                    }
                } else {
                    SnackBarUtil.createSnackBar(mapFrag.getView(), "No Feature Selected!", null);
                }
                break;
            case R.id.clear_graphic:
                if (mapFrag.clearDialog == null) {
                    mapFrag.clearDialog = mapFrag.mDialogHelper.buildMaterialDialog("确认删除图形？", null, false, positiveListener, null);
                } else {
                    mapFrag.clearDialog.show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.text_choose_map, R.id.edit_polygon_end})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_choose_map:
                mapListWindow.showAsDropDown(chooseMap);
                break;
            case R.id.edit_polygon_end:
                mapFrag.quitEditMode();
                mapFrag.syncEdit();
                break;
            default:
                break;
        }
    }


}

