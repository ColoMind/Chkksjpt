package chkksjpt.colomind.chkksjpt.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/8/4.
 */
@DatabaseTable(tableName = "TB_XCPZPhotos")
public class XCPZPhotosEntity implements Serializable {
    @DatabaseField(generatedId = true,columnName = "idd",useGetSet = true)
    private int idd;


    @DatabaseField(columnName ="userid",useGetSet = true)
    private String userid;//用户编号

    @DatabaseField(columnName ="type",useGetSet = true)
    private String type;//照片类别（XCRY、土地相关等）

    @DatabaseField(columnName ="photopaths",useGetSet = true)
    private String photopaths;//照片路劲

    @DatabaseField(columnName ="tpbh",useGetSet = true)
    private String tpbh;//图片编号

    @DatabaseField(columnName ="remark",useGetSet = true)
    private String remark;//备注

    @DatabaseField(columnName ="X",useGetSet = true)
    private String X;//X

    @DatabaseField(columnName ="Y",useGetSet = true)
    private String Y;//Y

    @DatabaseField(columnName ="picfiletype",useGetSet = true)
    private String picfiletype;//服务器照片文件夹分类

    @Override
    public String toString() {
        return "XCPZPhotosEntity{" +
                "idd=" + idd +
                ", userid='" + userid + '\'' +
                ", type='" + type + '\'' +
                ", photopaths='" + photopaths + '\'' +
                ", tpbh='" + tpbh + '\'' +
                ", remark='" + remark + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", picfiletype='" + picfiletype + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotopaths() {
        return photopaths;
    }

    public void setPhotopaths(String photopaths) {
        this.photopaths = photopaths;
    }

    public String getTpbh() {
        return tpbh;
    }

    public void setTpbh(String tpbh) {
        this.tpbh = tpbh;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getPicfiletype() {
        return picfiletype;
    }

    public void setPicfiletype(String picfiletype) {
        this.picfiletype = picfiletype;
    }
}
