package chkksjpt.colomind.chkksjpt.entity.YDXC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import chkksjpt.colomind.chkksjpt.httputils.Warning;

/**锟斤�?????????????
 * Created by pangcongcong on 2015/6/28.
 */
@DatabaseTable(tableName = "TB_WFD")
public class WFDEntity implements Serializable{

    public WFDEntity() {
    }

    @DatabaseField(generatedId = true,columnName = "Id",useGetSet = true)
    private int Id;
    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;
    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;
    @DatabaseField(columnName = "FXSJ",useGetSet = true)
    private String FXSJ;//违锟斤拷锟姐发锟斤拷时锟斤拷
    //违锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷�?
    @DatabaseField(columnName = "YDDW",useGetSet = true)
    private String YDDW;//锟矫地碉拷位锟斤拷锟斤拷锟剿ｏ拷
    @DatabaseField(columnName = "DWXZ",useGetSet = true)
    private String DWXZ;//锟斤拷位锟斤拷锟斤拷
    @DatabaseField(columnName = "ZRR",useGetSet = true)
    private String ZRR;//锟斤拷锟斤拷锟斤�?
    @DatabaseField(columnName = "LXDH",useGetSet = true)
    private String LXDH;//锟斤拷系锟界�?
    @DatabaseField(columnName = "Email",useGetSet = true)
    private String Email;//锟绞硷拷
    @DatabaseField(columnName = "SEX",useGetSet = true)
    private String SEX;//锟皆憋拷
    @DatabaseField(columnName = "MZ",useGetSet = true)
    private String MZ;//锟斤拷锟斤拷
    @DatabaseField(columnName = "WHCD",useGetSet = true)
    private String WHCD;//锟侥伙拷锟教讹拷

    //锟斤拷锟斤拷违锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷锟街讹�?
    @DatabaseField(columnName = "RWBH",useGetSet = true)
    private String RWBH;//锟斤拷锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "WFDBH",useGetSet = true)
    private String WFDBH;//违锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "WFLXBH",useGetSet = true)
    private String WFLXBH;//违锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "E",useGetSet = true)
    private String E;//锟斤拷锟斤拷
    @DatabaseField(columnName = "N",useGetSet = true)
    private String N;//纬锟斤拷
    @DatabaseField(columnName = "SZXZ",useGetSet = true)
    private String SZXZ;//锟斤拷锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "SZC",useGetSet = true)
    private String SZC;//锟斤拷锟节达�?
    @DatabaseField(columnName = "XDM",useGetSet = true)
    private String XDM;//小锟斤拷锟斤�?
    @DatabaseField(columnName = "WFZLBH",useGetSet = true)
    private String WFZLBH;//违锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "SJYT",useGetSet = true)
    private String SJYT;//实锟斤拷锟斤拷�??
    @DatabaseField(columnName = "QSXZ",useGetSet = true)
    private String QSXZ;//权锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "XMLX",useGetSet = true)
    private String XMLX;//锟斤拷目锟斤拷锟斤拷
    @DatabaseField(columnName = "ZMJ",useGetSet = true)
    private String ZMJ;//占锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷页锟斤拷
    @DatabaseField(columnName = "ZP",useGetSet = true)
    private String ZP;//锟街筹拷锟斤拷锟秸碉拷锟侥硷拷锟斤拷
    @DatabaseField(columnName = "VEDIO",useGetSet = true)
    private String VEDIO;//锟街筹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷
    @DatabaseField(columnName = "ZYNYDMJ",useGetSet = true)
    private String ZYNYDMJ;//农锟矫碉拷锟斤拷锟斤�?

    @DatabaseField(columnName = "ZYGDMJ",useGetSet = true)
    private String ZYGDMJ;
    @DatabaseField(columnName = "ZYJBNTMJ",useGetSet = true)
    private String ZYJBNTMJ;
    @DatabaseField(columnName = "ZYWLYDMJ",useGetSet = true)
    private String ZYWLYDMJ;//未锟斤拷锟矫碉拷锟斤拷锟斤拷
    @DatabaseField(columnName = "FHGHMJ",useGetSet = true)
    private String FHGHMJ;//锟斤拷锟较规划锟矫碉拷锟斤拷锟斤�?
    @DatabaseField(columnName = "BFHGHMJ",useGetSet = true)
    private String BFHGHMJ;
    @DatabaseField(columnName = "TBR",useGetSet = true)
    private String TBR;//锟斤拷锟斤拷锟斤�?
    @DatabaseField(columnName = "QKSM",useGetSet = true)
    private String QKSM;//���˵��
    @DatabaseField(columnName = "CYRY",useGetSet = true)
    private String CYRY;
    @DatabaseField(columnName = "QTCYRY",useGetSet = true)
    private String QTCYRY;
    @DatabaseField(columnName = "ZZCS",useGetSet = true)
    private String ZZCS;
    @DatabaseField(columnName = "ZZJG",useGetSet = true)
    private String ZZJG;

    @DatabaseField(columnName = "TBZB",useGetSet = true)
    private String TBZB;

