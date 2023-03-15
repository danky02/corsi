package eu.tasgroup.businesscomponent.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Algoritmo {
	public static String convertiMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			String salt = "Rd6$5ni%a2JaZz05fsL";
			for(int i = 0; i < array.length; i++)
				buffer.append(String.format("%x", array[i])+salt.toCharArray()[i]);
			return buffer.toString();
		} catch(NoSuchAlgorithmException e) {
			return null;
		}
	}
}
