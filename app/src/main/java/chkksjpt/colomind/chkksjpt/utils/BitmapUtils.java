package chkksjpt.colomind.chkksjpt.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/10.
 */

public class BitmapUtils {

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    private static Bitmap compressImage(Bitmap image, int limitedSize) {
        ByteArrayOutputStream outputs = new ByteArrayOutputStream();
        //图片格式为JPEG，压缩质量为100，传入文件字节大小输出流
        int options = 100;
        image.compress(Bitmap.CompressFormat.JPEG, options, outputs);
        //文件大小限制为limitedSize
        while (outputs.toByteArray().length / 1024 > limitedSize) {
            outputs.reset();
            //重新获得压缩后的输出流
            image.compress(Bitmap.CompressFormat.JPEG, options, outputs);
            options -= 10;
        }
        ByteArrayInputStream inputs = new ByteArrayInputStream(outputs.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(inputs, null, null);
        return bitmap;
    }

    /**
     * 图片按比例大小压缩方法（根据路径获取图片并压缩）
     *
     * @param srcPath
     * @return
     */

    private static Bitmap getImage(String srcPath, int limitedSize) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);// 此时bitmap = null并将图片大小放入options
       /* Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);*/
        newOpts.inJustDecodeBounds = false;
        int width = newOpts.outWidth;
        int height = newOpts.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;// 这里设置高度为800f
        float ww = 480f;// 这里设置宽度为480f
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;// be=1表示不缩放
        if (width > height && width > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (width / ww);
        } else if (width < height && height > hh) {// 如果高度高的话根据宽度固定大小缩放
            be = (int) (height / hh);
        }
        if (be <= 0) be = 1;
        newOpts.inSampleSize = be;// 设置缩放比例
        // 注意, imSampleSize的值为缩放比例的分母
        // 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return compressImage(bitmap, limitedSize);// 压缩好比例大小后再进行质量压缩
    }

    /**
     * 将压缩的bitmap保存到SDCard卡临时文件夹，用于上传
     *
     * @param filename
     * @param bit
     * @return
     */
    private static File saveMyBitmap(String filename, Bitmap bit) {
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/imageRemained/";
        String filePath = baseDir + filename;
        File dir = new File(baseDir);
        if (!dir.exists()) {
            //用baseDir创建了一个目录
            dir.mkdir();
        }

        File fileSaved = new File(filePath);
        try {
            fileSaved.createNewFile();
            // 只有BufferedOutputStream才能使用flush()正确的输出数据
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileSaved));
            bit.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.flush(); //TODO 看看Flush()的源码,数据写入到哪儿去了？用来干嘛？
            bos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return fileSaved;
    }

    /**
     * 压缩上传路径
     *
     * @param path
     * @return
     */
    public static File saveCompressImage(String path, int limitedSize) {
        String filename = path.substring(path.lastIndexOf("/") + 1);
        Bitmap image = getImage(path, limitedSize);
        return saveMyBitmap(filename, image);
    }

    public static Bitmap compressImageUpload(String path, int limitedSize) {
        String filename = path.substring(path.lastIndexOf("/") + 1);
        return getImage(path, limitedSize);
    }

    /**
     * 清除缓存文件
     */
    public static void deleteCacheFile() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/imageRemained/");
        RecursionDeleteFile(file);
    }

    /**
     * 递归删除
     */
    private static void RecursionDeleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                RecursionDeleteFile(f);
            }
            file.delete();
        }
    }
}