    @Warning("��δ��벻�ܸĶ���������ÿ���ֶ���ǰ��ӿո�������ַ��������޷��ϴ�")
    @Override
    public String toString() {
        return "{" +
                "X='" + X + '\'' +
                ",Y='" + Y + '\'' +
                ",FXSJ='" + FXSJ + '\'' +
                ",YDDW='" + YDDW + '\'' +
                ",DWXZ='" + DWXZ + '\'' +
                ",ZRR='" + ZRR + '\'' +
                ",LXDH='" + LXDH + '\'' +
                ",Email='" + Email + '\'' +
                ",SEX='" + SEX + '\'' +
                ",MZ='" + MZ + '\'' +
                ",WHCD='" + WHCD + '\'' +
                ",RWBH='" + RWBH + '\'' +
                ",WFDBH='" + WFDBH + '\'' +
                ",WFLXBH='" + WFLXBH + '\'' +
                ",E='" + E + '\'' +
                ",N='" + N + '\'' +
                ",SZXZ='" + SZXZ + '\'' +
                ",SZC='" + SZC + '\'' +
                ",XDM='" + XDM + '\'' +
                ",WFZLBH='" + WFZLBH + '\'' +
                ",SJYT='" + SJYT + '\'' +
                ",QSXZ='" + QSXZ + '\'' +
                ",XMLX='" + XMLX + '\'' +
                ",ZMJ='" + ZMJ + '\'' +
                ",ZP='" + ZP + '\'' +
                ",VEDIO='" + VEDIO + '\'' +
                ",ZYNYDMJ='" + ZYNYDMJ + '\'' +
                ",ZYGDMJ='" + ZYGDMJ + '\'' +
                ",ZYJBNTMJ='" + ZYJBNTMJ + '\'' +
                ",ZYWLYDMJ='" + ZYWLYDMJ + '\'' +
                ",FHGHMJ='" + FHGHMJ + '\'' +
                ",BFHGHMJ='" + BFHGHMJ + '\'' +
                ",TBR='" + TBR + '\'' +
                ",QKSM='" + QKSM + '\'' +
                ",CYRY='" + CYRY + '\'' +
                ",QTCYRY='" + QTCYRY + '\'' +
                ",ZZCS='" + ZZCS + '\'' +
                ",ZZJG='" + ZZJG + '\'' +
                ",TBZB='" + TBZB + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getFXSJ() {
        return FXSJ;
    }

    public void setFXSJ(String FXSJ) {
        this.FXSJ = FXSJ;
    }

    public String getYDDW() {
        return YDDW;
    }

    public String getQKSM() {
        return QKSM;
    }

    public void setQKSM(String QKSM) {
        this.QKSM = QKSM;
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

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
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

    public void setSEX(String sex) {
        SEX = sex;
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

    public String getRWBH() {
        return RWBH;
    }

    public void setRWBH(String RWBH) {
        this.RWBH = RWBH;
    }

    public String getWFDBH() {
        return WFDBH;
    }

    public void setWFDBH(String WFDBH) {
        this.WFDBH = WFDBH;
    }

    public String getWFLXBH() {
        return WFLXBH;
    }

    public void setWFLXBH(String WFLX) {
        this.WFLXBH = WFLX;
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

    public String getSZXZ() {
        return SZXZ;
    }

    public void setSZXZ(String SZXZ) {
        this.SZXZ = SZXZ;
    }

    public String getSZC() {
        return SZC;
    }

    public void setSZC(String SZC) {
        this.SZC = SZC;
    }

    public String getXDM() {
        return XDM;
    }

    public void setXDM(String XDM) {
        this.XDM = XDM;
    }

    public String getWFZLBH() {
        return WFZLBH;
    }

    public void setWFZLBH(String WFZL) {
        this.WFZLBH = WFZL;
    }

    public String getSJYT() {
        return SJYT;
    }

    public void setSJYT(String SJYT) {
        this.SJYT = SJYT;
    }

    public String getQSXZ() {
        return QSXZ;
    }

    public void setQSXZ(String QSXZ) {
        this.QSXZ = QSXZ;
    }

    public String getXMLX() {
        return XMLX;
    }

    public void setXMLX(String XMLX) {
        this.XMLX = XMLX;
    }

    public String getZMJ() {
        return ZMJ;
    }

    public void setZMJ(String ZMJ) {
        this.ZMJ = ZMJ;
    }

    public String getZP() {
        return ZP;
    }

    public void setZP(String ZP) {
        this.ZP = ZP;
    }

    public String getVEDIO() {
        return VEDIO;
    }

    public void setVEDIO(String VEDIO) {
        this.VEDIO = VEDIO;
    }

    public String getZYNYDMJ() {
        return ZYNYDMJ;
    }

    public void setZYNYDMJ(String ZYNYDMJ) {
        this.ZYNYDMJ = ZYNYDMJ;
    }

    public String getZYGDMJ() {
        return ZYGDMJ;
    }

    public void setZYGDMJ(String ZYGDMJ) {
        this.ZYGDMJ = ZYGDMJ;
    }

    public String getZYJBNTMJ() {
        return ZYJBNTMJ;
    }

    public void setZYJBNTMJ(String ZYJBNTMJ) {
        this.ZYJBNTMJ = ZYJBNTMJ;
    }

    public String getZYWLYDMJ() {
        return ZYWLYDMJ;
    }

    public void setZYWLYDMJ(String ZYWLYDMJ) {
        this.ZYWLYDMJ = ZYWLYDMJ;
    }

    public String getFHGHMJ() {
        return FHGHMJ;
    }

    public void setFHGHMJ(String FHGHMJ) {
        this.FHGHMJ = FHGHMJ;
    }

    public String getBFHGHMJ() {
        return BFHGHMJ;
    }

    public void setBFHGHMJ(String BFHGHMJ) {
        this.BFHGHMJ = BFHGHMJ;
    }

    public String getTBR() {
        return TBR;
    }

    public void setTBR(String TBR) {
        this.TBR = TBR;
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

    public String getZZCS() {
        return ZZCS;
    }

    public void setZZCS(String ZZCS) {
        this.ZZCS = ZZCS;
    }

    public String getZZJG() {
        return ZZJG;
    }

    public void setZZJG(String ZZJG) {
        this.ZZJG = ZZJG;
    }

    public String getTBZB() {
        return TBZB;
    }

    public void setTBZB(String TBZB) {
        this.TBZB = TBZB;
    }
}
