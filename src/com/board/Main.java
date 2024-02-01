package com.board;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int articleLastId=0;
		
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
				
				Article article = new Article(1,"제목","내용");
				
				article.id = id;
				article.title = title;
				article.content = content;
				
				System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
				
				System.out.printf("생성된 게시물 객체: "+article);
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
