package autointerface.demo.tools;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author liu.jianlong
 * AES对称加密和解密
 */
public class AESUtil {
    /**
     * 加密
     * @param seed 秘钥
     * @param content 加密内容
     */
    public static String encode(String seed, String content){
        try {
            KeyGenerator keygen= KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG") ;
            secureRandom.setSeed(seed.getBytes());
            keygen.init(128, secureRandom);
            SecretKey original_key = keygen.generateKey();
            byte [] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] byte_encode = content.getBytes("utf-8");
            byte [] byte_AES = cipher.doFinal(byte_encode);

            String encode = new String(new BASE64Encoder().encode(byte_AES).replaceAll("[\\s*\t\n\r]", ""));

            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * 解密
     * @param seed 秘钥
     * @param content 解密内容
     */
    public static String dncode(String seed, String content){
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(seed.getBytes());
            keygen.init(128, secureRandom);
            SecretKey original_key = keygen.generateKey();
            byte [] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte [] byte_decode = cipher.doFinal(new BASE64Decoder().decodeBuffer(content));
            String AES_decode = new String(byte_decode,"utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 字节转十六进制
     * @param b 需要进行转换的byte字节
     * @return  转换后的Hex字符串
     */
    public static String byteToHex(byte b){
        String hex = Integer.toHexString(b & 0xFF);
        if(hex.length() < 2){
            hex = "0" + hex;
        }
        return hex.toUpperCase();
    }

    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString().toUpperCase();
    }


    /**
     * Hex字符串转byte
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte
     */
    public static byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex,16);
    }

    /**
     * hex字符串转byte数组
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex){
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex="0"+inHex;
        }else {
            //偶数
            result = new byte[(hexlen/2)];
        }
        int j=0;
        for (int i = 0; i < hexlen; i+=2){
            result[j]=hexToByte(inHex.substring(i,i+2));
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        // 生产环境 eea4b80f85c34a2ab2042aadbdacd246  测试环境 4918b90787a24a74b345a3b66e6204bf
        String tokenSecret = "eea4b80f85c34a2ab2042aadbdacd246";
        long nowTime = System.currentTimeMillis();
        String newToken = encode(tokenSecret, String.format("wap_user_7_18616035352|18616035352|%s", nowTime));
        System.out.println(newToken);
        System.out.println(dncode(tokenSecret, newToken));

        // ed040bc7420546a988bd94f83e382f6d 生产
        // ccb7605e31094013  测试
        System.out.println(AESUtil.dncode("ed040bc7420546a988bd94f83e382f6d", "Npr/7FLi2T/RqSAyWa9iwQ=="));
    }
}