package chapter09;

/*
 * 메소드가 종료된 후에도 익명 스레드 객체는 실행 상태로 존재
 * 익명 객체 내부에서 사용되는 매개 변수와 로컬 변수는 final 특성을 가진다
 */
public interface Calculatable {

	public int sum();
}
