package com.board;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
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
    
//	public static <T> List<T> reverseList(List<T> list) {
//        List<T> reverse = new ArrayList<>(list.size());
//
//        //입력받은것의 복사본을 뒤집기
//        for (int i = list.size() - 1; i >= 0; i--) {
//            reverse.add(list.get(i));
//        }

}



	public static Map<String, String> getParamsFromUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}
}
