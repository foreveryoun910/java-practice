package exam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList extends BookAccess {
	List<Book> bookList;
	Book book;
	Scanner scanner = new Scanner(System.in);
	
	//책 하나에 먼저 입력을 다 받은 다음에 그 책을 배열에 입력해야 함
	public void insert(Book book) {
		
		System.out.print("isbn입력> ");
		String isbn = scanner.nextLine();
		System.out.print("이름입력> ");
		String name = scanner.nextLine();
		System.out.print("내용입력> ");
		String content = scanner.nextLine();
			
		book = new Book(isbn, name, content);
		bookList.add(book);
		
		return;
	}
	
	//리스트 자료형(배열) findName에서 입력받은 name을 포함하는 배열을 찾아서 출력한다!!!
	public List<Book> findName(String name) {
		bookList = new ArrayList<Book>();
		
		System.out.print("조회할 이름입력> ");
		name = scanner.nextLine();
		
		for(Book b : bookList) {
			if(b.getName().contains(name)) {
				System.out.println(b);
			}
		}
		return bookList;
	}
}
