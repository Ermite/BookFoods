package com.fifth.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTools {
	public static String sendData(String data){
		try {
			URL url = new URL(data);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			
			OutputStream os = conn.getOutputStream();
			
			os.write(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
