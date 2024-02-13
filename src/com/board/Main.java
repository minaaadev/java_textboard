package com.board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Main{
	
	static void makeTestDate(List<Article> articles) {		
		//테스트 게시물을 100개로 늘림
		for(int i=1;i<=100;i++) {
			articles.add(new Article(i,": 제목"+i,": 내용"+i));
		}
	}
	//test 게시물 늘리기
	static void makeTestData(List<Article> articles) {
		for (int i=1; i<=100; i++) {
			articles.add(new Article(i,"제목"+i,"내용"+i));
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int articleLastId=0;
		
		List<Article> articles = new ArrayList<>();		
		Map<String, String> params=new HashMap<>();
		
		//프로그램 리펙토링 <=좀더 읽기 편한걸로 바꿔줌        
        makeTestData(articles);
        
        if(articles.size()>0) {
        	articleLastId=articles.get(articles.size()-1).id;
        }
        //get 으로 게시물 가져옴. articles.size()-1하면 2번째 게시물 가져옴
        //2번째 게시물의 .id 를 가져온다. 0,1,2, 3번게시물 가져옴
        //articleLastId에 3을 넣어줌. 
		System.out.println("=== * 자바 텍스트 게시판 * ===");
		System.out.println("===프로그램 시작===");
		
		while (true) {
			System.out.printf("\n명령 :");
			String cmd = sc.nextLine();	
			
			Rq rq = new Rq(cmd); 
					
			if (rq.getUrlPath().equals("/usr/article/write")) {
				System.out.println("===게시물 등록 ===");
				System.out.printf("제목: ");
				String title = sc.nextLine();
				
				System.out.printf("내용: ");
				String content=sc.nextLine();
				
				int id=articleLastId+1;
				articleLastId++;
				
				Article article = new Article(id, title, content);
				
				articles.add(article); //list 에 게시물 추가
				
				System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
			}
				else if(rq.getUrlPath().equals("/usr/article/list")) {
					
					actionUsrArticleList(rq,articles);
				}
					
			
					else {
						//for(Article article : filteredArticles) {
							//System.out.printf("%d / %s\n",article.id, article.title);
						//}
					//}
					
					for (int i=articles.size()-1; i>=0; i--) {
						Article article=articles.get(i);
						System.out.printf("%d / %s\n",article.id, article.title);
					}
				}
				 if(rq.getUrlPath().equals("/usr/article/detail")) {					
					if(params.containsKey("id") ==false) {
						System.out.println("id를 입력해주세요");
						continue;
					}
					System.out.println("게시물 번호 입력");
					int id;
					
					try {
						id=Integer.parseInt(sc.nextLine());
					} catch(NumberFormatException e) {
					System.out.println("올바른 숫자를 입력하세요");
					continue;
					}
					
					//게시물이 아예 없는 경우
					if (articles.isEmpty() || id <= 0 || id > articles.size()) {
					     System.out.println("해당 게시물은 존재하지 않습니다.");
					     continue;
					}
					//마지막 게시물의 번호 가져옴
					Article article=articles.get(id-1); 
					
					//내가 찾는 게시물이 없는 경우
					if(article==null) {
						System.out.println("해당 게시물은 존재하지 않습니다");
						continue;
					}
					System.out.println("===게시물 상세보기 ===");
					System.out.printf("번호 : %d\n", article.id);
					System.out.printf("제목 : %s\n",article.title);
					System.out.printf("내용: %s\n", article.content);
				}
				else if (rq.getUrlPath().equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					break;
					}
				else {
					System.out.println("명령어를 잘못 입력하셨습니다.");
				}		 
		}
		//System.out.println("== 프로그램 종료 ==");
		sc.close();
}
	private static void actionUsrArticleList(Rq rq, List<Article> articles) {
		// TODO Auto-generated method stub

		System.out.println("==게시물 리스트==");
		System.out.println("번호/제목");
		
		
		Map<String, String> params = rq.getParam();
		//검색 시작
		List<Article> filteredArticles=articles;
		
		if(params.containsKey("searchKeyword")) {
			
			String searchKeyword = params.get("searchKeyword");
		
			filteredArticles = new ArrayList<>();
			
			for(Article article : articles) {
				//내가 입력한 키워드가 타이틀이나 컨텐트에 들어있다면
				boolean matched = article.title.contains(searchKeyword) || article.content.contains(searchKeyword);
			
				if(matched) {
					filteredArticles.add(article);
				}
			}
		}
		//검색 끝
		
		List<Article> sortedArticles = filteredArticles;
		
		boolean orderByIdDesc = true;
				
		
		if(params.get("orderBy") != null && params.get("orderBy").equals("idAsc")) {
			orderByIdDesc = false;
		}
		
		if(orderByIdDesc) {
			for (int i=filteredArticles.size()-1; i>=0; i--) {
				Article article=filteredArticles.get(i);
				System.out.printf("%d / %s\n",article.id, article.title);
			sortedArticles =Util.reverseList(sortedArticles);
		}	
			sortedArticles.stream()
			.forEach(article->System.out.printf("%d / %s\n", article.id, article.title));
		}//정렬 로직 끝
	}
}
