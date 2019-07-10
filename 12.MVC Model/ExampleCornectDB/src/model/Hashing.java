/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/26/2019                     *
 * Time: 10:08 AM                     *
 *************************************
 */

package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hashing {
    static String algorithm = "MD5";
    static String algorithm2 = "SHA-256";

    public Hashing(){}

    public static byte[] createSalt() {
        byte[] bytes = new byte[7];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    public static String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return bytesToStringHex(hash);
    }

    final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int j = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[j >>> 4];
            hexChars[i * 2 + 1] = hexArray[j & 0x0F];
        }
        return new String(hexChars);
    }
    public static String byteToString(byte[] bytes) {
        String string = new String(bytes);
        return string;
    }
    public static byte[] stringToByte(String string){
        byte[] bytes = string.getBytes();
        return bytes;
    }

    //MD5
    private static String generateHashMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        byte[] hash = digest.digest(text.getBytes());
        return bytesToStringHex(hash);
    }

    //SHA-256
    private static String generateHashSHA256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm2);
        digest.reset();
        byte[] hash = digest.digest(text.getBytes());
        return bytesToStringHex(hash);
    }



    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "nhat123";
        byte[] salt = createSalt();
        String str = byteToString(salt);
        System.out.println("Salt:" + str);
        System.out.println("MD5 + Salt: " + generateHash(password,salt));
        byte[] salt1 = createSalt();
        String str1 = byteToString(salt1);
        System.out.println("Salt:" + str1);
        System.out.println("MD5 + Salt : " + generateHash(password,salt1));
        System.out.println();
        System.out.println("MD5 : " + generateHashMD5(password));
        System.out.println("MD5 : " + generateHashMD5("nhat123"));
        System.out.println();
        System.out.println("SHA-256 : " + generateHashSHA256(password));
        System.out.println("SHA-256 : " + generateHashSHA256("nhat123"));

    }
}
