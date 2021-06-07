package chapter04;

public class check4_2_3 {

	public static void main(String[] args) {

		int n1 = 0;
		int n2 = 0;
		
		while(true) {
			n1 = (int) (Math.random() * 6) + 1;
			n2 = (int) (Math.random() * 6) + 1;
			System.out.println("(" + n1 + ", " + n2 + ")");
			
			if(n1 + n2 == 5) {
				break;
			}
		}
	}

}
