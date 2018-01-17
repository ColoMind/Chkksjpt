package chkksjpt.colomind.chkksjpt.entity.ZMXX;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/11 0011.
 */
@DatabaseTable(tableName = "TB_ZMXX")//灾民信息实体类
public class ZMCYEntity implements Serializable {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "HID",useGetSet = true)
    private String HID;//户ID

    @DatabaseField(columnName = "JMXM",useGetSet = true)
    private String JMXM; //灾民姓名

    @DatabaseField(columnName = "JMGX",useGetSet = true)
    private String JMGX;//与户主关系

    @DatabaseField(columnName = "TEL",useGetSet = true)
    private String TEL;//电话

    @DatabaseField(columnName = "XB",useGetSet = true)
    private String XB;//性别

    @DatabaseField(columnName = "SFZH",useGetSet = true)
    private String SFZH;//身份证号

    @DatabaseField(columnName = "Picture",useGetSet = true)
    private String Picture;//灾民图片

    @DatabaseField(columnName = "ZHDBH",useGetSet = true)
    private String ZHDBH;//灾害点编号

    @DatabaseField(columnName = "Coorstr",useGetSet = true)
    private String Coorstr;//面字符串(废除)

    @DatabaseField(columnName = "NL",useGetSet = true)
    private String NL;//年龄

    @DatabaseField(columnName = "XL",useGetSet = true)
    private String XL;//学历

    @DatabaseField(columnName = "SFXS",useGetSet = true)
    private String SFXS;//是否学生

    @DatabaseField(columnName = "JDXX",useGetSet = true)
    private String JDXX;//就读学校

    @DatabaseField(columnName = "ZJQK",useGetSet = true)
    private String ZJQK;//在家情况


    public ZMCYEntity() {
    }

    @Override
    public String toString() {
        return "ZMCYEntity{" +
                "idd=" + idd +
                ", HID='" + HID + '\'' +
                ", JMXM='" + JMXM + '\'' +
                ", JMGX='" + JMGX + '\'' +
                ", TEL='" + TEL + '\'' +
                ", XB='" + XB + '\'' +
                ", SFZH='" + SFZH + '\'' +
                ", Picture='" + Picture + '\'' +
                ", ZHDBH='" + ZHDBH + '\'' +
                ", Coorstr='" + Coorstr + '\'' +
                ", NL='" + NL + '\'' +
                ", XL='" + XL + '\'' +
                ", SFXS='" + SFXS + '\'' +
                ", JDXX='" + JDXX + '\'' +
                ", ZJQK='" + ZJQK + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getHID() {
        return HID;
    }

    public void setHID(String HID) {
        this.HID = HID;
    }

    public String getJMXM() {
        return JMXM;
    }

    public void setJMXM(String JMXM) {
        this.JMXM = JMXM;
    }

    public String getJMGX() {
        return JMGX;
    }

    public void setJMGX(String JMGX) {
        this.JMGX = JMGX;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getSFZH() {
        return SFZH;
    }

    public void setSFZH(String SFZH) {
        this.SFZH = SFZH;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getZHDBH() {
        return ZHDBH;
    }

    public void setZHDBH(String ZHDBH) {
        this.ZHDBH = ZHDBH;
    }

    public String getCoorstr() {
        return Coorstr;
    }

    public void setCoorstr(String coorstr) {
        Coorstr = coorstr;
    }

    public String getXL() {
        return XL;
    }

    public void setXL(String XL) {
        this.XL = XL;
    }

    public String getNL() {
        return NL;
    }

    public void setNL(String NL) {
        this.NL = NL;
    }

    public String getSFXS() {
        return SFXS;
    }

    public void setSFXS(String SFXS) {
        this.SFXS = SFXS;
    }

    public String getJDXX() {
        return JDXX;
    }

    public void setJDXX(String JDXX) {
        this.JDXX = JDXX;
    }

    public String getZJQK() {
        return ZJQK;
    }

    public void setZJQK(String ZJQK) {
        this.ZJQK = ZJQK;
    }
}
