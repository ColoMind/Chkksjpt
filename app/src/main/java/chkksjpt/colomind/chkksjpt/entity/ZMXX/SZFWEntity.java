package chkksjpt.colomind.chkksjpt.entity.ZMXX;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by CHENLI on 2016/4/8.
 */
@DatabaseTable(tableName = "TB_SZFW")
public class SZFWEntity implements Serializable {
    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "FWID",useGetSet = true)
    private String FWID; //房屋ID

    @DatabaseField(columnName = "NAME",useGetSet = true)
    private String NAME;//房屋名

    @DatabaseField(columnName = "ZHDBH",useGetSet = true)
    private String ZHDBH;//灾害点编号

    @DatabaseField(columnName = "strxy",useGetSet = true)
    private String strxy;//房屋面坐标

    @DatabaseField(columnName = "LC",useGetSet = true)
    private String LC;//楼层

    @DatabaseField(columnName = "HS",useGetSet = true)
    private String HS;//户数

    @DatabaseField(columnName = "RK",useGetSet = true)
    private String RK;//人口

    @DatabaseField(columnName = "MJ",useGetSet = true)
    private String MJ;//面积

    @DatabaseField(columnName = "centerX",useGetSet = true)
    private String centerX;//房屋中心坐标（平面坐标）

    @DatabaseField(columnName = "centerY",useGetSet = true)
    private String centerY;



    public SZFWEntity() {
    }

    @Override
    public String toString() {
        return "SZFWEntity{" +
                "idd=" + idd +
                ", FWID='" + FWID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ZHDBH='" + ZHDBH + '\'' +
                ", strxy='" + strxy + '\'' +
                ", LC='" + LC + '\'' +
                ", HS='" + HS + '\'' +
                ", RK='" + RK + '\'' +
                ", MJ='" + MJ + '\'' +
                ", centerX='" + centerX + '\'' +
                ", centerY='" + centerY + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getFWID() {
        return FWID;
    }

    public void setFWID(String FWID) {
        this.FWID = FWID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getZHDBH() {
        return ZHDBH;
    }

    public void setZHDBH(String ZHDBH) {
        this.ZHDBH = ZHDBH;
    }

    public String getStrxy() {
        return strxy;
    }

    public void setStrxy(String strxy) {
        this.strxy = strxy;
    }

    public String getLC() {
        return LC;
    }

    public void setLC(String LC) {
        this.LC = LC;
    }

    public String getHS() {
        return HS;
    }

    public void setHS(String HS) {
        this.HS = HS;
    }

    public String getRK() {
        return RK;
    }

    public void setRK(String RK) {
        this.RK = RK;
    }

    public String getMJ() {
        return MJ;
    }

    public void setMJ(String MJ) {
        this.MJ = MJ;
    }

    public String getCenterX() {
        return centerX;
    }

    public void setCenterX(String centerX) {
        this.centerX = centerX;
    }

    public String getCenterY() {
        return centerY;
    }

    public void setCenterY(String centerY) {
        this.centerY = centerY;
    }
}
