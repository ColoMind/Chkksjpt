package chkksjpt.colomind.chkksjpt.entity.ZMXX;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by CHENLI on 2016/3/8.
 */
@DatabaseTable(tableName = "TB_SZH")
public class SZHEntity implements Serializable {
    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "HID",useGetSet = true)
    private String HID; //户ID

    @DatabaseField(columnName = "HZXM",useGetSet = true)
    private String HZXM;//户主姓名

    @DatabaseField(columnName = "SFZH",useGetSet = true)
    private String SFZH;//身份证号

    @DatabaseField(columnName = "TEL",useGetSet = true)
    private String TEL;//电话

    @DatabaseField(columnName = "ZHDBH",useGetSet = true)
    private String ZHDBH;//灾害点编号

    @DatabaseField(columnName = "Coorstr",useGetSet = true)
    private String Coorstr;//面字符串

    @DatabaseField(columnName = "GD",useGetSet = true)
    private String GD;//耕地

    @DatabaseField(columnName = "YD",useGetSet = true)
    private String YD;//园地

    @DatabaseField(columnName = "LD",useGetSet = true)
    private String LD;//林地

    @DatabaseField(columnName = "HD",useGetSet = true)
    private String HD;//荒地

    @DatabaseField(columnName = "NIOU",useGetSet = true)
    private String NIOU;//牛

    @DatabaseField(columnName = "Yang",useGetSet = true)
    private String Yang;//羊

    @DatabaseField(columnName = "Zhu",useGetSet = true)
    private String Zhu;//猪

    @DatabaseField(columnName = "gou",useGetSet = true)
    private String gou;//狗

    @DatabaseField(columnName = "Ji",useGetSet = true)
    private String Ji;//鸡

    @DatabaseField(columnName = "ya",useGetSet = true)
    private String ya;//鸭

    @DatabaseField(columnName = "JTQK",useGetSet = true)
    private String JTQK;//交通情况

    @DatabaseField(columnName = "Picture",useGetSet = true)
    private String Picture;//房屋图片

    @DatabaseField(columnName = "FWID",useGetSet = true)
    private String FWID;//房屋ID

    @DatabaseField(columnName = "NAME",useGetSet = true)
    private String NAME;//房屋名称

    @DatabaseField(columnName = "LC",useGetSet = true)
    private String LC;//房屋楼层

    @DatabaseField(columnName = "HS",useGetSet = true)
    private String HS;//户数

    @DatabaseField(columnName = "RK",useGetSet = true)
    private String RK;//人口

    @DatabaseField(columnName = "FX",useGetSet = true)
    private String FX;//房屋点X坐标

    @DatabaseField(columnName = "FY",useGetSet = true)
    private String FY;//房屋点Y坐标


    public SZHEntity() {
    }

    @Override
    public String toString() {
        return "SZHEntity{" +
                "idd=" + idd +
                ", HID='" + HID + '\'' +
                ", HZXM='" + HZXM + '\'' +
                ", SFZH='" + SFZH + '\'' +
                ", TEL='" + TEL + '\'' +
                ", ZHDBH='" + ZHDBH + '\'' +
                ", Coorstr='" + Coorstr + '\'' +
                ", GD='" + GD + '\'' +
                ", YD='" + YD + '\'' +
                ", LD='" + LD + '\'' +
                ", HD='" + HD + '\'' +
                ", NIOU='" + NIOU + '\'' +
                ", Yang='" + Yang + '\'' +
                ", Zhu='" + Zhu + '\'' +
                ", gou='" + gou + '\'' +
                ", Ji='" + Ji + '\'' +
                ", ya='" + ya + '\'' +
                ", JTQK='" + JTQK + '\'' +
                ", Picture='" + Picture + '\'' +
                ", FWID='" + FWID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", LC='" + LC + '\'' +
                ", HS='" + HS + '\'' +
                ", RK='" + RK + '\'' +
                ", FX='" + FX + '\'' +
                ", FY='" + FY + '\'' +
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

    public String getHZXM() {
        return HZXM;
    }

    public void setHZXM(String HZXM) {
        this.HZXM = HZXM;
    }

    public String getSFZH() {
        return SFZH;
    }

    public void setSFZH(String SFZH) {
        this.SFZH = SFZH;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
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

    public String getGD() {
        return GD;
    }

    public void setGD(String GD) {
        this.GD = GD;
    }

    public String getLD() {
        return LD;
    }

    public void setLD(String LD) {
        this.LD = LD;
    }

    public String getYD() {
        return YD;
    }

    public void setYD(String YD) {
        this.YD = YD;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getNIOU() {
        return NIOU;
    }

    public void setNIOU(String NIOU) {
        this.NIOU = NIOU;
    }

    public String getYang() {
        return Yang;
    }

    public void setYang(String yang) {
        Yang = yang;
    }

    public String getZhu() {
        return Zhu;
    }

    public void setZhu(String zhu) {
        Zhu = zhu;
    }

    public String getGou() {
        return gou;
    }

    public void setGou(String gou) {
        this.gou = gou;
    }

    public String getJi() {
        return Ji;
    }

    public void setJi(String ji) {
        Ji = ji;
    }

    public String getYa() {
        return ya;
    }

    public void setYa(String ya) {
        this.ya = ya;
    }

    public String getJTQK() {
        return JTQK;
    }

    public void setJTQK(String JTQK) {
        this.JTQK = JTQK;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
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

    public String getFX() {
        return FX;
    }

    public void setFX(String FX) {
        this.FX = FX;
    }

    public String getFY() {
        return FY;
    }

    public void setFY(String FY) {
        this.FY = FY;
    }
}
