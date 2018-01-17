package chkksjpt.colomind.chkksjpt.drawutil;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapOnTouchListener;
import com.esri.android.map.MapView;
import com.esri.core.geometry.Geometry;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.geometry.Proximity2DResult;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.core.symbol.SimpleMarkerSymbol;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.entity.MercatorEntity;
import chkksjpt.colomind.chkksjpt.fragment.MapFragment;
import chkksjpt.colomind.chkksjpt.utils.ToastUtil;

import static chkksjpt.colomind.chkksjpt.fragment.MapFragment.graphicID;

/**
 * Created by Administrator on 2017/11/14.
 * 绘制图形工具
 */

public class DrawTool extends Subject {
    private MapView mapView;

    //绘制图形的图层
    private GraphicsLayer tempLayer;

    private int drawType;

    public boolean polygonDrawActive = false;
    public boolean longPressActive = false;

    private SimpleMarkerSymbol pointSymbol;
    private SimpleLineSymbol polylineSymbol;
    private SimpleFillSymbol polygonSymbol;

    private Point pointToDraw;
    private Polyline polylineToDraw;
    private Polygon polygonToDraw;
    public Graphic graphicToDraw;

    private MyDrawTouchListener myDrawTouchListener;
    private GetPolygonCoordsListener polygonCoordsListener;

    //保存多边形的点
    private List<MercatorEntity> LatLonPointList = new ArrayList<>();

    private Context mContext;

    private MapFragment fragment;

    public Geometry simplifiedGeometry;

    public static final int POINT = -1;
    public static final int POLYLINE = 0;
    public static final int POLYGON = 1;
    public static final int ENVELOPE = 2;
    public static final int CIRCLE = 3;

    public static final String[] typeNames = new String[]{"Point", "Polyline", "Polygon"};

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({POINT, ENVELOPE, POLYLINE, POLYGON, CIRCLE})
    @interface DrawType {
    }


    public DrawTool(GetPolygonCoordsListener mListener, MapFragment mapFrag) {
        this.mapView = mapFrag.mMapView;
        fragment = mapFrag;
        mContext = this.mapView.getContext();
        //TODO 去掉add这两行显示不出图形 从Activity传Layer会报空指针
        tempLayer = new GraphicsLayer();
        this.mapView.addLayer(tempLayer);
        pointSymbol = new SimpleMarkerSymbol(mContext.getResources().getColor(R.color.btn_logout_normal), 15, SimpleMarkerSymbol.STYLE.CIRCLE);
        polylineSymbol = new SimpleLineSymbol(mContext.getResources().getColor(R.color.top_bar_normal_bg), 8, SimpleLineSymbol.STYLE.SOLID);
        polygonSymbol = new SimpleFillSymbol(mContext.getResources().getColor(R.color.holo_green_light), SimpleFillSymbol.STYLE.SOLID);
        polygonSymbol.setAlpha(90);
        polygonCoordsListener = mListener;
    }

    public void deactivate() {
        longPressActive = false;
        polygonDrawActive = false;
    }

    public void clearGraphics() {
        tempLayer.removeAll();
    }

    public int activate(@DrawType int drawType) {
        if (this.mapView == null) {
            return -1;
        }
        this.drawType = drawType;
        polygonDrawActive = true;
        myDrawTouchListener = new MyDrawTouchListener(mContext, mapView);
        switch (drawType) {
            case POINT:
                pointToDraw = new Point();
                graphicToDraw = new Graphic(pointToDraw, pointSymbol);
                break;
            case POLYLINE:
                polylineToDraw = new Polyline();
                graphicToDraw = new Graphic(polylineToDraw, polylineSymbol);
                break;
            case POLYGON:
                polygonToDraw = new Polygon();
                graphicToDraw = new Graphic(polygonToDraw, this.polygonSymbol);
                break;
            default:
                break;
        }
        mapView.setOnTouchListener(myDrawTouchListener);
        return tempLayer.addGraphic(graphicToDraw);
    }

