package com.qingmu.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author wencai.xu
 */
public class GzipUtil {
    /**
     * 使用gzip压缩字符串
     *
     * @param originString 要压缩的字符串
     * @return 压缩后的字符串
     */
    public static String compress(String originString) {
        if (originString == null || originString.length() == 0) {
            return originString;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (
                GZIPOutputStream gzip = new GZIPOutputStream(out);
        ) {
            gzip.write(originString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip解压缩
     *
     * @param compressedString 压缩字符串
     * @return
     */
    public static String uncompress(String compressedString) {
        if (compressedString == null || compressedString.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] compressedByte = new byte[0];
        try {
            compressedByte = new sun.misc.BASE64Decoder().decodeBuffer(compressedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String originString = null;
        try (
                ByteArrayInputStream in = new ByteArrayInputStream(compressedByte);
                GZIPInputStream ginzip = new GZIPInputStream(in);
        ) {
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            originString = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return originString;
    }
}
