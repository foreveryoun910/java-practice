package chapter09;

/*
 * 메소드가 종료된 후에도 익명 스레드 객체는 실행 상태로 존재
 * 익명 객체 내부에서 사용되는 매개 변수와 로컬 변수는 final 특성을 가진다
 */
public class CalAnonymous {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		//arg1 = 20;	<--- (X)
		//arg2 = 20;	<--- (X)
		
		//var1 = 30;	<--- (X)
		//var2 = 30;	<--- (X)
		
		Calculatable calc = new Calculatable() {
			@Override
			public int sum() {
				int result = field + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		
		System.out.println(calc.sum());
	}
}