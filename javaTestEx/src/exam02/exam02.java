package exam02;

public class exam02 {
	
	class Bird {
		public void fly() {
			System.out.println("Fly.");
		}
	}

	class Peacock extends Bird {
		public void dance() {
			System.out.println("Dance.");
		}
	}

	public static void main(String[] args) {

		Peacock b = new Peacock();
		Bird p = (Bird) p;
		
//		Bird b = new Peacock();
//		Peacock p = (Peacock)b;

		p.fly();
		p.dance();

	}
}
