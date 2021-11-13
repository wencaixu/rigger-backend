package com.qingmu.compress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @Author wencai.xu
 * @Description 使用jdk的Deflater压缩字符串,可以指定算法的压缩级别，这样你可以在压缩时间和输出文件大小上进行平衡。
 * 可选的级别有0（不压缩），以及1(快速压缩)到9（慢速压缩）
 * @Date 2021/2/20
 **/
public class DeflaterZipUtil {


    /**
     * 使用jdk的Deflater压缩字符串
     *
     * @param originString 要压缩的字符串
     * @return 压缩后的字符串
     */
    public static String compress(String originString) {
        if (originString == null || originString.length() == 0) {
            return originString;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Deflater compressor = new Deflater(1);
        try {
            compressor.setInput(originString.getBytes());
            compressor.finish();
            final byte[] buf = new byte[2048];
            while (!compressor.finished()) {
                int count = compressor.deflate(buf);
                bos.write(buf, 0, count);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            compressor.end();
        }
        return new sun.misc.BASE64Encoder().encode(bos.toByteArray());
    }

    /**
     * 使用jdk的Deflater解压缩
     *
     * @param compressedString 压缩字符串
     * @return
     */
    public static String uncompress(String compressedString) {
        if (compressedString == null || compressedString.length() == 0) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Inflater decompressor = new Inflater();
        byte[] compressedByte = new byte[0];
        try {
            compressedByte = new sun.misc.BASE64Decoder().decodeBuffer(compressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            decompressor.setInput(compressedByte);
            final byte[] buf = new byte[2048];
            while (!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
        } finally {
            decompressor.end();
        }
        return bos.toString();
    }
}