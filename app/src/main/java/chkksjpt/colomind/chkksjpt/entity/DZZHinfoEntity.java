package chkksjpt.colomind.chkksjpt.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by pang congcong on 2015/5/28.
 */

/**
 objId=null ;
 bh;//锟街猴拷锟斤拷锟斤拷
 ddr;//锟斤拷锟斤拷锟斤拷
 scry;//锟斤拷锟斤拷锟皆?
 fzzrr;//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
 fzzrrTel;//锟斤拷锟斤拷锟斤拷锟斤拷锟剿电话
 jczrr;//锟斤拷锟斤拷锟斤拷锟斤拷锟?
 jczzrTel;//锟斤拷锟斤拷锟斤拷锟斤拷说缁?
 xcms;//巡锟斤拷锟斤拷锟斤拷
 xcFiles;//巡锟斤拷锟侥硷拷
 */
@DatabaseTable(tableName = "TB_DZZHinfo")
public class DZZHinfoEntity implements Serializable {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "OBJID",useGetSet = true)
    private String objId;

    @DatabaseField(columnName = "BH",useGetSet = true)
    private String bh;

    @DatabaseField(columnName = "DDR",useGetSet = true)
    private String ddr;

    @DatabaseField(columnName = "SCRY",useGetSet = true)
    private String scry;

    @DatabaseField(columnName = "XCRYZPBH",useGetSet = true)
    private String xcryzpbh;//巡锟斤拷锟斤拷员锟斤拷片锟斤拷锟?

    @DatabaseField(columnName = "SCJCSJ",useGetSet = true)
    private String scjcsj;//锟较次硷拷锟斤拷锟斤拷锟?

    @DatabaseField(columnName = "BCJCSJ",useGetSet = true)
    private String bcjcsj;//锟斤拷锟轿硷拷锟斤拷锟斤拷锟?

    @DatabaseField(columnName = "JYQK",useGetSet = true)
    private String jyqk;//锟斤拷锟斤拷锟斤拷锟?

    @DatabaseField(columnName = "WYL",useGetSet = true)
    private String wyl;//位锟斤拷锟斤拷

    @DatabaseField(columnName = "CZWT",useGetSet = true)
    private String czwt;//锟斤拷锟斤拷锟斤拷锟斤拷

    @DatabaseField(columnName = "CLYJ",useGetSet = true)
    private String clyj;//锟斤拷锟斤拷锟斤拷锟?

    @DatabaseField(columnName = "CLJG",useGetSet = true)
    private String cljg;//锟斤拷锟斤拷锟斤拷

    @DatabaseField(columnName = "FZZRR",useGetSet = true)
    private String fzzrr;

    @DatabaseField(columnName = "FZZRRTEL",useGetSet = true)
    private String fzzrrTel;

    @DatabaseField(columnName = "JCZRR",useGetSet = true)
    private String jczrr;

    @DatabaseField(columnName = "JCZZRTEL",useGetSet = true)
    private String jczzrTel;

    @DatabaseField(columnName = "XCMS",useGetSet = true)
    private String xcms;

    @DatabaseField(columnName = "XCFILES",useGetSet = true)
    private String xcFiles;

    @DatabaseField(columnName = "Address",useGetSet = true)
    private String Address;

    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;

    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;

    //裂缝位置线坐标串
    @DatabaseField(columnName = "coordstrpl",useGetSet = true)
    private String coordstrpl;

    //影响范围面坐标串
    @DatabaseField(columnName = "coordstrpy1",useGetSet = true)
    private String coordstrpy1;

    //避险区域面面坐标串
    @DatabaseField(columnName = "coordstrpy2",useGetSet = true)
    private String coordstrpy2;


    @Override
    public String toString() {
        return "DZZHinfoEntity{" +
                "idd=" + idd +
                ", objId='" + objId + '\'' +
                ", bh='" + bh + '\'' +
                ", ddr='" + ddr + '\'' +
                ", scry='" + scry + '\'' +
                ", xcryzpbh='" + xcryzpbh + '\'' +
                ", scjcsj='" + scjcsj + '\'' +
                ", bcjcsj='" + bcjcsj + '\'' +
                ", jyqk='" + jyqk + '\'' +
                ", wyl='" + wyl + '\'' +
                ", czwt='" + czwt + '\'' +
                ", clyj='" + clyj + '\'' +
                ", cljg='" + cljg + '\'' +
                ", fzzrr='" + fzzrr + '\'' +
                ", fzzrrTel='" + fzzrrTel + '\'' +
                ", jczrr='" + jczrr + '\'' +
                ", jczzrTel='" + jczzrTel + '\'' +
                ", xcms='" + xcms + '\'' +
                ", xcFiles='" + xcFiles + '\'' +
                ", Address='" + Address + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", coordstrpl='" + coordstrpl + '\'' +
                ", coordstrpy1='" + coordstrpy1 + '\'' +
                ", coordstrpy2='" + coordstrpy2 + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getDdr() {
        return ddr;
    }

    public void setDdr(String ddr) {
        this.ddr = ddr;
    }

    public String getScry() {
        return scry;
    }

    public void setScry(String scry) {
        this.scry = scry;
    }

    public String getXcryzpbh() {
        return xcryzpbh;
    }

    public void setXcryzpbh(String xcryzpbh) {
        this.xcryzpbh = xcryzpbh;
    }

    public String getScjcsj() {
        return scjcsj;
    }

    public void setScjcsj(String scjcsj) {
        this.scjcsj = scjcsj;
    }

    public String getBcjcsj() {
        return bcjcsj;
    }

    public void setBcjcsj(String bcjcsj) {
        this.bcjcsj = bcjcsj;
    }

    public String getJyqk() {
        return jyqk;
    }

    public void setJyqk(String jyqk) {
        this.jyqk = jyqk;
    }

    public String getWyl() {
        return wyl;
    }

    public void setWyl(String wyl) {
        this.wyl = wyl;
    }

    public String getCzwt() {
        return czwt;
    }

    public void setCzwt(String czwt) {
        this.czwt = czwt;
    }

    public String getClyj() {
        return clyj;
    }

    public void setClyj(String clyj) {
        this.clyj = clyj;
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) {
        this.cljg = cljg;
    }

    public String getFzzrr() {
        return fzzrr;
    }

    public void setFzzrr(String fzzrr) {
        this.fzzrr = fzzrr;
    }

    public String getFzzrrTel() {
        return fzzrrTel;
    }

    public void setFzzrrTel(String fzzrrTel) {
        this.fzzrrTel = fzzrrTel;
    }

    public String getJczrr() {
        return jczrr;
    }

    public void setJczrr(String jczrr) {
        this.jczrr = jczrr;
    }

    public String getJczzrTel() {
        return jczzrTel;
    }

    public void setJczzrTel(String jczzrTel) {
        this.jczzrTel = jczzrTel;
    }

    public String getXcms() {
        return xcms;
    }

    public void setXcms(String xcms) {
        this.xcms = xcms;
    }

    public String getXcFiles() {
        return xcFiles;
    }

    public void setXcFiles(String xcFiles) {
        this.xcFiles = xcFiles;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getCoordstrpl() {
        return coordstrpl;
    }

    public void setCoordstrpl(String coordstrpl) {
        this.coordstrpl = coordstrpl;
    }

    public String getCoordstrpy1() {
        return coordstrpy1;
    }

    public void setCoordstrpy1(String coordstrpy1) {
        this.coordstrpy1 = coordstrpy1;
    }

    public String getCoordstrpy2() {
        return coordstrpy2;
    }

    public void setCoordstrpy2(String coordstrpy2) {
        this.coordstrpy2 = coordstrpy2;
    }
}
