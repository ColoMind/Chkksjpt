package chkksjpt.colomind.chkksjpt.entity.YDXC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/8/12.
 */
@DatabaseTable(tableName = "TB_WPZFRW")
public class
        WPZFRWEntity implements Serializable {
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "ZXRBH",useGetSet = true)
    private String ZXRBH;//ִ���˱��
    @DatabaseField(columnName = "TBBH",useGetSet = true)
    private String TBBH;//ͼ�߱��
    @DatabaseField(columnName = "CLZT",useGetSet = true)
    private String CLZT;//����״̬
    @DatabaseField(columnName = "XFRQ",useGetSet = true)
    private String XFRQ;//�·�����
    @DatabaseField(columnName = "TBLX",useGetSet = true)
    private String TBLX;//ͼ������
    @DatabaseField(columnName = "SFWF",useGetSet = true)
    private String SFWF;//�Ƿ�Υ��
    @DatabaseField(columnName = "XY",useGetSet = true)
    private String XY;//ͼ�����괮
    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;//ƽ������
    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;//����
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;//��
    @DatabaseField(columnName = "XDM",useGetSet = true)
    private String XDM;//С����
    @DatabaseField(columnName = "WFLX",useGetSet = true)
    private String WFLX;//Υ������
    @DatabaseField(columnName = "ZDMJ",useGetSet = true)
    private String ZDMJ;//ռ�����
    @DatabaseField(columnName = "NYD",useGetSet = true)
    private String NYD;//ũ�õ�
    @DatabaseField(columnName = "GD",useGetSet = true)
    private String GD;//����
    @DatabaseField(columnName = "JBNT",useGetSet = true)
    private String JBNT;//����ũ��
    @DatabaseField(columnName = "WLYD",useGetSet = true)
    private String WLYD;//δ���õ����
    @DatabaseField(columnName = "FHGH",useGetSet = true)
    private String FHGH;//���Ϲ滮���
    @DatabaseField(columnName = "BFHGH",useGetSet = true)
    private String BFHGH;//�����Ϲ滮���
    @DatabaseField(columnName = "YDDW",useGetSet = true)
    private String YDDW;//�õص�λ
    @DatabaseField(columnName = "DWXZ",useGetSet = true)
    private String DWXZ;//��λ����
    @DatabaseField(columnName = "ZRR",useGetSet = true)
    private String ZRR;//������
    @DatabaseField(columnName = "ZRRTel",useGetSet = true)
    private String ZRRTel;//�����˵绰
    @DatabaseField(columnName = "Email",useGetSet = true)
    private String Email;
    @DatabaseField(columnName = "SEX",useGetSet = true)
    private String SEX;//�Ա�
    @DatabaseField(columnName = "MZ",useGetSet = true)
    private String MZ;//����
    @DatabaseField(columnName = "WHCD",useGetSet = true)
    private String WHCD;//�Ļ��̶�
    @DatabaseField(columnName = "WFZZCS",useGetSet = true)
    private String WFZZCS;//Υ����ֹ��ʩ
    @DatabaseField(columnName = "WFZZJG",useGetSet = true)
    private String WFZZJG;//Υ����ֹ���
    @DatabaseField(columnName = "PIC",useGetSet = true)
    private String PIC;//Υ������


    @Override
    public String toString() {
        return "WPZFRWEntity{" +
                "id=" + id +
                ", ZXRBH='" + ZXRBH + '\'' +
                ", TBBH='" + TBBH + '\'' +
                ", CLZT='" + CLZT + '\'' +
                ", XFRQ='" + XFRQ + '\'' +
                ", TBLX='" + TBLX + '\'' +
                ", SFWF='" + SFWF + '\'' +
                ", XY='" + XY + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", XDM='" + XDM + '\'' +
                ", WFLX='" + WFLX + '\'' +
                ", ZDMJ='" + ZDMJ + '\'' +
                ", NYD='" + NYD + '\'' +
                ", GD='" + GD + '\'' +
                ", JBNT='" + JBNT + '\'' +
                ", WLYD='" + WLYD + '\'' +
                ", FHGH='" + FHGH + '\'' +
                ", BFHGH='" + BFHGH + '\'' +
                ", YDDW='" + YDDW + '\'' +
                ", DWXZ='" + DWXZ + '\'' +
                ", ZRR='" + ZRR + '\'' +
                ", ZRRTel='" + ZRRTel + '\'' +
                ", Email='" + Email + '\'' +
                ", SEX='" + SEX + '\'' +
                ", MZ='" + MZ + '\'' +
                ", WHCD='" + WHCD + '\'' +
                ", WFZZCS='" + WFZZCS + '\'' +
                ", WFZZJG='" + WFZZJG + '\'' +
                ", PIC='" + PIC + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZXRBH() {
        return ZXRBH;
    }

    public void setZXRBH(String ZXRBH) {
        this.ZXRBH = ZXRBH;
    }

    public String getTBBH() {
        return TBBH;
    }

    public void setTBBH(String TBBH) {
        this.TBBH = TBBH;
    }

    public String getCLZT() {
        return CLZT;
    }

    public void setCLZT(String CLZT) {
        this.CLZT = CLZT;
    }

    public String getXFRQ() {
        return XFRQ;
    }

    public void setXFRQ(String XFRQ) {
        this.XFRQ = XFRQ;
    }

    public String getTBLX() {
        return TBLX;
    }

    public void setTBLX(String TBLX) {
        this.TBLX = TBLX;
    }

    public String getSFWF() {
        return SFWF;
    }

    public void setSFWF(String SFWF) {
        this.SFWF = SFWF;
    }

    public String getXY() {
        return XY;
    }

    public void setXY(String XY) {
        this.XY = XY;
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

    public String getWFLX() {
        return WFLX;
    }

    public void setWFLX(String WFLX) {
        this.WFLX = WFLX;
    }

    public String getZDMJ() {
        return ZDMJ;
    }

    public void setZDMJ(String ZDMJ) {
        this.ZDMJ = ZDMJ;
    }

    public String getNYD() {
        return NYD;
    }

    public void setNYD(String NYD) {
        this.NYD = NYD;
    }

    public String getGD() {
        return GD;
    }

    public void setGD(String GD) {
        this.GD = GD;
    }

    public String getJBNT() {
        return JBNT;
    }

    public void setJBNT(String JBNT) {
        this.JBNT = JBNT;
    }

    public String getWLYD() {
        return WLYD;
    }

    public void setWLYD(String WLYD) {
        this.WLYD = WLYD;
    }

    public String getFHGH() {
        return FHGH;
    }

    public void setFHGH(String FHGH) {
        this.FHGH = FHGH;
    }

    public String getBFHGH() {
        return BFHGH;
    }

    public void setBFHGH(String BFHGH) {
        this.BFHGH = BFHGH;
    }

    public String getYDDW() {
        return YDDW;
    }

    public void setYDDW(String YDDW) {
        this.YDDW = YDDW;
    }

    public String getDWXZ() {
        return DWXZ;
    }

    public void setDWXZ(String DWXZ) {
        this.DWXZ = DWXZ;
    }

    public String getZRR() {
        return ZRR;
    }

    public void setZRR(String ZRR) {
        this.ZRR = ZRR;
    }

    public String getZRRTel() {
        return ZRRTel;
    }

    public void setZRRTel(String ZRRTel) {
        this.ZRRTel = ZRRTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getMZ() {
        return MZ;
    }

    public void setMZ(String MZ) {
        this.MZ = MZ;
    }

    public String getWHCD() {
        return WHCD;
    }

    public void setWHCD(String WHCD) {
        this.WHCD = WHCD;
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

    public String getPIC() {
        return PIC;
    }

    public void setPIC(String PIC) {
        this.PIC = PIC;
    }
}
