package chkksjpt.colomind.chkksjpt.entity.DZJC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2016/2/27.
 */
@DatabaseTable(tableName = "TB_CGQ")
public class CGQEntity implements Serializable {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "CGQID",useGetSet = true)
    private String CGQID;//产品自编号

    @DatabaseField(columnName = "CGQXH",useGetSet = true)
    private String CGQXH; //产品型号

    @DatabaseField(columnName = "ZHDBH",useGetSet = true)
    private String ZHDBH;//灾害点编号

    @DatabaseField(columnName = "YJDJ",useGetSet = true)
    private String YJDJ;//预警等级

    @DatabaseField(columnName = "CPID",useGetSet = true)
    private String CPID;//是否重点传感器

    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;//平面坐标

    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;//


    public CGQEntity() {
    }

    @Override
    public String toString() {
        return "CGQEntity{" +
                "idd=" + idd +
                ", CGQID='" + CGQID + '\'' +
                ", CGQXH='" + CGQXH + '\'' +
                ", ZHDBH='" + ZHDBH + '\'' +
                ", YJDJ='" + YJDJ + '\'' +
                ", CPID='" + CPID + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getCGQID() {
        return CGQID;
    }

    public void setCGQID(String CGQID) {
        this.CGQID = CGQID;
    }

    public String getCGQXH() {
        return CGQXH;
    }

    public void setCGQXH(String CGQXH) {
        this.CGQXH = CGQXH;
    }

    public String getZHDBH() {
        return ZHDBH;
    }

    public void setZHDBH(String ZHDBH) {
        this.ZHDBH = ZHDBH;
    }

    public String getYJDJ() {
        return YJDJ;
    }

    public void setYJDJ(String YJDJ) {
        this.YJDJ = YJDJ;
    }

    public String getCPID() {
        return CPID;
    }

    public void setCPID(String CPID) {
        this.CPID = CPID;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }
}
