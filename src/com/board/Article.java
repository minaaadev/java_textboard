package com.board;

import java.util.ArrayList;
import java.util.List;

public class Article extends Object {

	int id;
	String title;
	String content;

	public Article(int id,String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	@Override 
	//object 클래스에 있는것을 메소드 오버라이딩 한거라고 알려주기
	public String toString() {
		return String.format("{id : %d, title :\"%s\", content : \"%s\"}", id, title,content);
	}
		
	// 초기 데이터 추가를 위한 메소드
    public static List<Article> getInitialData() {
        List<Article> articles = new ArrayList<>();

        

//        for(Article article:articles) {
//        	System.out.printf("%d / %s\n", article.id, article.title);
//        }
        return articles;
		
	}

}