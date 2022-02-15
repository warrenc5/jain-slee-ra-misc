/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.megaco.resource.impl.codec;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.io.IOException;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import nu.datafuel.io.Base64Decoder;
import nu.datafuel.io.Base64Encoder;
import sun.misc.HexDumpEncoder;

/**
 *
 * @author wozza
 */
public class SignerUtil {

    static Signature signer;
    static Signature verifyer;

    static Base64Encoder b64enc = new Base64Encoder();
    static Base64Decoder b64dec = new Base64Decoder();
    private static MessageDigest md5;
    private static MessageDigest sha1;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha1 = MessageDigest.getInstance("SHA1");

            signer = Signature.getInstance("SHA1withRSA");
            verifyer = Signature.getInstance("SHA1withRSA");
            
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();

            signer.initSign(pair.getPrivate());
            verifyer.initVerify(pair.getPublic());
        } catch (InvalidKeyException ex) {
            Logger.getLogger(SignerUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignerUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized String hashSHA1String(String id) throws SignatureException {
        sha1.update(id.getBytes());
        byte[] bb = md5.digest();
        StringBuilder result = new StringBuilder();
        result.append(HexBin.encode(bb));
        md5.reset();
        return result.toString();
    }

    public static synchronized String hashMD5String(String id) throws SignatureException {
        sha1.update(id.getBytes());
        byte[] bb = md5.digest();
        StringBuilder result = new StringBuilder();
        result.append(HexBin.encode(bb));
        md5.reset();
        return result.toString();
    }

    public static synchronized String signString(String id) throws SignatureException {
        signer.update(id.getBytes());
        byte[] bb = signer.sign();
        StringBuffer result = new StringBuffer();
        result.append(HexBin.encode(bb));
        return result.toString();
    }

    public static synchronized boolean checkString(String id,String sig) throws SignatureException, IOException {
        verifyer.update(id.getBytes());

        boolean result =  verifyer.verify(b64dec.decodeBuffer(sig));
        return result;
    }
}