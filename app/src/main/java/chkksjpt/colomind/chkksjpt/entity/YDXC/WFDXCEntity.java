package chkksjpt.colomind.chkksjpt.entity.YDXC;

import chkksjpt.colomind.chkksjpt.httputils.Warning;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**Υ����Ѳ���¼ʵ����
 * Created by EMonegiser on 2015/6/28.
 */
@DatabaseTable(tableName = "TB_WFDXCJL")
public class WFDXCEntity implements Serializable{

    @DatabaseField(generatedId = true,columnName = "Id",useGetSet = true)
    private int Id;
    @DatabaseField(columnName = "WFDBH",useGetSet = true)
    String WFDBH;//违法点编号
    @DatabaseField(columnName = "RWBH",useGetSet = true)
    String RWBH;//违法点编号
    @DatabaseField(columnName = "XZ",useGetSet = true)
    String XZ;
    @DatabaseField(columnName = "CUN",useGetSet = true)
    String CUN;
    @DatabaseField(columnName = "XDM",useGetSet = true)
    String XDM;
    @DatabaseField(columnName = "WFZZCS",useGetSet = true)
    String WFZZCS;//违法制止措施
    @DatabaseField(columnName = "WFZZJG",useGetSet = true)
    String WFZZJG;//违法点制止结果
    @DatabaseField(columnName = "ZP",useGetSet = true)
    String ZP;//照片
    @DatabaseField(columnName = "SP",useGetSet = true)
    String SP;//视频
    @DatabaseField(columnName = "QKSM",useGetSet = true)
    String QKSM;//情况说明
    @DatabaseField(columnName = "ZZSJ",useGetSet = true)
    String ZZSJ;//处置时间
    @DatabaseField(columnName = "FZR",useGetSet = true)
    String FZR;//负责人
    @DatabaseField(columnName = "CYRY",useGetSet = true)
    String CYRY;//参与人员
    @DatabaseField(columnName = "QTCYRY",useGetSet = true)
    String QTCYRY;//其他参与人员

    @Warning("这段代码不能改动，不能在每个字段名前后加空格或其他字符，否则无法上传")
    @Override
    public String toString() {
        return "{" +
                "WFDBH='" + WFDBH + '\'' +
                ",RWBH='" + RWBH + '\'' +
                ",XZ='" + XZ + '\'' +
                ",CUN='" + CUN + '\'' +
                ",XDM='" + XDM + '\'' +
                ",WFZZCS='" + WFZZCS + '\'' +
                ",WFZZJG='" + WFZZJG + '\'' +
                ",ZP='" + ZP + '\'' +
                ",SP='" + SP + '\'' +
                ",QKSM='" + QKSM + '\'' +
                ",ZZSJ='" + ZZSJ + '\'' +
                ",FZR='" + FZR + '\'' +
                ",CYRY='" + CYRY + '\'' +
                ",QTCYRY='" + QTCYRY + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getWFDBH() {
        return WFDBH;
    }

    public void setWFDBH(String WFDBH) {
        this.WFDBH = WFDBH;
    }

    public String getRWBH() {
        return RWBH;
    }

    public void setRWBH(String RWBH) {
        this.RWBH = RWBH;
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

    public String getXDM() {
        return XDM;
    }

    public void setXDM(String XDM) {
        this.XDM = XDM;
    }

    public String getWFZZCS() {
        return WFZZCS;
    }

    public void setWFZZCS(String WFZZCS) {
        this.WFZZCS = WFZZCS;
    }

    public String getWFZZJG() {
        return WFZZJG;
    }

    public void setWFZZJG(String WFZZJG) {
        this.WFZZJG = WFZZJG;
    }

    public String getZP() {
        return ZP;
    }

    public void setZP(String ZP) {
        this.ZP = ZP;
    }

    public String getSP() {
        return SP;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public String getQKSM() {
        return QKSM;
    }

    public void setQKSM(String QKSM) {
        this.QKSM = QKSM;
    }

    public String getZZSJ() {
        return ZZSJ;
    }

    public void setZZSJ(String ZZSJ) {
        this.ZZSJ = ZZSJ;
    }

    public String getFZR() {
        return FZR;
    }

    public void setFZR(String FZR) {
        this.FZR = FZR;
    }

    public String getCYRY() {
        return CYRY;
    }

    public void setCYRY(String CYRY) {
        this.CYRY = CYRY;
    }

    public String getQTCYRY() {
        return QTCYRY;
    }

    public void setQTCYRY(String QTCYRY) {
        this.QTCYRY = QTCYRY;
    }
}
