package chkksjpt.colomind.chkksjpt.entity.YDXC;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import chkksjpt.colomind.chkksjpt.httputils.Warning;

/**卫片执法信息填报实体类
 * Created by pangcongcong on 2015/8/17.
 */
    @DatabaseTable(tableName = "TB_WPZFXXTB")
   public class WPZFXXTBEntity implements Serializable{

    public WPZFXXTBEntity() {
    }

    @DatabaseField(generatedId = true,columnName = "Id",useGetSet = true)
    private int Id;
    @DatabaseField(columnName = "TBBH",useGetSet = true)
    private String TBBH;//锟斤拷锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;
    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;//锟斤拷锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;//锟斤拷锟节达�?
    @DatabaseField(columnName = "XDM",useGetSet = true)
    private String XDM;//小锟斤拷锟斤�?
    @DatabaseField(columnName = "SFWF",useGetSet = true)
    private String SFWF;//�Ƿ�Υ��
    @DatabaseField(columnName = "WFZL",useGetSet = true)
    private String WFZL;//违锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "SJYT",useGetSet = true)
    private String SJYT;//实锟斤拷锟斤拷�??
    @DatabaseField(columnName = "QSXZ",useGetSet = true)
    private String QSXZ;//权锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "XMLX",useGetSet = true)
    private String XMLX;//锟斤拷目锟斤拷锟斤拷
    @DatabaseField(columnName = "XKZZL",useGetSet = true)
    private String XKZZL;
    @DatabaseField(columnName = "XKZH",useGetSet = true)
    private String XKZH;
    @DatabaseField(columnName = "KZ",useGetSet = true)
    private String KZ;
    @DatabaseField(columnName = "ZDMJ",useGetSet = true)
    private String ZDMJ;
    @DatabaseField(columnName = "NYD",useGetSet = true)
    private String NYD;//农锟矫碉拷锟斤拷锟斤�?
    @DatabaseField(columnName = "GD",useGetSet = true)
    private String GD;//锟斤拷锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "JBNT",useGetSet = true)
    private String JBNT;//锟斤拷锟斤拷农锟斤拷锟斤拷锟斤拷
    @DatabaseField(columnName = "WLYD",useGetSet = true)
    private String WLYD;//未锟斤拷锟矫碉拷锟斤拷锟斤拷
    @DatabaseField(columnName = "FHGH",useGetSet = true)
    private String FHGH;//锟斤拷锟较规划锟矫碉拷锟斤拷锟斤�?
    @DatabaseField(columnName = "BFHGH",useGetSet = true)
    private String BFHGH;//锟斤拷锟斤拷锟较规划锟矫碉拷锟斤拷锟斤拷
    @DatabaseField(columnName = "YDDW",useGetSet = true)
    private String YDDW;
    @DatabaseField(columnName = "DWXZ",useGetSet = true)
    private String DWXZ;
    @DatabaseField(columnName = "ZRR",useGetSet = true)
    private String ZRR;
    @DatabaseField(columnName = "ZRRTel",useGetSet = true)
    private String ZRRTel;
    @DatabaseField(columnName = "Email",useGetSet = true)
    private String Email;
    @DatabaseField(columnName = "SEX",useGetSet = true)
    private String SEX;
    @DatabaseField(columnName = "WHCD",useGetSet = true)
    private String WHCD;//锟侥伙拷锟教讹拷
    @DatabaseField(columnName = "WFZZJG",useGetSet = true)
    private String WFZZJG;//制止结果
    @DatabaseField(columnName = "WFZZCS",useGetSet = true)
    private String WFZZCS;//制止措施
    @DatabaseField(columnName = "TYPE",useGetSet = true)
    private String TYPE;//类型
    @DatabaseField(columnName = "MZ",useGetSet = true)
    private String MZ;
    @DatabaseField(columnName = "TBZB",useGetSet = true)
    private String TBZB;//违锟斤拷图锟竭采硷拷锟斤拷锟斤拷锟斤�?

    @Warning("这段代码不能改动，不能在每个字段名前后加空格或其他字符，顺序也不可变动，否则无法上传")
    @Override
    public String toString() {
        return "{" +
                "TBBH='" + TBBH + '\'' +
                ",X='" + X + '\'' +
                ",Y='" + Y + '\'' +
                ",XZ='" + XZ + '\'' +
                ",CUN='" + CUN + '\'' +
                ",XDM='" + XDM + '\'' +
                ",SFWF='" + SFWF + '\'' +
                ",WFZL='" + WFZL + '\'' +
                ",SJYT='" + SJYT + '\'' +
                ",QSXZ='" + QSXZ + '\'' +
                ",XMLX='" + XMLX + '\'' +
                ",XKZZL='" + XKZZL + '\'' +
                ",XKZH='" + XKZH + '\'' +
                ",KZ='" + KZ + '\'' +
                ",ZDMJ='" + ZDMJ + '\'' +
                ",NYD='" + NYD + '\'' +
                ",GD='" + GD + '\'' +
                ",JBNT='" + JBNT + '\'' +
                ",WLYD='" + WLYD + '\'' +
                ",FHGH='" + FHGH + '\'' +
                ",BFHGH='" + BFHGH + '\'' +
                ",YDDW='" + YDDW + '\'' +
                ",DWXZ='" + DWXZ + '\'' +
                ",ZRR='" + ZRR + '\'' +
                ",ZRRTel='" + ZRRTel + '\'' +
                ",Email='" + Email + '\'' +
                ",SEX='" + SEX + '\'' +
                ",WHCD='" + WHCD + '\'' +
                ",WFZZJG='" + WFZZJG + '\'' +
                ",WFZZCS='" + WFZZCS + '\'' +
                ",TYPE='" + TYPE + '\'' +
                ",MZ='" + MZ + '\'' +
                ",TBZB='" + TBZB + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTBBH() {
        return TBBH;
    }

    public void setTBBH(String TBBH) {
        this.TBBH = TBBH;
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

    public String getSFWF() {
        return SFWF;
    }

    public void setSFWF(String SFWF) {
        this.SFWF = SFWF;
    }

    public String getWFZL() {
        return WFZL;
    }

    public void setWFZL(String WFZL) {
        this.WFZL = WFZL;
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

    public String getXKZZL() {
        return XKZZL;
    }

    public void setXKZZL(String XKZZL) {
        this.XKZZL = XKZZL;
    }

    public String getXKZH() {
        return XKZH;
    }

    public void setXKZH(String XKZH) {
        this.XKZH = XKZH;
    }

    public String getKZ() {
        return KZ;
    }

    public void setKZ(String KZ) {
        this.KZ = KZ;
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

    public String getWHCD() {
        return WHCD;
    }

    public void setWHCD(String WHCD) {
        this.WHCD = WHCD;
    }

    public String getWFZZJG() {
        return WFZZJG;
    }

    public void setWFZZJG(String WFZZJG) {
        this.WFZZJG = WFZZJG;
    }

    public String getWFZZCS() {
        return WFZZCS;
    }

    public void setWFZZCS(String WFZZCS) {
        this.WFZZCS = WFZZCS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getMZ() {
        return MZ;
    }

    public void setMZ(String MZ) {
        this.MZ = MZ;
    }

    public String getTBZB() {
        return TBZB;
    }

    public void setTBZB(String TBZB) {
        this.TBZB = TBZB;
    }
}
