package chkksjpt.colomind.chkksjpt.entity;

import java.io.Serializable;

/**
 * Created by mars on 2015/1/29.
 * 储备用地
 */

public class YJSPXXEntity implements Serializable {
   private String X="0";
   private String Y="0";
   private String di_type;
   private String di_add;
   private String di_Casualty;
   private String di_EconomicLoss;
   private String  di_Relocate;
   private String di_IndirectLoss;
   private String  remark;
   private String  di_Time;
  //  [{"id":"9","X":"23234.54450000","Y":"23445.44400000","E":"23234.54450000","N":"23445.44400000","di_Type":"3","di_Add":"2","di_Casualty":"4","di_EconomicLoss":"5.00","di_Relocate":"6","di_IndirectLoss":"7.00","di_State":"0","di_DgId":"0","di_Time":"2015/4/6 18:29:00","remark":"8"},{"
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

    public String getDi_type() {
        return di_type;
    }

    public void setDi_type(String di_type) {
        this.di_type = di_type;
    }

    public String getDi_add() {
        return di_add;
    }

    public void setDi_add(String di_add) {
        this.di_add = di_add;
    }

    public String getDi_Casualty() {
        return di_Casualty;
    }

    public void setDi_Casualty(String di_Casualty) {
        this.di_Casualty = di_Casualty;
    }

    public String getDi_EconomicLoss() {
        return di_EconomicLoss;
    }

    public void setDi_EconomicLoss(String di_EconomicLoss) {
        this.di_EconomicLoss = di_EconomicLoss;
    }

    public String getDi_Relocate() {
        return di_Relocate;
    }

    public void setDi_Relocate(String di_Relocate) {
        this.di_Relocate = di_Relocate;
    }

    public String getDi_IndirectLoss() {
        return di_IndirectLoss;
    }

    public void setDi_IndirectLoss(String di_IndirectLoss) {
        this.di_IndirectLoss = di_IndirectLoss;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
