package com.board;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	static void makeTestData(List<Article> articles) {
		articles.add(new Article(1, "제목1", "내용1"));
        articles.add(new Article(2, "제목2", "내용2"));
        articles.add(new Article(3, "제목3", "내용3"));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int articleLastId=0;
		
		List<Article> articles = new ArrayList<>();		
		
		
		//프로그램 리펙토링 <=좀더 읽기 편한걸로 바꿔줌
		
        
        makeTestData(articles);
        
		System.out.println("=== * 자바 텍스트 게시판 * ===");
		System.out.println("===프로그램 시작===");
		
		while (true) {
			System.out.printf("\n명령 :");
			String cmd = sc.nextLine();	
			
			if (cmd.equals("/usr/article/write")) {
				System.out.println("===게시물 등록 ===");
				System.out.printf("제목: ");
				String title = sc.nextLine();
				
				System.out.printf("내용: ");
				String content=sc.nextLine();
				
				int id=articleLastId+1;
				articleLastId++;
				
				Article article = new Article(id, title, content);
				articles.add(article);
				
				System.out.printf("%d번 게시물이 등록되었습니다.\n", id);				
				System.out.printf("생성된 게시물 객체: "+article);
			}
				else if(cmd.equals("/usr/article/list")) {
					System.out.println("==게시물 리스트==");
					System.out.println("번호/제목");
					
					
					
					for (Article article:articles) {
						System.out.printf("%d / %s\n",article.id, article.title);
					}
				}
				else if(cmd.equals("/usr/article/detail")) {
					
					Object lastArticle = null;
					if(lastArticle==null) {
						System.out.println("게시물이 존재하지 않습니다.");
					}
				}
				else if (cmd.equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					break;
					}
				else {
					System.out.println("명령어를 잘못 입력하셨습니다.");
				}
			 
		}
		System.out.println("== 프로그램 종료 ==");
		sc.close();
	}


}
