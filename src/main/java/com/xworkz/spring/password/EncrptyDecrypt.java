package com.xworkz.spring.password;

import java.util.Base64;

import org.apache.log4j.Logger;
public class EncrptyDecrypt {

	private static final Logger logger=Logger.getLogger(EncrptyDecrypt.class);

	public EncrptyDecrypt() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}
	
	public static String encrypt(String strToEncrypt) {
		return Base64.getEncoder().encodeToString(strToEncrypt.getBytes());
	}

	public static String decrypt(String strToDecrypt) {
		return new String(Base64.getMimeDecoder().decode(strToDecrypt));
	}

	/*private static Random random = new Random((new Date().getTime()));
	String st = null;
	String enc = encrypt(st);

	public static String encrypt(String str) {
		BASE64Encoder encoder = new BASE64Encoder();
		// BASE64EncoderStream encoder = new BASE64EncoderStream();

		byte[] salt = new byte[8];
		random.nextBytes(salt);

		return encoder.encode(salt) + encoder.encode(str.getBytes());
	}

	public static String decrypt(String encstr) {
		if (encstr.length() > 12) {
			String cipher = encstr.substring(12);

			BASE64Decoder decoder = new BASE64Decoder();
			try {
				return new String(decoder.decodeBuffer(cipher));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return encstr;
	}*/
}
