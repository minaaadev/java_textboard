package com.board;

public class Article extends Object {

	int id;
	String title;
	String content;

	@Override 
	//object 클래스에 있는것을 메소드 오버라이딩 한거라고 알려주기
	public String toString() {
		return String.format("{id : %d, title :\"%s\", content : \"%s\"}", id, title,content);
	}
	Article(int id, String title, String content){
		this.id=id; 
		this.title=title;
		this.content=content;
	}

}