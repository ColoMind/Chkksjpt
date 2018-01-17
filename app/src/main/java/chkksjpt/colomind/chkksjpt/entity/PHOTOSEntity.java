package chkksjpt.colomind.chkksjpt.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/7/28.
 */
@DatabaseTable(tableName = "TB_PHOTOS")
public class PHOTOSEntity implements Serializable{
    @DatabaseField(generatedId = true,columnName = "idd",useGetSet = true)
    private int idd;

    @DatabaseField(columnName ="upperson",useGetSet = true)
    private String upperson;//上传用户名

    @DatabaseField(columnName ="userid",useGetSet = true)
    private String userid;//用户编号

    @DatabaseField(columnName ="type",useGetSet = true)
    private String type;//照片类别

    @DatabaseField(columnName ="photopaths",useGetSet = true)
    private String photopaths;//照片路径

    @DatabaseField(columnName ="dzptbh",useGetSet = true)
    private String dzptbh;//地灾编号

    @DatabaseField(columnName ="remark",useGetSet = true)
    private String remark;//备注

    @DatabaseField(columnName ="X",useGetSet = true)
    private String X;//X

    @DatabaseField(columnName ="Y",useGetSet = true)
    private String Y;//Y

    @DatabaseField(columnName ="tbname",useGetSet = true)
    private String tbname;//Y

    @DatabaseField(columnName ="wen",useGetSet = true)
    private String picpath;//Y


    @Override
    public String toString() {
        return "PHOTOSEntity{" +
                "idd=" + idd +
                ", upperson='" + upperson + '\'' +
                ", userid='" + userid + '\'' +
                ", type='" + type + '\'' +
                ", photopaths=" + photopaths +
                ", dzptbh='" + dzptbh + '\'' +
                ", remark='" + remark + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", tbname='" + tbname + '\'' +
                ", picpath='" + picpath + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getUpperson() {
        return upperson;
    }

    public void setUpperson(String upperson) {
        this.upperson = upperson;
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

    public String getDzptbh() {
        return dzptbh;
    }

    public void setDzptbh(String dzptbh) {
        this.dzptbh = dzptbh;
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

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }
}
