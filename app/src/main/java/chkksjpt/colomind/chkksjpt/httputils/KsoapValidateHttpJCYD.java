package chkksjpt.colomind.chkksjpt.httputils;

import android.content.Context;
import android.content.SharedPreferences;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;

import chkksjpt.colomind.chkksjpt.utils.ConstantVar;

/**
 * Created by Administrator on 2015/8/3.
 */
public class KsoapValidateHttpJCYD {

    private static final String NAMESPACE = "http://tempuri.org/";
    private Context context = null;

    public KsoapValidateHttpJCYD(Context context) {
        this.context = context;

        SharedPreferences CONFSYS_INFO = context.getSharedPreferences("CONFSYS_INFO", context.MODE_PRIVATE);

        if (CONFSYS_INFO.getString("WPZF", null) != null && CONFSYS_INFO.getString("WPZF", null).length() > 0) {
            ConstantVar.WPZFURL = CONFSYS_INFO.getString("WPZF", "");
        }

        if (CONFSYS_INFO.getString("XCRW", null) != null && CONFSYS_INFO.getString("XCRW", null).length() > 0) {
            ConstantVar.XCRWURL = CONFSYS_INFO.getString("XCRW", "");
        }

        if (CONFSYS_INFO.getString("CBYD", null) != null && CONFSYS_INFO.getString("CBYD", null).length() > 0) {
            ConstantVar.CBYDURL = CONFSYS_INFO.getString("CBYD", "");
        }

        if (CONFSYS_INFO.getString("GYYD", null) != null && CONFSYS_INFO.getString("GYYD", null).length() > 0) {
            ConstantVar.GYYDURL = CONFSYS_INFO.getString("GYYD", "");
        }

        if (CONFSYS_INFO.getString("PZYD", null) != null && CONFSYS_INFO.getString("PZYD", null).length() > 0) {
            ConstantVar.PZYDURL = CONFSYS_INFO.getString("PZYD", "");
        }

        if (CONFSYS_INFO.getString("SBYD", null) != null && CONFSYS_INFO.getString("SBYD", null).length() > 0) {
            ConstantVar.SBYDURL = CONFSYS_INFO.getString("SBYD", "");
        }

        if (CONFSYS_INFO.getString("KCZY", null) != null && CONFSYS_INFO.getString("KCZY", null).length() > 0) {
            ConstantVar.KCURL = CONFSYS_INFO.getString("KCZY", "");
        }

        if (CONFSYS_INFO.getString("DZZH", null) != null && CONFSYS_INFO.getString("DZZH", null).length() > 0) {
            ConstantVar.DZZHQUERYURL = CONFSYS_INFO.getString("DZZH", "");
        }
        if (CONFSYS_INFO.getString("LOGIN", null) != null && CONFSYS_INFO.getString("LOGIN", null).length() > 0) {
            ConstantVar.LOGINURL = CONFSYS_INFO.getString("LOGIN", "");
        }

        //地图
        if (CONFSYS_INFO.getString("XZQH", null) != null && CONFSYS_INFO.getString("XZQH", null).length() > 0) {
            ConstantVar.DZZHMAPURL = CONFSYS_INFO.getString("XZQH", "");
        }
        if (CONFSYS_INFO.getString("XZQH", null) != null && CONFSYS_INFO.getString("XZQH", null).length() > 0) {
            ConstantVar.XZQHMAPURL = CONFSYS_INFO.getString("XZQH", "");
        }
        if (CONFSYS_INFO.getString("SDYX", null) != null && CONFSYS_INFO.getString("SDYX", null).length() > 0) {
            ConstantVar.IMAGEURL = CONFSYS_INFO.getString("SDYX", "");
        }
        if (CONFSYS_INFO.getString("URL", null) != null && CONFSYS_INFO.getString("URL", null).length() > 0) {
            ConstantVar.DZZHYJ = CONFSYS_INFO.getString("URL", "");
        }
        if (CONFSYS_INFO.getString("ZSURL", null) != null && CONFSYS_INFO.getString("ZSURL", null).length() > 0) {
            ConstantVar.YJZS = CONFSYS_INFO.getString("ZSURL", "");
        }
    }


    //占压分析
    public String WebCountingAnalysis(String Coordinates, String CoorType) throws IOException {
        String rsltStr = "";
        String METHOD_NAME = "WebCountingAnalysis";
        SoapPrimitive detail;

        try {
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
            rpc.addProperty("Coordinatestrings", Coordinates);
            rpc.addProperty("CoorType", CoorType);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(rpc);

            HttpTransportSE ht = new HttpTransportSE(ConstantVar.ZYFXURL2, 200 * 1000);
            ht.debug = true;
            ht.call(NAMESPACE + METHOD_NAME, envelope);
            detail = (SoapPrimitive) envelope.getResponse();
            if (detail != null) {
                rsltStr = detail.toString();
                return rsltStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取土地利用类型
    public String WebGetAllTypes() throws IOException {
        String rsltStr = "";
        String METHOD_NAME = "WebGetAllTypes";
        SoapPrimitive detail;

        try {
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(rpc);

            HttpTransportSE ht = new HttpTransportSE(ConstantVar.ZYFXURL);
            ht.debug = true;
            ht.call(NAMESPACE + METHOD_NAME, envelope);
            detail = (SoapPrimitive) envelope.getResponse();
            if (detail != null) {
                rsltStr = detail.toString();
                return rsltStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //保存图斑
    public String WebUploadSpotMessage(String attribute) throws IOException {
        String rsltStr = "";
        String METHOD_NAME = "WebUploadSpotMessage";
        SoapPrimitive detail;

        try {
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
            rpc.addProperty("attribute", attribute);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(rpc);

            HttpTransportSE ht = new HttpTransportSE(ConstantVar.ZYFXURL, 200 * 1000);
            ht.debug = true;
            ht.call(NAMESPACE + METHOD_NAME, envelope);
            detail = (SoapPrimitive) envelope.getResponse();
            if (detail != null) {
                rsltStr = detail.toString();
                return rsltStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询所有记录
    public String WebGetAllRecords(String XZ, String CUN) throws IOException {
        String rsltStr = "";
        String METHOD_NAME = "WebGetAllRecords";
        SoapPrimitive detail;

        try {
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
            rpc.addProperty("xz", XZ);
            rpc.addProperty("cun", CUN);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(rpc);

            HttpTransportSE ht = new HttpTransportSE(ConstantVar.ZYFXURL);
            ht.debug = true;
            ht.call(NAMESPACE + METHOD_NAME, envelope);
            detail = (SoapPrimitive) envelope.getResponse();
            if (detail != null) {
                rsltStr = detail.toString();
                return rsltStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取占压批复的用地
    public String WebGetZYPFYDData(String Coor, String CoorType) throws IOException {
        String rsltStr = "";
        String METHOD_NAME = "WebGetZYPFYDData";
        SoapPrimitive detail;

        try {
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
            rpc.addProperty("Coor", Coor);
            rpc.addProperty("CoorType", CoorType);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(rpc);

            HttpTransportSE ht = new HttpTransportSE(ConstantVar.ZYFXURL);
            ht.debug = true;
            ht.call(NAMESPACE + METHOD_NAME, envelope);
            detail = (SoapPrimitive) envelope.getResponse();
            if (detail != null) {
                rsltStr = detail.toString();
                return rsltStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
