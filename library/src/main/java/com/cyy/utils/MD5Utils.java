package com.cyy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author :ChenYangYi
 * @date :2018/09/19/10:28
 * @description :MD5
 * @github :https://github.com/chenyy0708
 */

public class MD5Utils {
    /**
     * MD5加密
     *
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(str.getBytes());
        BigInteger bigInteger = new BigInteger(1, md.digest());
        String s = bigInteger.toString(16);
        // 如果不够32位补上"0"
        if (s.length() < 32) {
            int count = 32 - s.length();
            for (int i = 0; i < count; i++) {
                s = "0" + s;
            }
            return s;
        }
        return s;
    }

    /**
     * 获取文件的MD5
     *
     * @param srcFilePath
     * @return
     * @throws Exception
     */
    public static String getFileMD5(String srcFilePath) throws Exception {
        File file = new File(srcFilePath);
        if (!file.exists()) {
            throw new Exception("File is not exist");
        }
        String value = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            MappedByteBuffer byteBuffer = fis.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
