package com.qingmu.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @Author  wencai.xu
 * @Description 使用snappy压缩字符串, 以压缩速度为优先，压缩率会稍逊一筹
 * @Date 2021/2/20
 **/
public class SnappyZipUtil {

    /**
     * 使用snappy压缩字符串
     *
     * @param originString 要压缩的字符串
     * @return 压缩后的字符串
     */
    public static String compress(String originString) {
        if (originString == null || originString.length() == 0) {
            return originString;
        }
        byte[] compress = new byte[0];
        try {
            compress = Snappy.compress(originString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new sun.misc.BASE64Encoder().encode(compress);
    }

    /**
     * 使用snappy压缩字符串
     *
     * @param compressedString 压缩字符串
     * @return
     */
    public static String uncompress(String compressedString) {
        if (compressedString == null || compressedString.length() == 0) {
            return null;
        }
        byte[] compressedByte = new byte[0];
        try {
            compressedByte = new sun.misc.BASE64Decoder().decodeBuffer(compressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] uncompress = new byte[0];
        try {
            uncompress = Snappy.uncompress(compressedByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(uncompress);
    }
}
