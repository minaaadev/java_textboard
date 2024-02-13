package com.board;

import java.util.Map;

public class Rq {

	private String url;
	private Map<String, String> params;
	private String urlPath;
	
	public Rq(String url) {
		this.url = url;
		params = Util.getParamsFromUrl(url);
		urlPath=Util.getUrlFromUrl(url);
		
	}
	public Map<String, String> getParam(){
		return params;
	}
	public String getUrlPath() {
		return urlPath;
	}
}

