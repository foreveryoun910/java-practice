package exam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceInsert implements BookService {
	Scanner scanner = new Scanner(System.in);

	//book의 isbn이 중복되는지 확인하고 등록
	@Override
	public void execute(BookList bookList) {
		List<Book> books = new ArrayList<Book>();
		//bookList.insert(bookList.book.getIsbn());
		for(Book b : books) {
			if(b.getIsbn().equals(bookList.book.getIsbn())) {
				continue;
			}
			else {				
				System.out.println(b);
			}


		}

	}
}
