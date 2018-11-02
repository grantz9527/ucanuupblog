package ucanuup.cc.common.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class PasswordUtil {
	
	private static final byte [] DATA = {7,2,5,2,6,8,7,52};
	
	public static byte[] des(int mode,byte[] data,byte[] keyData){
	    byte[] ret = null;
	    //加密的内容存在并且密钥存在且长度为8个字节
	    if (data != null
	        && data.length>0
	        && keyData!=null
	        && keyData.length==8) {
	      try {
	        Cipher cipher = Cipher.getInstance("DES");
	        DESKeySpec keySpec = new DESKeySpec(keyData);
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	        SecretKey key = keyFactory.generateSecret(keySpec);
	        cipher.init(mode, key);
	        ret = cipher.doFinal(data);
	      } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	      } catch (NoSuchPaddingException e) {
	        e.printStackTrace();
	      } catch (IllegalBlockSizeException e) {
	        e.printStackTrace();
	      } catch (BadPaddingException e) {
	        e.printStackTrace();
	      } catch (InvalidKeySpecException e) {
	        e.printStackTrace();
	      } catch (InvalidKeyException e) {
	        e.printStackTrace();
	      }
	    }
	    return ret;
	}
	
	//DES 加密
	private static byte[] desEncrypt(byte[] data,byte[] keyData){
	    return des(Cipher.ENCRYPT_MODE,data,keyData);
	}
	
	//DES 解密
	private static byte[] desDecrypt(byte[] data,byte[] keyData){
	    return des(Cipher.DECRYPT_MODE,data,keyData);
	}
	
	// 加密
	public static String encoderPassword(byte[] data) {
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(data);
	}
	
	// 解密
	public static byte[] decoderPassword(String data) {
		Base64.Decoder decoder = Base64.getDecoder();
		return decoder.decode(data);
	}
	
	// base64 加密
	public static String desLock(String password) {
		return encoderPassword(desEncrypt(password.getBytes(),DATA));
	}
	
	// base64解密
	public static String desOutLock(String lockPassword) {
		return new String(desDecrypt(decoderPassword(lockPassword),DATA));
	}
	
	public static void main(String[] args){
		System.out.println(desLock("password$1"));
		System.out.println(desOutLock(desLock("hello")));
	}
}
