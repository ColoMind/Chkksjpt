package chkksjpt.colomind.chkksjpt.entity.JCYD;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**决策用地实体类
 * Created by pangcongcong on 2015/8/3.
 */
@DatabaseTable(tableName = "TB_JCYD")
public class JCYDEntity implements Serializable{

    @DatabaseField(generatedId = true,columnName = "ID",useGetSet = true)
    private int id;
    @DatabaseField(columnName = "BH",useGetSet = true)
    private String BH;
    @DatabaseField(columnName = "XZ",useGetSet = true)
    private String XZ;
    @DatabaseField(columnName = "CUN",useGetSet = true)
    private String CUN;
    @DatabaseField(columnName = "DKMJ",useGetSet = true)
    private String DKMJ;
    @DatabaseField(columnName = "JCSJ",useGetSet = true)
    private String JCSJ;
    @DatabaseField(columnName = "NXXM",useGetSet = true)
    private String NXXM;
    @DatabaseField(columnName = "SSXQ",useGetSet = true)
    private String SSXQ;
    @DatabaseField(columnName = "XY",useGetSet = true)
    private String XY;
    @DatabaseField(columnName = "JCR",useGetSet = true)
    private String JCR;
    @DatabaseField(columnName = "MJDW",useGetSet = true)
    private String MJDW;
    @DatabaseField(columnName = "mj",useGetSet = true)//其他地方用
    private String mj;


    public JCYDEntity() {
    }

    @Override
    public String toString() {
        return "JCYDEntity{" +
                "id=" + id +
                ", BH='" + BH + '\'' +
                ", XZ='" + XZ + '\'' +
                ", CUN='" + CUN + '\'' +
                ", DKMJ='" + DKMJ + '\'' +
                ", JCSJ='" + JCSJ + '\'' +
                ", NXXM='" + NXXM + '\'' +
                ", SSXQ='" + SSXQ + '\'' +
                ", XY='" + XY + '\'' +
                ", JCR='" + JCR + '\'' +
                ", MJDW='" + MJDW + '\'' +
                ", mj='" + mj + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBH() {
        return BH;
    }

    public void setBH(String BH) {
        this.BH = BH;
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

    public String getDKMJ() {
        return DKMJ;
    }

    public void setDKMJ(String DKMJ) {
        this.DKMJ = DKMJ;
    }

    public String getJCSJ() {
        return JCSJ;
    }

    public void setJCSJ(String JCSJ) {
        this.JCSJ = JCSJ;
    }

    public String getNXXM() {
        return NXXM;
    }

    public void setNXXM(String NXXM) {
        this.NXXM = NXXM;
    }

    public String getSSXQ() {
        return SSXQ;
    }

    public void setSSXQ(String SSXQ) {
        this.SSXQ = SSXQ;
    }

    public String getXY() {
        return XY;
    }

    public void setXY(String XY) {
        this.XY = XY;
    }

    public String getJCR() {
        return JCR;
    }

    public void setJCR(String JCR) {
        this.JCR = JCR;
    }

    public String getMJDW() {
        return MJDW;
    }

    public void setMJDW(String MJDW) {
        this.MJDW = MJDW;
    }

    public String getMj() {
        return mj;
    }

    public void setMj(String mj) {
        this.mj = mj;
    }
}
