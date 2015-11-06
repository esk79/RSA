import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.spec.*;

/**
 * Created by EvanKing on 11/5/15.
 */
public class RSA {

    public PublicKey publicKey;
    public PrivateKey privateKey;

    private static final String RSA = "RSA";

    public RSA() throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance(RSA);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        generator.initialize(2048);
        KeyPair keyPair = generator.genKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

    public byte[] encrypt(String text) {
        byte[] cipherText = null;
        try {
            final Cipher cipher = Cipher.getInstance(RSA);

            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherText = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherText;
    }

    public String decrypt(byte[] cipherText) {
        byte[] plainText = null;
        try {
            final Cipher cipher = Cipher.getInstance(RSA);

            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            plainText = cipher.doFinal(cipherText);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new String(plainText);
    }

    public static String publicKeyToString(PublicKey publicKey){
        return Base64.encode(publicKey.getEncoded());
    }

    public static String privateKeyToString(PrivateKey privateKey){
        return Base64.encode(privateKey.getEncoded());
    }

    public static PublicKey stringToPublicKey(String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException, Base64DecodingException {
        byte[] keyBytes = Base64.decode(publicKey.getBytes("utf-8"));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        return keyFactory.generatePublic(spec);
    }

    public static PrivateKey stringToPrivateKey(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException, Base64DecodingException {
        byte[] keyBytes = Base64.decode(privateKey.getBytes("utf-8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory fact = KeyFactory.getInstance(RSA);
       return fact.generatePrivate(keySpec);
    }

}
