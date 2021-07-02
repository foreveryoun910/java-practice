package chapter09;

public class WorkerAnonymousExample {
	public static void main(String[] args) {
		
		WorkerAnonymous anony = new WorkerAnonymous();
		
		anony.field.start();
		anony.method1();
		anony.method2(
				new Worker() {
					@Override
					public void start() {
						System.out.println("테스트를 합니다.");
					}
				});
	}
}
