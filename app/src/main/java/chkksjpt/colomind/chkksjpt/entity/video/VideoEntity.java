package chkksjpt.colomind.chkksjpt.entity.video;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/11/27.
 */
@DatabaseTable(tableName = "TB_Video")
public class VideoEntity implements Serializable {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;

    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;

    @DatabaseField(columnName = "ZHDBH",useGetSet = true)
    private String ZHDBH;

    @DatabaseField(columnName = "WFDBH",useGetSet = true)
    private String WFDBH;

    @DatabaseField(columnName = "KCBH",useGetSet = true)
    private String KCBH;

    @DatabaseField(columnName = "videoname",useGetSet = true)
    private String videoname;

    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;

    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;

    @DatabaseField(columnName = "E",useGetSet = true)
    private String E;

    @DatabaseField(columnName = "N",useGetSet = true)
    private String N;

    @DatabaseField(columnName = "LZSJ",useGetSet = true)
    private String LZSJ;

    @Override
    public String toString() {
        return "VideoEntity{" +
                "idd=" + idd +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", ZHDBH='" + ZHDBH + '\'' +
                ", WFDBH='" + WFDBH + '\'' +
                ", KCBH='" + KCBH + '\'' +
                ", videoname='" + videoname + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", E='" + E + '\'' +
                ", N='" + N + '\'' +
                ", LZSJ='" + LZSJ + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getXZ() {
        return XZ;
    }

    public void setXZ(String XZ) {
        this.XZ = XZ;
    }

    public String getCUN() {
        return CUN;
    }

    public void setCUN(String CUN) {
        this.CUN = CUN;
    }

    public String getZHDBH() {
        return ZHDBH;
    }

    public void setZHDBH(String ZHDBH) {
        this.ZHDBH = ZHDBH;
    }

    public String getWFDBH() {
        return WFDBH;
    }

    public void setWFDBH(String WFDBH) {
        this.WFDBH = WFDBH;
    }

    public String getKCBH() {
        return KCBH;
    }

    public void setKCBH(String KCBH) {
        this.KCBH = KCBH;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getN() {
        return N;
    }

    public void setN(String n) {
        N = n;
    }

    public String getLZSJ() {
        return LZSJ;
    }

    public void setLZSJ(String LZSJ) {
        this.LZSJ = LZSJ;
    }
}
