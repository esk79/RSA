import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by EvanKing on 11/5/15.
 */
public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException, Base64DecodingException {
        RSA rsa = new RSA();
        byte[] cipher = rsa.encrypt("evan");
        System.out.println("The public key is: " + RSA.publicKeyToString(rsa.publicKey));
        System.out.println("The private key is: " + RSA.privateKeyToString(rsa.privateKey));

        System.out.println("Encrypted text is: " + cipher.toString());
        String plainText = rsa.decrypt(cipher);
        System.out.print("Decrypted text is: " + plainText);

    }
}
