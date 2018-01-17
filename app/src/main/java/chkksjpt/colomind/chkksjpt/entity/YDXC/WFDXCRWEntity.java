package chkksjpt.colomind.chkksjpt.entity.YDXC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by CHENLI on 2015/7/5.
 */
@DatabaseTable(tableName = "TB_wfdxcrw")
public class WFDXCRWEntity implements Serializable{
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "YDDBH",useGetSet = true)
    private String YDDBH;//�ƶ��˱��
    @DatabaseField(columnName = "RWBH",useGetSet = true)
    private String RWBH;//������
    @DatabaseField(columnName = "YSWFLX",useGetSet = true)
    private String YSWFLX;//����Υ������
    @DatabaseField(columnName = "XFRQ",useGetSet = true)
    private String XFRQ;//�·�ʱ��
    @DatabaseField(columnName = "X",useGetSet = true)
    private String X;
    @DatabaseField(columnName = "Y",useGetSet = true)
    private String Y;
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;//����
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;//��
    @DatabaseField(columnName = "RWNR",useGetSet = true)
    private String RWNR;//��������
    @DatabaseField(columnName = "TP",useGetSet = true)
    private String TP;//ͼƬ
    @DatabaseField(columnName = "QKSM",useGetSet = true)
    private String QKSM;//���˵��
    @DatabaseField(columnName = "ZT",useGetSet = true)
    private String ZT;//״̬
    @DatabaseField(columnName = "SFYXWFD",useGetSet = true)
    private String SFYXWFD;//�Ƿ�����Υ����
    @DatabaseField(columnName = "XWFD",useGetSet = true)
    private String XWFD;//��Υ�������
    @DatabaseField(columnName = "CZWFD",useGetSet = true)
    private String CZWFD;//����Υ�������
    @DatabaseField(columnName = "BZ",useGetSet = true)
    private String BZ;//��ע

    @Override
    public String toString() {
        return "WFDXCRWEntity{" +
                "id=" + id +
                ", YDDBH='" + YDDBH + '\'' +
                ", RWBH='" + RWBH + '\'' +
                ", YSWFLX='" + YSWFLX + '\'' +
                ", XFRQ='" + XFRQ + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", RWNR='" + RWNR + '\'' +
                ", TP='" + TP + '\'' +
                ", QKSM='" + QKSM + '\'' +
                ", ZT='" + ZT + '\'' +
                ", SFYXWFD='" + SFYXWFD + '\'' +
                ", XWFD='" + XWFD + '\'' +
                ", CZWFD='" + CZWFD + '\'' +
                ", BZ='" + BZ + '\'' +
                '}';
    }

    public WFDXCRWEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYDDBH() {
        return YDDBH;
    }

    public void setYDDBH(String YDDBH) {
        this.YDDBH = YDDBH;
    }

    public String getRWBH() {
        return RWBH;
    }

    public void setRWBH(String RWBH) {
        this.RWBH = RWBH;
    }

    public String getYSWFLX() {
        return YSWFLX;
    }

    public void setYSWFLX(String YSWFLX) {
        this.YSWFLX = YSWFLX;
    }

    public String getXFRQ() {
        return XFRQ;
    }

    public void setXFRQ(String XFRQ) {
        this.XFRQ = XFRQ;
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

    public String getRWNR() {
        return RWNR;
    }

    public void setRWNR(String RWNR) {
        this.RWNR = RWNR;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    public String getQKSM() {
        return QKSM;
    }

    public void setQKSM(String QKSM) {
        this.QKSM = QKSM;
    }

    public String getZT() {
        return ZT;
    }

    public void setZT(String ZT) {
        this.ZT = ZT;
    }

    public String getSFYXWFD() {
        return SFYXWFD;
    }

    public void setSFYXWFD(String SFYXWFD) {
        this.SFYXWFD = SFYXWFD;
    }

    public String getXWFD() {
        return XWFD;
    }

    public void setXWFD(String XWFD) {
        this.XWFD = XWFD;
    }

    public String getCZWFD() {
        return CZWFD;
    }

    public void setCZWFD(String CZWFD) {
        this.CZWFD = CZWFD;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }
}
