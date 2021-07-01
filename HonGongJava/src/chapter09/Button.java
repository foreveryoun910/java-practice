package chapter09;

/*
 * 윈도우 및 안드로이드 등의 UI 프로그램에서
 * 버튼의 클릭 이벤트를 처리하기 위해 익명 구현 객체를 이용하는 방법
 */
public class Button {
	
	//중첩 인터페이스 타입으로 필드 선언
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	//버튼 이벤트가 발생했을 때(touch() 메소드가 실행되었을 때
	//인터페이스를 통해 구현 객체의 메소드 호출
	void touch() {
		listener.onClick();
	}
	
	
	//중첩 인터페이스
	static interface OnClickListener {
		void onClick();
	}
}
