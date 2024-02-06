package com.board;

import java.util.HashMap;
import java.util.Map;

public class Util {

	public static Map<String, String> getParamsFromUrl1(String url){
			Map<String, String> params = new HashMap<>();
			String[] urlBits=url.split("\\?",2);
			
			if(urlBits.length==1) {
				return params;
			}
			
			String queryStr=urlBits[1];
			
			for(String bit:queryStr.split("&")) {
				String[] bits=bit.split("=",2);
				
				if(bits.length==1) {
					continue;
				}
				
				params.put(bits[0], bits[1]);
			}
			return params;
		}
	


	public static String getUrlFromUrl(String url) {
        String[] urlBits = url.split("\\?", 2);
        return urlBits[0];
    }
	public static Map<String, String> getParamsFromUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

//	public static String getUrlFromUrl(String url) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
