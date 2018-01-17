package chkksjpt.colomind.chkksjpt.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**巡查人员实体类
 * Created by EMonegiser on 2015/6/7.
 */
@DatabaseTable(tableName = "TB_XCRY")
public class XCRYEntity  implements Serializable{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "RYBH",useGetSet = true)
    private String rybh;

    @DatabaseField(columnName = "NAME",useGetSet = true)
    private String Name;

    @DatabaseField(columnName = "SEX",useGetSet = true)
    private String SEX;

    @DatabaseField(columnName = "ZW",useGetSet = true)
    private String ZW;

    @DatabaseField(columnName = "BE_PID",useGetSet = true)
    private String BE_PID;

    @DatabaseField(columnName = "BMMC",useGetSet = true)
    private String BMMC;

    @DatabaseField(columnName = "TEL",useGetSet = true)
    private String Tel;

    @DatabaseField(columnName = "QQ",useGetSet = true)
    private String QQ;

    @DatabaseField(columnName = "Email",useGetSet = true)
    private String Email;

    public XCRYEntity(int id, String rybh, String name, String sex, String zw,String be_pid,String bmmc ,String tel ,String qq ,String email) {
        this.id = id;
        this.rybh = rybh;
        Name = name;
        SEX=sex;
        ZW=zw;
        BE_PID=be_pid;
        BMMC=bmmc;
        Tel=tel;
        QQ=qq;
        Email=email;
    }

    public XCRYEntity() {
    }

    @Override
    public String toString() {
        return "XCRYEntity{" +
                "id=" + id +
                ", rybh='" + rybh + '\'' +
                ", Name='" + Name + '\'' +
                ", SEX='" + SEX + '\'' +
                ", ZW='" + ZW + '\'' +
                ", BE_PID='" + BE_PID + '\'' +
                ", BMMC='" + BMMC + '\'' +
                ", QQ='" + QQ + '\'' +
                ", Email='" + Email + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRybh() {
        return rybh;
    }

    public void setRybh(String rybh) {
        this.rybh = rybh;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getZW() {
        return ZW;
    }

    public void setZW(String ZW) {
        this.ZW = ZW;
    }

    public String getBE_PID() {
        return BE_PID;
    }

    public void setBE_PID(String BE_PID) {
        this.BE_PID = BE_PID;
    }

    public String getBMMC() {
        return BMMC;
    }

    public void setBMMC(String BMMC) {
        this.BMMC = BMMC;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
