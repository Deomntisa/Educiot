package xyz.demontisa;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    private static final Logger log = Logger.getLogger(MD5.class);

    public static String pwdToMD5(String userPassword) {

        byte[] secretBytes;
        try {
            log.warn("正在将密码转换为MD5");

            secretBytes = MessageDigest.getInstance("md5").digest(
                    userPassword.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = Hex.encodeHexString(secretBytes);
        log.warn("已成功转换为MD5 " + md5code);

        return md5code;
    }
}
