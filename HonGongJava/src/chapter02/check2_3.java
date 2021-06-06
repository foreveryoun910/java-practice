package chapter02;

public class check2_3 {
	public static void main(String[] args) {
		
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result = (int)var1 + (int)(var2 + var3) + (int)(Double.parseDouble(var4));
		System.out.println(result);
		
		String str1 = 2 + 3 + "";
		System.out.println(str1);
	}
}
