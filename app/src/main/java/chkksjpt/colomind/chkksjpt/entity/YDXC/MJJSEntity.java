package chkksjpt.colomind.chkksjpt.entity.YDXC;

import java.io.Serializable;

/**�������ʵ���࣬��������������ݣ���������Activity֮�䴫�ݣ�
 * Created by pangcongcong on 2015/7/2.
 */
public class MJJSEntity implements Serializable{

    //����������������ҳ����ֶ�
    private String ZDMJ;//ռ�������������������ҳ��
    private String NYDArea;//ũ�õ����
    private String GDArea;//�������
    private String JBNTArea;//����ũ�����
    private String WLYDArea;//δ���õ����
    private String FHGHArea;//���Ϲ滮�õ����
    private String BFHGHArea;//�����Ϲ滮�õ����

    @Override
    public String toString() {
        return "MJJSEntity{" +
                "BFHGHArea='" + BFHGHArea + '\'' +
                ", ZDMJ='" + ZDMJ + '\'' +
                ", NYDArea='" + NYDArea + '\'' +
                ", GDArea='" + GDArea + '\'' +
                ", JBNTArea='" + JBNTArea + '\'' +
                ", WLYDArea='" + WLYDArea + '\'' +
                ", FHGHArea='" + FHGHArea + '\'' +
                '}';
    }

    public String getZDMJ() {
        return ZDMJ;
    }

    public void setZDMJ(String ZDMJ) {
        this.ZDMJ = ZDMJ;
    }

    public String getBFHGHArea() {
        return BFHGHArea;
    }

    public void setBFHGHArea(String BFHGHArea) {
        this.BFHGHArea = BFHGHArea;
    }

    public String getFHGHArea() {
        return FHGHArea;
    }

    public void setFHGHArea(String FHGHArea) {
        this.FHGHArea = FHGHArea;
    }

    public String getGDArea() {
        return GDArea;
    }

    public void setGDArea(String GDArea) {
        this.GDArea = GDArea;
    }

    public String getJBNTArea() {
        return JBNTArea;
    }

    public void setJBNTArea(String JBNTArea) {
        this.JBNTArea = JBNTArea;
    }

    public String getNYDArea() {
        return NYDArea;
    }

    public void setNYDArea(String NYDArea) {
        this.NYDArea = NYDArea;
    }

    public String getWLYDArea() {
        return WLYDArea;
    }

    public void setWLYDArea(String WLYDArea) {
        this.WLYDArea = WLYDArea;
    }
}
