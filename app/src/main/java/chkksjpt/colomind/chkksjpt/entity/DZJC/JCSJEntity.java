package chkksjpt.colomind.chkksjpt.entity.DZJC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by bj on 2016/2/28.
 */
@DatabaseTable(tableName = "TB_JCSJ")
public class JCSJEntity implements Serializable {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "CGQID",useGetSet = true)
    private String CGQID;//产品自编号

    @DatabaseField(columnName = "CGQXH",useGetSet = true)
    private String CGQXH; //产品型号

    @DatabaseField(columnName = "CeLiangZhi",useGetSet = true)
    private String CeLiangZhi;//测量值

    @DatabaseField(columnName = "Time",useGetSet = true)
    private String Time;//时间

    @DatabaseField(columnName = "TYPE",useGetSet = true)
    private String TYPE;//区别是周数据还是日数据



    public JCSJEntity() {
    }

    @Override
    public String toString() {
        return "JCSJEntity{" +
                "idd=" + idd +
                ", CGQID='" + CGQID + '\'' +
                ", CGQXH='" + CGQXH + '\'' +
                ", CeLiangZhi='" + CeLiangZhi + '\'' +
                ", Time='" + Time + '\'' +
                ", TYPE='" + TYPE + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getCGQID() {
        return CGQID;
    }

    public void setCGQID(String CGQID) {
        this.CGQID = CGQID;
    }

    public String getCGQXH() {
        return CGQXH;
    }

    public void setCGQXH(String CGQXH) {
        this.CGQXH = CGQXH;
    }

    public String getCeLiangZhi() {
        return CeLiangZhi;
    }

    public void setCeLiangZhi(String ceLiangZhi) {
        CeLiangZhi = ceLiangZhi;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
}
