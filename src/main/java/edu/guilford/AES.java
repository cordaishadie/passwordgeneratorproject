package edu.guilford;

/**
 *
 * @author bousabacw
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    // Attributes
    private static SecretKeySpec secretKey;
    private static byte[] key;

    // This block of code is used to set the key
    // The key is used to encrypt and decrypt the password
    public static void setKey(String myKey) {
        // For security, we use a SHA-1 digest
        MessageDigest sha = null;
        try {
            // We first convert the key to a byte array
            key = myKey.getBytes("UTF-8");
            // we create a SHA-1 digest
            sha = MessageDigest.getInstance("SHA-1");
            // and use the digest to create a 128-bit key
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            // we create a new SecretKeySpect object
            secretKey = new SecretKeySpec(key, "AES");
            // Print the key
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // this method is used to encrypt the password
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            // We first set the key to the secret key
            setKey(secret);
            // Then we create a new cipher and initialize it
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // We use the cipher to encrypt the string
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // the returen the encrypted string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            // we print out the error if there is one
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // this method is used to decrypt the password
    public static String decrypt(String strToDecrypt, String secret) {
        // Try to decrypt the string
        try {
            // we set the key
            setKey(secret);
            // create a new cipher and initialize it
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // we decrypt the string and return it
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            // and we print out the error if there is one
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
