package chapter02;

import java.util.Scanner;

public class check2_4 {
	public static void main(String[] args) {
		
		//Q1
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s\n", tel1, tel2, tel3);
		
		System.out.println();
		
		//Q2
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 수:");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두번째 수:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과:" + result);
		
		System.out.println();
		
		//Q3
		System.out.println("[필수 정보 입력]");
		String q3name = scanner.next();
		String q3id = scanner.next();
		String q3tel = scanner.next();
		System.out.println("1. 이름: " + q3name);
		System.out.println("2. 주민번호 앞 6자리: " + q3id);
		System.out.println("3. 전화번호: " + q3tel);
		
		//Q3 Answer
		System.out.println("[필수 정보 입력]");
		
		System.out.println("1. 이름: ");
		String name_a = scanner.nextLine();
		
		System.out.println("2. 주민번호 앞 6자리: ");
		String ssn = scanner.nextLine();
		
		System.out.println("3. 전화번호: ");
		String tel_a = scanner.nextLine();
		
		System.out.println();
		
		System.out.println("[입력된 내용]");
		System.out.println("1. 이름: " + name_a);
		System.out.println("2. 주민번호 앞 6자리: " + ssn);
		System.out.println("3. 전화번호: " + tel_a);
	}
}
