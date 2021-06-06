package self.memo.access;

import java.util.ArrayList;

import self.memo.model.Memo;

public interface MemoAccess {

	
	//1.메모등록
	public void input(Memo memo);
	
	//2.메모수정
	public void update(Memo memo);
	
	//3.메모삭제(데이터 검색해서 내용 삭제)
	public void delete(String date);
	
	//4.전체조회
	public ArrayList<Memo> selectAll();
	
	//5.날짜로 조회
	public Memo findDate(String date);
	
	//6.내용으로 조회
	public Memo findContent(String content);
}
