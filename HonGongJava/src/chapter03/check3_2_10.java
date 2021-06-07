package chapter03;

public class check3_2_10 {

	public static void main(String[] args) {
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		//int를 String으로 바꿀 때: String.valueOf
		
		System.out.println("원의 넚이: " + var4);

	}

}
