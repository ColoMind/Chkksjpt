package chkksjpt.colomind.chkksjpt.entity.video;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by bj on 2015/11/27.
 */
@DatabaseTable(tableName = "TB_Mp4Info")
public class Mp4Info {

    @DatabaseField(generatedId = true,columnName = "idd")
    private int idd;

    @DatabaseField(columnName = "mc",useGetSet = true)
    private String mc;

    @DatabaseField(columnName = "xh",useGetSet = true)
    private String xh;

    @DatabaseField(columnName = "sfsc",useGetSet = true)
    private String sfsc;

    @Override
    public String toString() {
        return "Mp4Info{" +
                "idd=" + idd +
                ", mc='" + mc + '\'' +
                ", xh='" + xh + '\'' +
                ", sfsc='" + sfsc + '\'' +
                '}';
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getSfsc() {
        return sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }
}
