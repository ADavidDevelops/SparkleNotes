package com.daviddevelops.sparklenote;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encypt {

	public Encypt(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(text.getBytes(StandardCharsets.UTF_8));
			StringBuilder test = new StringBuilder();
			for(byte b : hash) {
				test.append(String.format("%02x", b));
			}
			System.out.println(test.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
}
