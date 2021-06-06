package self.model.view;

import java.util.ArrayList;
import java.util.Scanner;

import self.memo.access.MemoList;
import self.memo.model.Memo;
import self.model.util.ScannerUtil;

public class MemoCliApp {

	MemoList memoList = new MemoList();
	Scanner scanner = new Scanner(System.in);

	public void start() {
		int menunum;

		do {
			// 메뉴타이틀
			menuTitle();

			// 메뉴선택
			menunum = ScannerUtil.readInt("선택");

			// 실행
			switch (menunum) {
			case 1:
				input();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				findDate();
				break;
			case 6:
				findContent();
				break;
			}
		} while (menunum != 0);

	}

	public void menuTitle() {
		System.out.println("[메모관리]");
		System.out.println("1.메모등록");
		System.out.println("2.메모수정");
		System.out.println("3.메모삭제");
		System.out.println("4.전체조회");
		System.out.println("5.날짜로 메모조회");
		System.out.println("6.내용으로 메모조회");
		System.out.println("0.종료");
	}

	// 1.메모등록
	public void input() {
		Memo memo = ScannerUtil.readMemo();
//		String date = ScannerUtil.readStr("날짜");
//		String content = ScannerUtil.readStr("내용");
//		Memo memo = new Memo(date, content);
		memoList.input(memo);
	}

	// 2.메모수정
	public void update() {
		Memo memo = new Memo();
		memo.setDate(ScannerUtil.readStr("수정할 날짜"));
		memo.setContent(ScannerUtil.readStr("변경할 내용"));
		memoList.update(memo);
	}

	// 3.메모삭제(데이터 검색해서 내용 삭제)
	public void delete() {
		String date = ScannerUtil.readStr("날짜");
		memoList.delete(date);
	}

	// 4.전체조회
	public void selectAll() {
		ArrayList<Memo> memos = memoList.selectAll();
		for (Memo memo : memos) {
			System.out.println(memo);
		}
	}

	// 5.날짜로 조회
	public void findDate() {
		String date = ScannerUtil.readStr("검색할 날짜");
		Memo memo = memoList.findDate(date);
		System.out.println(memo);
	}

	// 6.내용으로 조회
	public void findContent() {
		String content = ScannerUtil.readStr("검색할 내용");
		Memo memo = memoList.findContent(content);
		System.out.println(memo);
	}

}
