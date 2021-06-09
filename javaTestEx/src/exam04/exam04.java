package exam04;

public class exam04 {
	public static void main(String[] args) {
		
		String[] arr = {"010102-2", "991012-1", "960304-1", "881012-2", "040403-1"};
		
		int count10 = 0;
		int count20 = 0;
		int count30 = 0;
		int count40 = 0;
		int num = 0;
		String sex;
		int female = 0;
		int male = 0;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = arr[i].substring(0, 2);
			num = Integer.parseInt(arr[i]);
			if(num >= 80) {
				num = num + 1900;
			}
			else {
				num = num + 2000;
			}
			
			int age = (2021 - num) / 10;
			
			
			if(age == 1) {
				count10++;
			}
			else if(age == 2) {
				count20++;
			}
			else if(age == 3) {
				count30++;
			}
			else {
				count40++;}
			
		}
		
		String[] array = {"010102-2", "991012-1", "960304-1", "881012-2", "040403-1"};
		
		for(int i = 0; i<array.length; i++) {
			array[i] = array[i].substring(7);
			if(array[i].equals("2")) {
				sex = "여";
				female++;
			}
			else {
				sex = "남";
				male++;
			}
			
		}
		System.out.printf("남 %d 여 %d\n", male, female);
		System.out.println("10대 " + count10 + "명");
		System.out.println("10대 " + count20 + "명");
		System.out.println("10대 " + count30 + "명");
		System.out.println("10대 " + count40 + "명");
	}
}
