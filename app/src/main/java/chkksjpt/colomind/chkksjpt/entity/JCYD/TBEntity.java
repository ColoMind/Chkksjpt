package chkksjpt.colomind.chkksjpt.entity.JCYD;

import java.io.Serializable;

/**图斑信息实体类
 * Created by pangcongcong on 2015/8/5.
 */
public class TBEntity implements Serializable {
    String BH=null;
    String NXXM=null;
    String JCSJ=null;
    String Coors=null;
    String MJ=null;

    @Override
    public String toString() {
        return "TBEntity{" +
                "BH='" + BH + '\'' +
                ", NXXM='" + NXXM + '\'' +
                ", JCSJ='" + JCSJ + '\'' +
                ", Coors='" + Coors + '\'' +
                ", MJ='" + MJ + '\'' +
                '}';
    }

    public String getBH() {
        return BH;
    }

    public void setBH(String BH) {
        this.BH = BH;
    }

    public String getNXXM() {
        return NXXM;
    }

    public void setNXXM(String NXXM) {
        this.NXXM = NXXM;
    }

    public String getJCSJ() {
        return JCSJ;
    }

    public void setJCSJ(String JCSJ) {
        this.JCSJ = JCSJ;
    }

    public String getCoors() {
        return Coors;
    }

    public void setCoors(String coors) {
        Coors = coors;
    }

    public String getMJ() {
        return MJ;
    }

    public void setMJ(String MJ) {
        this.MJ = MJ;
    }
}