    public void getPoints() {
        if (polygonCoordsListener != null) {
            getPointList(polygonToDraw);
        }
    }


    public void deleteGraphic() {
        tempLayer.removeGraphic(graphicToDraw.getUid());
        tempLayer.setGraphicVisible(graphicToDraw.getUid(), false);
    }

    public void onEditStart(boolean firstDraw) {
        if (!firstDraw) {
            if (LatLonPointList == null || LatLonPointList.size() < 3) {
                ToastUtil.show(mapView.getContext(), "地块不完整,请重新绘制");
                return;
            } else {
                ToastUtil.show(mapView.getContext(), "请选择一个点进行编辑");
            }
            polygonDrawActive = false;
            longPressActive = true;
        }
    }

    public String calculatingArea() {
        long area = Math.abs(Math.round(polygonToDraw.calculateArea2D()));
        String sArea;
        // 顺时针绘制多边形，面积为正，逆时针绘制，则面积为负
        if (area >= 1000000) {
            double dArea = area / 1000000.0;
            sArea = Double.toString(dArea) + " 平方公里";
        } else {
            sArea = Double.toString(area) + " 平方米";
        }
        return sArea;
    }

    private void getPointList(Geometry polygon) {
        List<MercatorEntity> pointList = new ArrayList<>();
        Geometry geometry = GeometryEngine.simplify(polygon, mapView.getSpatialReference());
        if (geometry != null) {
            String geomytry2json = GeometryEngine.geometryToJson(mapView.getSpatialReference(), polygon);
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(geomytry2json);
            com.alibaba.fastjson.JSONArray jsonring = jsonObject.getJSONArray("rings");
            com.alibaba.fastjson.JSONArray jsonArray = jsonring.getJSONArray(0);
            //去掉重复点的记录
            //polygon由ring组成，每个ring的起点和终点是重合的，需要去掉一个重复点的记录
            for (int i = 0; i < jsonArray.size() - 1; i++) {
                MercatorEntity latLonPointEdit = new MercatorEntity();//每次循环都要实例化这个类，实例化的类的属性赋值后不嫩再修改
                double PointX = jsonArray.getJSONArray(i).getBigDecimal(0).doubleValue();
                double PointY = jsonArray.getJSONArray(i).getBigDecimal(1).doubleValue();
                latLonPointEdit.setX(PointX);
                latLonPointEdit.setY(PointY);
                pointList.add(latLonPointEdit);
            }
            polygonCoordsListener.handleLatLon(pointList);
        } else {
            ToastUtil.show(mapView.getContext(), "图层不存在");
        }
    }

    public class MyDrawTouchListener extends MapOnTouchListener {
        private Point startPoint = null;
        private MercatorEntity latLonPoint = null;
        private String TAG = MyDrawTouchListener.class.getSimpleName();
        private int editIndex = -1;

        public MyDrawTouchListener(Context context, MapView view) {
            super(context, view);
        }

        @Override
        public void onLongPress(MotionEvent point) {
            if (fragment != null) {
                {
                    if (tempLayer != null) {
                        int[] ids = tempLayer.getGraphicIDs(point.getX(), point.getY(), 50);
                        graphicID = ids[0];
                        fragment.onEditMode(false);
                    }
                }
            }
            super.onLongPress(point);
        }

