package self.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import self.memo.model.Memo;

public class MemoList implements MemoAccess {

	ArrayList<Memo> memos = new ArrayList<Memo>();
	
	//파일 오픈하는 메소드
	String path = "c:/temp/memo.txt";
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext()) break;
				String str = scanner.nextLine();
				if(str == null) break;
				String[] arr = str.split(":");
				memos.add(new Memo(arr[0], arr[1]));
			}
			scanner.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//파일 저장하는 메소드
	public void save() {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(path));
			for(Memo m : memos) {
				bf.write(String.format("%s %s\n", m.getDate(), m.getContent()));
			} bf.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemoList() {
		open();
	}

	
	//1.메모등록
	@Override
	public void input(Memo memo) {
		memos.add(memo);
		save();
		
	}

	
	//2.메모수정
	@Override
	public void update(Memo memo) {
		for(Memo m : memos) {
			//메모 리스트의 요소(메모들을)하나씩 불러와서 입력받은 날짜랑 날짜 같은 메모 수정하기
			if(m.getDate().equals(memo.getDate())) {
				m.setContent(memo.getContent());
			}
		}
		save();
		
	}

	
	//3.메모삭제(데이터 검색해서 내용 삭제)
	@Override
	public void delete(String date) {
		for(Memo m : memos) {
			if(m.getDate().equals(date)) {
				memos.remove(m);
				save();
				break;
			}
		}
		
	}

	
	//4.전체조회
	@Override
	public ArrayList<Memo> selectAll() {
		System.out.println("MemoList");
		return memos;
	}

	
	//5.날짜로 조회
	@Override
	public Memo findDate(String date) {
		for(Memo m : memos) {
			if(m.getDate().equals(date));
			return m;
		}
		return null;
	}

	
	//6.내용으로 조회
	@Override
	public Memo findContent(String content) {
		for(Memo m : memos) {
			if(m.getContent().contains(content));
			return m;
		}
		return null;
	}
	
	
	
	
}
