package chapter09;

public class VehicleAnonymousExample {
	public static void main(String[] args) {
		
		VehicleAnonymous anony = new VehicleAnonymous();
		
		anony.field.run();
		anony.method1();
		anony.method2(
				new Vehicle() {
					@Override
					public void run() {
						System.out.println("트럭이 달립니다.");
					}
				});
	}
}
