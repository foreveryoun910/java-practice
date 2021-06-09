package exam05;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService {

	Scanner scanner = new Scanner(System.in);
	BookList list = new BookList();
	
	//이름을 입력하면 이름을 포함하는 모든 도서를 출력
	@Override
	public void execute(BookList bookList) {
		System.out.print("입력> ");
		String name = scanner.next();	//이름을 입력
		
		List<Book> book = bookList.findName(name);
		for(Book el : book) {
			System.out.println(el);
		}
		
	}

}
