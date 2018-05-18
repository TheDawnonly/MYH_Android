package houseproperty.manyihe.com.myh_android.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public MD5Utils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 加密
     */
    public static String encryptMD5(String securityStr) {
        byte[] data = securityStr.getBytes();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] resultbyte = md5.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < resultbyte.length; i++) {
            if (Integer.toHexString(0xff & resultbyte[i]).length() == 1) {
                stringBuilder.append("0").append(
                        Integer.toHexString(0xFF & resultbyte[i]));
            } else {
                stringBuilder.append(Integer.toHexString(0xff & resultbyte[i]));
            }
        }


        return stringBuilder.toString();
    }
}
