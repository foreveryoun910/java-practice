package exam05;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService {
	BookList bookList = new BookList();
	Scanner scanner = new Scanner(System.in);
	
	//이름을 입력하면 이름을 포함하는 모든 도서를 출력
	@Override
	public void execute(BookList bookList) {
		System.out.print("이름입력> ");
		String name = scanner.next();	//이름을 입력
		
		List<Book> books = bookList.findName(name);
		for(Book b : books) {
			System.out.println(b);
		}
		
	}

}
