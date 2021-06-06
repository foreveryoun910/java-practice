package self.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	static String format = "yyyy-MM-dd";
	
	//Date -> String 변환해주는 메소드 생성
	public static String dateToString(Date date) {
		
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
		return s;
	}
	public static String dateToString(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
		return s;
	}
	
	//두 날짜 사이의 일수 계산
	public static long durationDay(Date d1, Date d2) {
		
		long result = 0;
		result = d1.getTime() - d2.getTime();
		result = result / 1000 / 60 / 60 / 24;
		return result;		
	}
	
	public static long durationDay(String s1, String s2) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		long result = 0;
		try {
			Date d1 = df.parse(s1);
			Date d2 = df.parse(s2);
			result = d1.getTime() - d2.getTime();
			result = result / 1000 / 60 / 60 / 24;
			
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//해당 월의 마지막 날 ....... 실패;;;
	//뭐가 문제지....getTime 때문인가 이번달 마지막날만 나옴
	//내가 입력하는 month의 마지막날을 보고싶다면...ㅇ떠ㅓㅎ게..?
	public static String lastDay(int year, int month) {
		String result;
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		result = df.format(calendar.getTime());
		return result;
	}
	
	
//	//살아온 일수 계산
//	Calendar birth = Calendar.getInstance();
//	birth.set(1993, 8, 10);
//	long dur = calendar.getTimeInMillis() - birth.getTimeInMillis();
//	dur = dur / 1000 / 60 / 60 / 24;
//	System.out.println("내가 태어난 지: " + dur + "일");
//	
//	
//	//기념일 계산(Calendar)
//	Calendar christmas = Calendar.getInstance();
//	christmas.set(2021, 11, 25);
//	long xmas = christmas.getTimeInMillis() - calendar.getTimeInMillis();
//	xmas = xmas / 1000 / 60 / 60 / 24;
//	System.out.println("크리스마스까지 d-" + xmas + "일");
//	
//	//날짜 조회(LocalDate)
//	LocalDate currentDate = LocalDate.now();
//	System.out.println(currentDate.getYear() + "/" + 
//						currentDate.getMonthValue() + "/" + 
//						currentDate.getDayOfMonth());	//오늘 날짜 출력
//	System.out.println(currentDate.plusDays(100));	//오늘부터 100일 뒤 날짜


	// !!!!!!!!!!!!!!!!! Ctrl + Shift + o : 한번에 import 다 해줌 !!!!!!!!!!!!!!!!!!!!!
	
	
	
}
