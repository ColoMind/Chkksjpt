package chkksjpt.colomind.chkksjpt.entity.GYYD;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/11/3.
 */
@DatabaseTable(tableName = "TB_GYYD")
public class GYYDEntity implements Serializable {
    public GYYDEntity() {
    }

    @DatabaseField(generatedId = true,columnName = "Id",useGetSet = true)
    private int Id;
    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;
    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;
    @DatabaseField(columnName = "DKBH",useGetSet = true)
    private String DKBH;//地块编号
    @DatabaseField(columnName = "BPBH",useGetSet = true)
    private String BPBH;//报批编号
    @DatabaseField(columnName = "PZWH",useGetSet = true)
    private String PZWH;//批准文号
    @DatabaseField(columnName = "DKMJ",useGetSet = true)
    private String DKMJ;//地块面积
    @DatabaseField(columnName = "GDPFMC",useGetSet = true)
    private String GDPFMC;//供地批复名称
    @DatabaseField(columnName = "GDPFWH",useGetSet = true)
    private String GDPFWH;//供地批复文号
    @DatabaseField(columnName = "GDPFSJ",useGetSet = true)
    private String GDPFSJ;//供地批复时间
    @DatabaseField(columnName = "TDYT",useGetSet = true)
    private String TDYT;//土地用途
    @DatabaseField(columnName = "RJL",useGetSet = true)
    private String RJL;//容积率
    @DatabaseField(columnName = "JZMD",useGetSet = true)
    private String JZMD;//建筑密度
    @DatabaseField(columnName = "LHBL",useGetSet = true)
    private String LHBL;//绿化比率
    @DatabaseField(columnName = "GDFS",useGetSet = true)
    private String GDFS;//供地方式
    @DatabaseField(columnName = "YDDWMC",useGetSet = true)
    private String YDDWMC;//用地单位名称
    @DatabaseField(columnName = "YDXMMC",useGetSet = true)
    private String YDXMMC;//用地项目名称
    @DatabaseField(columnName = "CJJE",useGetSet = true)
    private String CJJE;//成交金额
    @DatabaseField(columnName = "HTBH",useGetSet = true)
    private String HTBH;//合同编号
    @DatabaseField(columnName = "HTYDJDSJ",useGetSet = true)
    private String HTYDJDSJ;//合同约定交地时间
    @DatabaseField(columnName = "HTYDDGSJ",useGetSet = true)
    private String HTYDDGSJ;//合同约定动工时间
    @DatabaseField(columnName = "HTYDJGSJ",useGetSet = true)
    private String HTYDJGSJ;//合同约定竣工时间
    @DatabaseField(columnName = "SJJDSJ",useGetSet = true)
    private String SJJDSJ;//实际交地时间
    @DatabaseField(columnName = "SQKGSJ",useGetSet = true)
    private String SQKGSJ;//申请开工时间
    @DatabaseField(columnName = "SJKGSJ",useGetSet = true)
    private String SJKGSJ;//实际开工时间
    @DatabaseField(columnName = "SJJGSJ",useGetSet = true)
    private String SJJGSJ;//实际竣工时间
    @DatabaseField(columnName = "JGHYSJ",useGetSet = true)
    private String JGHYSJ;//竣工核验时间
    @DatabaseField(columnName = "JGHYQK",useGetSet = true)
    private String JGHYQK;//竣工核验情况
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;//乡镇
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;//村
    @DatabaseField(columnName = "STRXY",useGetSet = true)
    private String STRXY;//面坐标串
    @DatabaseField(columnName = "PIC",useGetSet = true)
    private String PIC;//图片


    @Override
    public String toString() {
        return "GYYDEntity{" +
                "BPBH='" + BPBH + '\'' +
                ", Id=" + Id +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", DKBH='" + DKBH + '\'' +
                ", PZWH='" + PZWH + '\'' +
                ", DKMJ='" + DKMJ + '\'' +
                ", GDPFMC='" + GDPFMC + '\'' +
                ", GDPFWH='" + GDPFWH + '\'' +
                ", GDPFSJ='" + GDPFSJ + '\'' +
                ", TDYT='" + TDYT + '\'' +
                ", RJL='" + RJL + '\'' +
                ", JZMD='" + JZMD + '\'' +
                ", LHBL='" + LHBL + '\'' +
                ", GDFS='" + GDFS + '\'' +
                ", YDDWMC='" + YDDWMC + '\'' +
                ", YDXMMC='" + YDXMMC + '\'' +
                ", CJJE='" + CJJE + '\'' +
                ", HTBH='" + HTBH + '\'' +
                ", HTYDJDSJ='" + HTYDJDSJ + '\'' +
                ", HTYDDGSJ='" + HTYDDGSJ + '\'' +
                ", HTYDJGSJ='" + HTYDJGSJ + '\'' +
                ", SJJDSJ='" + SJJDSJ + '\'' +
                ", SQKGSJ='" + SQKGSJ + '\'' +
                ", SJKGSJ='" + SJKGSJ + '\'' +
                ", SJJGSJ='" + SJJGSJ + '\'' +
                ", JGHYSJ='" + JGHYSJ + '\'' +
                ", JGHYQK='" + JGHYQK + '\'' +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", STRXY='" + STRXY + '\'' +
                ", PIC='" + PIC + '\'' +
                '}';
    }

