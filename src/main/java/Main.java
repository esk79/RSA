import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by EvanKing on 11/5/15.
 */
public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException, Base64DecodingException {
        Controller.getPublicKey();
        RSA rsa = new RSA();
        RSA rsa2 = new RSA();

        System.out.println(rsa.publicKey);
        System.out.println(rsa2.publicKey);

    }
    //        RSA rsa = new RSA();
//        byte[] cipher = rsa.encrypt("evan");
//        System.out.println("The public key is: " + RSA.publicKeyToString(rsa.publicKey));
//        System.out.println("The private key is: " + RSA.privateKeyToString(rsa.privateKey));
//
//        RSA rsa2 = new RSA(RSA.publicKeyToString(rsa.publicKey), RSA.privateKeyToString(rsa.privateKey));
//
//        System.out.println("Encrypted text is: " + cipher.toString());
//        String plainText = rsa2.decrypt(cipher);
//        System.out.print("Decrypted text is: " + plainText);




}
