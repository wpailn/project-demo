package com.wp.util;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class DigestUtils {

    private static final String KEY = "datacvg";
    private static final String IV = "12345678";
    /**
     * DES加密
     * @param value 原值
     * @return 加密值
     * @throws Exception 异常
     */
    public static String DESEncryption(String value) throws Exception {
        byte[] pasByte = DES.INSTANCE.getEnCipher().doFinal(value.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(pasByte);
    }

    /**
     * DES解密
     * @param value 原值
     * @return 解密值
     * @throws Exception 异常
     */
    public static String DESDecrypt(String value) throws Exception {
        byte[] pasByte = DES.INSTANCE.getDeCipher().doFinal(Base64.getDecoder().decode(value));
        return new String(pasByte, StandardCharsets.UTF_8);
    }

    private enum DES{
        INSTANCE;
        private Cipher enCipher;
        private Cipher deCipher;

        DES(){
            try {
                AlgorithmParameterSpec vector = new IvParameterSpec(IV.getBytes());
                DESKeySpec keySpec = new DESKeySpec(KEY.getBytes());
                SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
                enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                enCipher.init(Cipher.ENCRYPT_MODE, secretKey, vector);
                deCipher.init(Cipher.DECRYPT_MODE, secretKey, vector);
            } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidAlgorithmParameterException | NoSuchPaddingException e) {
                e.printStackTrace();
            }
        }

        public Cipher getEnCipher(){
            return this.enCipher;
        }

        public Cipher getDeCipher(){
            return this.deCipher;
        }
    }
}