        @Override
        public boolean onDragPointerMove(MotionEvent from, MotionEvent to) throws NullPointerException {
            if (longPressActive) {
                if (drawType == POLYLINE) {
                    if (editIndex < 0) {//此时需要获取编辑的节点序号
                        if (from != null) {
                            Point ptClick = mapView.toMapPoint(from.getX(), from.getY());
                            Proximity2DResult pr = GeometryEngine.getNearestVertex(polylineToDraw, ptClick);
                            editIndex = pr.getVertexIndex();
                            Log.i(TAG, "获取editIndex=" + editIndex);
                        } else {
                            Toast.makeText(mapView.getContext(), "请选择点进行编辑", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (graphicToDraw != null && editIndex >= 0) {
                        Point ptTo = mapView.toMapPoint(to.getX(), to.getY());
                        polylineToDraw.setPoint(editIndex, ptTo);//改变指定节点的坐标
                        Log.i(TAG, "改变指定节点的坐标");
                        editIndex = -1;
                    }

                    tempLayer.updateGraphic(graphicID, polylineToDraw);
                    simplifiedGeometry = GeometryEngine.simplify(polylineToDraw, mapView.getSpatialReference());
                    return true;
                } else {
                    if (editIndex < 0) {//此时需要获取编辑的节点序号
                        if (from != null) {
                            Point ptClick = mapView.toMapPoint(from.getX(), from.getY());
                            Proximity2DResult pr = GeometryEngine.getNearestVertex(polygonToDraw, ptClick);
                            editIndex = pr.getVertexIndex();
                            Log.i(TAG, "获取editIndex=" + editIndex);
                        } else {
                            Toast.makeText(mapView.getContext(), "请选择点进行编辑", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (graphicToDraw != null && editIndex >= 0) {
                        Point ptTo = mapView.toMapPoint(to.getX(), to.getY());
                        polygonToDraw.setPoint(editIndex, ptTo);//改变指定节点的坐标
                        Log.i(TAG, "改变指定节点的坐标");
                        editIndex = -1;
                    }
                    tempLayer.updateGraphic(graphicID, polygonToDraw);
                    return true;
                }
            }
            //return super可以自由滑动地图
            return super.onDragPointerMove(from, to);
        }

        public boolean onDragPointerUp(MotionEvent from, MotionEvent to) {
            if (longPressActive && (drawType == ENVELOPE || drawType == CIRCLE)) {
                Point point = mapView.toMapPoint(to.getX(), to.getY());
                DrawTool.this.onEditStart(false);
                startPoint = null;
                return true;
            }
            return super.onDragPointerUp(from, to);
        }

        @Override
        public boolean onSingleTap(MotionEvent event) {
            Point tapedPoint = mapView.toMapPoint(event.getX(), event.getY());
            Log.i("tapedPoint", tapedPoint.toString());
            switch (drawType) {
                case POINT:
                    if (polygonDrawActive) {
                        pointToDraw = tapedPoint;
                        tempLayer.updateGraphic(graphicID, pointToDraw);
                    }
                    break;
                case POLYLINE:
                    if (polygonDrawActive) {
                        latLonPoint = new MercatorEntity();
                        if (startPoint == null) {
                            startPoint = tapedPoint;
                            polylineToDraw.startPath(tapedPoint);
                            latLonPoint.setX(tapedPoint.getX());
                            latLonPoint.setY(tapedPoint.getY());
                            LatLonPointList.add(latLonPoint);
                        } else {
                            polylineToDraw.lineTo(tapedPoint);
                            latLonPoint.setX(tapedPoint.getX());
                            latLonPoint.setY(tapedPoint.getY());
                            LatLonPointList.add(latLonPoint);
                        }
                        //动态更新图形
                        tempLayer.updateGraphic(graphicID, polylineToDraw);
                        simplifiedGeometry = GeometryEngine.simplify(polylineToDraw, mapView.getSpatialReference());
                    }
                    break;
                case POLYGON:
                    if (polygonDrawActive) {
                        latLonPoint = new MercatorEntity();
                        if (startPoint == null) {
                            startPoint = tapedPoint;
                            polygonToDraw.startPath(tapedPoint);
                            latLonPoint.setX(tapedPoint.getX());
                            latLonPoint.setY(tapedPoint.getY());
                            LatLonPointList.add(latLonPoint);
                        } else {
                            polygonToDraw.lineTo(tapedPoint);
                            latLonPoint.setX(tapedPoint.getX());
                            latLonPoint.setY(tapedPoint.getY());
                            LatLonPointList.add(latLonPoint);
                        }
                        //动态更新图形
                        tempLayer.updateGraphic(graphicID, polygonToDraw);
                    }
                    break;
            }
            return super.onSingleTap(event);
        }

    }
}
