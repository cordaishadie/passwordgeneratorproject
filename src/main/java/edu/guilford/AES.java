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

    // Set the key
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            // Convert the key to a byte array
            key = myKey.getBytes("UTF-8");
            // Create a SHA-1 digest
            sha = MessageDigest.getInstance("SHA-1");
            // Update the digest with the key
            key = sha.digest(key);
            // Truncate the key to 128 bits
            key = Arrays.copyOf(key, 16);
            // Create a new SecretKeySpec
            secretKey = new SecretKeySpec(key, "AES");
            // Print the key
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // Encrypt and decrypt methods
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            // Set the key
            setKey(secret);
            // Create a new cipher
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // Initialize the cipher
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Encrypt the string
            // Return the encrypted string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            // Print the error
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // Decrypt method
    public static String decrypt(String strToDecrypt, String secret) {
        // Try to decrypt the string
        try {
            // Set the key
            setKey(secret);
            // Create a new cipher
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // Initialize the cipher
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // Decrypt the string
            // Return the decrypted string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            // Print the error
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