    public String getBPBH() {
        return BPBH;
    }

    public void setBPBH(String BPBH) {
        this.BPBH = BPBH;
    }

    public String getCJJE() {
        return CJJE;
    }

    public void setCJJE(String CJJE) {
        this.CJJE = CJJE;
    }

    public String getCUN() {
        return CUN;
    }

    public void setCUN(String CUN) {
        this.CUN = CUN;
    }

    public String getDKBH() {
        return DKBH;
    }

    public void setDKBH(String DKBH) {
        this.DKBH = DKBH;
    }

    public String getDKMJ() {
        return DKMJ;
    }

    public void setDKMJ(String DKMJ) {
        this.DKMJ = DKMJ;
    }

    public String getGDFS() {
        return GDFS;
    }

    public void setGDFS(String GDFS) {
        this.GDFS = GDFS;
    }

    public String getGDPFMC() {
        return GDPFMC;
    }

    public void setGDPFMC(String GDPFMC) {
        this.GDPFMC = GDPFMC;
    }

    public String getGDPFSJ() {
        return GDPFSJ;
    }

    public void setGDPFSJ(String GDPFSJ) {
        this.GDPFSJ = GDPFSJ;
    }

    public String getGDPFWH() {
        return GDPFWH;
    }

    public void setGDPFWH(String GDPFWH) {
        this.GDPFWH = GDPFWH;
    }

    public String getHTBH() {
        return HTBH;
    }

    public void setHTBH(String HTBH) {
        this.HTBH = HTBH;
    }

    public String getHTYDDGSJ() {
        return HTYDDGSJ;
    }

    public void setHTYDDGSJ(String HTYDDGSJ) {
        this.HTYDDGSJ = HTYDDGSJ;
    }

    public String getHTYDJDSJ() {
        return HTYDJDSJ;
    }

    public void setHTYDJDSJ(String HTYDJDSJ) {
        this.HTYDJDSJ = HTYDJDSJ;
    }

    public String getHTYDJGSJ() {
        return HTYDJGSJ;
    }

    public void setHTYDJGSJ(String HTYDJGSJ) {
        this.HTYDJGSJ = HTYDJGSJ;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getJGHYQK() {
        return JGHYQK;
    }

    public void setJGHYQK(String JGHYQK) {
        this.JGHYQK = JGHYQK;
    }

    public String getJGHYSJ() {
        return JGHYSJ;
    }

    public void setJGHYSJ(String JGHYSJ) {
        this.JGHYSJ = JGHYSJ;
    }

    public String getJZMD() {
        return JZMD;
    }

    public void setJZMD(String JZMD) {
        this.JZMD = JZMD;
    }

    public String getLHBL() {
        return LHBL;
    }

    public void setLHBL(String LHBL) {
        this.LHBL = LHBL;
    }

    public String getPIC() {
        return PIC;
    }

    public void setPIC(String PIC) {
        this.PIC = PIC;
    }

    public String getPZWH() {
        return PZWH;
    }

    public void setPZWH(String PZWH) {
        this.PZWH = PZWH;
    }

    public String getRJL() {
        return RJL;
    }

    public void setRJL(String RJL) {
        this.RJL = RJL;
    }

    public String getSJJDSJ() {
        return SJJDSJ;
    }

    public void setSJJDSJ(String SJJDSJ) {
        this.SJJDSJ = SJJDSJ;
    }

    public String getSJJGSJ() {
        return SJJGSJ;
    }

    public void setSJJGSJ(String SJJGSJ) {
        this.SJJGSJ = SJJGSJ;
    }

    public String getSJKGSJ() {
        return SJKGSJ;
    }

    public void setSJKGSJ(String SJKGSJ) {
        this.SJKGSJ = SJKGSJ;
    }

    public String getSQKGSJ() {
        return SQKGSJ;
    }

    public void setSQKGSJ(String SQKGSJ) {
        this.SQKGSJ = SQKGSJ;
    }

    public String getSTRXY() {
        return STRXY;
    }

    public void setSTRXY(String STRXY) {
        this.STRXY = STRXY;
    }

    public String getTDYT() {
        return TDYT;
    }

    public void setTDYT(String TDYT) {
        this.TDYT = TDYT;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getXZ() {
        return XZ;
    }

    public void setXZ(String XZ) {
        this.XZ = XZ;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getYDDWMC() {
        return YDDWMC;
    }

    public void setYDDWMC(String YDDWMC) {
        this.YDDWMC = YDDWMC;
    }

    public String getYDXMMC() {
        return YDXMMC;
    }

    public void setYDXMMC(String YDXMMC) {
        this.YDXMMC = YDXMMC;
    }
}
