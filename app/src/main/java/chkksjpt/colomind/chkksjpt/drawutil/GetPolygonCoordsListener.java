package chkksjpt.colomind.chkksjpt.drawutil;

import java.util.List;
import chkksjpt.colomind.chkksjpt.entity.MercatorEntity;

public interface GetPolygonCoordsListener {

    void handleLatLon(List<MercatorEntity> LatLonPoint_List);
}
