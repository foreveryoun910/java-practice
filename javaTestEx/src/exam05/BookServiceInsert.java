package exam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceInsert implements BookService {
	BookList list = new BookList();
	Scanner scanner = new Scanner(System.in);

	//book의 isbn이 중복되는지 확인하고 등록

	@Override
	public void execute(BookList bookList) {

		List<Book> book = new ArrayList<Book>();
		for (Book el : book) {
			System.out.println(el);


		}

	}
}
