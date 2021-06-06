package self.model.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import self.memo.model.Memo;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);
	
	
	//프롬프트 표현 위해서 오버로딩한 클래스
	//오버로딩할 때는 매개변수 타입의 개수, 순서가 중요하다(메소드 이름은 같음)
	public static int readInt(String prompt) {
		System.out.print(prompt + "> ");
		return readInt();
	}
	
	public static int readInt() {
		int result = 0;
		while(true) {
			try {
				String temp = scanner.nextLine();
				result = Integer.parseInt(temp);//scanner.nextInt();
				break;
			} catch(Exception e) {
				System.out.println("숫자 형식이 아닙니다.");
			}
		}
		return result;
	}
	
	
	
	public static String readStr(String prompt) {
		System.out.print(prompt + "> ");
		return readStr();
	}
	
	public static String readStr() {
		String result = "";
		try {
			result = scanner.nextLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//여러줄입력 ---> 메모 내용을 여러줄 쓰고 싶을 때
	//StringBuffer 이용해서 .end 나올 때까지
	
	
	
	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim());	//trim: 공백제거
				break;
			} catch(Exception e) {
				System.out.println("(yyyy-MM-dd) 날짜 형식이 아닙니다.");
			}
		} while(true);
		return result;
	}
	
	
	
	public static Memo readMemo() {
		System.out.print("날짜:내용> ");
		String result = scanner.nextLine();
		String[] arr = result.split(":");	//, 로 입력받았으니까 , 로 split해서 각 요소에 담아준다
//		System.out.println(arr.length);
//		System.out.println(result);
		//arr 크기가 3인지 확인하고 3이 아니면 다시 돌리는 try catch while문 돌려보기
		Memo memo = new Memo(arr[0], arr[1]);
//		Friend friend = new Friend();
//		friend.setGubun(arr[0]);
//		friend.setName(arr[1]);
//		friend.setTel(arr[2]);
		return memo;
	}
	
}
