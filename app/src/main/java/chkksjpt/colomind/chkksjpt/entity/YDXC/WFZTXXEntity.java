package chkksjpt.colomind.chkksjpt.entity.YDXC;

import java.io.Serializable;

/**Υ��������Ϣʵ����(����Activity֮�䴫������ʹ��)
 * Created by EMonegiser on 2015/6/26.
 */
public class WFZTXXEntity implements Serializable{
    private String YDDW_Personal;//�õص�λ�����ˣ�
    private String DWXZ;//��λ����
    private String ZRR;//������
    private String LXDH;//��ϵ�绰
    private String Email;//�ʼ�
    private String Sex;//�Ա�
    private String Nation;//����
    private String ZP;
    private String CultureStard;//�Ļ��̶�

    @Override
    public String toString() {
        return "WFZTXXEntity{" +
                "YDDW_Personal='" + YDDW_Personal + '\'' +
                ", DWXZ='" + DWXZ + '\'' +
                ", ZRR='" + ZRR + '\'' +
                ", LXDH='" + LXDH + '\'' +
                ", Email='" + Email + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Nation='" + Nation + '\'' +
                ", ZP='" + ZP + '\'' +
                ", CultureStard='" + CultureStard + '\'' +
                '}';
    }

    public String getCultureStand() {
        return CultureStard;
    }

    public void setCultureStand(String cultureStard) {
        CultureStard = cultureStard;
    }

    public String getZRR() {
        return ZRR;
    }

    public void setZRR(String ZRR) {
        this.ZRR = ZRR;
    }

    public String getYDDW_Personal() {
        return YDDW_Personal;
    }

    public void setYDDW_Personal(String YDDW_Personal) {
        this.YDDW_Personal = YDDW_Personal;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getZP() {
        return ZP;
    }

    public void setZP(String ZP) {
        this.ZP = ZP;
    }

    public String getCultureStard() {
        return CultureStard;
    }

    public void setCultureStard(String cultureStard) {
        CultureStard = cultureStard;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
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

    public String getDWXZ() {
        return DWXZ;
    }

    public void setDWXZ(String DWXZ) {
        this.DWXZ = DWXZ;
    }
}
