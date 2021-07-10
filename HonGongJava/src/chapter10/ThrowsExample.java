package chapter10;
/*
 * 예외 처리 떠넘기기
 * main() 메소드에서 예외를 떠넘기면 JVM이 최종적으로 예외처리(예외 내용 출력)
 * main() 메소드에서 throws Exception을 사용하는 것은 좋지 못한 예외 처리 방법
 * main()에서 try-catch 블록으로 예외를 최종 처리하는 것이 바람직하다
 */
public class ThrowsExample {
	public static void main(String[] args) {
		
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
	
	
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
