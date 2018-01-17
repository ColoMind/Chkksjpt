package chkksjpt.colomind.chkksjpt.entity.YDXC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2015/8/15.
 */
@DatabaseTable(tableName = "TB_WPZFwbh")
public class WPZFwbhEntity implements Serializable {
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "ZXRBH",useGetSet = true)
    private String ZXRBH;//ִ���˱��
    @DatabaseField(columnName = "TBBH",useGetSet = true)
    private String TBBH;//ͼ�߱��
    @DatabaseField(columnName = "ZXR",useGetSet = true)
    private String ZXR;//ִ����
    @DatabaseField(columnName = "SCRY",useGetSet = true)
    private String SCRY;//�����Ա
    @DatabaseField(columnName = "QTRY",useGetSet = true)
    private String QTRY;//������Ա
    @DatabaseField(columnName = "TBLX",useGetSet = true)
    private String TBLX;//ͼ������
    @DatabaseField(columnName = "XY",useGetSet = true)
    private String XY;//ͼ�����괮
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;//����
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;//��
    @DatabaseField(columnName = "XDM",useGetSet = true)
    private String XDM;//С����
    @DatabaseField(columnName = "ZDMJ",useGetSet = true)
    private String ZDMJ;//ռ�����
    @DatabaseField(columnName = "QKSM",useGetSet = true)
    private String QKSM;//���˵��

    @Override
    public String toString() {
        return "WPZFwbhEntity{" +
                "id=" + id +
                ", ZXRBH='" + ZXRBH + '\'' +
                ", TBBH='" + TBBH + '\'' +
                ", ZXR='" + ZXR + '\'' +
                ", SCRY='" + SCRY + '\'' +
                ", QTRY='" + QTRY + '\'' +
                ", TBLX='" + TBLX + '\'' +
                ", XY='" + XY + '\'' +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", XDM='" + XDM + '\'' +
                ", ZDMJ='" + ZDMJ + '\'' +
                ", QKSM='" + QKSM + '\'' +
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

    public String getSCRY() {
        return SCRY;
    }

    public void setSCRY(String SCRY) {
        this.SCRY = SCRY;
    }

    public String getZXR() {
        return ZXR;
    }

    public void setZXR(String ZXR) {
        this.ZXR = ZXR;
    }

    public String getQTRY() {
        return QTRY;
    }

    public void setQTRY(String QTRY) {
        this.QTRY = QTRY;
    }

    public String getTBLX() {
        return TBLX;
    }

    public void setTBLX(String TBLX) {
        this.TBLX = TBLX;
    }

    public String getXY() {
        return XY;
    }

    public void setXY(String XY) {
        this.XY = XY;
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

    public String getZDMJ() {
        return ZDMJ;
    }

    public void setZDMJ(String ZDMJ) {
        this.ZDMJ = ZDMJ;
    }

    public String getQKSM() {
        return QKSM;
    }

    public void setQKSM(String QKSM) {
        this.QKSM = QKSM;
    }
}
