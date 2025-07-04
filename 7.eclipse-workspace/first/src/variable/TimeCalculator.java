package variable;

import java.text.NumberFormat;
import java.util.Locale;

public class TimeCalculator {
		public static void main(String[] args) {
		System.out.println("=== 시간 계산기 ===");
		System.out.println();
		NumberFormat numberformat = NumberFormat.getNumberInstance(Locale.KOREA);
		// 위 포맷을 사용하여 큰 숫자를 천의 단위에서 ,로 끊어서 표시할 수 있음
		
		int totalSeconds = 7395;
		//초를 시, 분, 초로 변환
		System.out.println("--- 시간 변환 ---");
		System.out.println("총 초: "+numberformat.format(totalSeconds)+ " 초");

		// 1시간 = 60분 * 60초 = 3600초
		int hour = totalSeconds/3600;
		int remainSeconds = totalSeconds % 3600; //이 값을 가지고 분,초를 구하기
		int minutes = remainSeconds / 60;  //1분 = 60초;
		int seconds = remainSeconds % 60; // 나머지인 초 계산;
		
		System.out.println("변환 결과 : "+hour+"시간 "+minutes+"분 "+seconds+" 초\n");
		System.out.println();
		
		System.out.println("--- 근무시간 계산 ---");
		int dailyWorkingHour = 8;
		int monthlyWorkingDays =22;
		int hourlyWage = 15000;	
		int monthlyWorkingHour = dailyWorkingHour * monthlyWorkingDays;
		int dailyWage = dailyWorkingHour * hourlyWage;
		int monthlyWage = dailyWage * monthlyWorkingDays;

		System.out.println("일일 근무시간: "+dailyWorkingHour+"시간");
		System.out.println("월 근무일수: "+monthlyWorkingDays+"일");
		System.out.println("시급: "+numberformat.format(hourlyWage)+"원\n");
		System.out.println("월 총 근무시간: "+monthlyWorkingHour+"시간" );
		System.out.println("일급: "+numberformat.format(dailyWage)+"원");
		System.out.println("월급: "+numberformat.format(monthlyWage)+"원\n");
		System.out.println();
		System.out.println("--- 추가 정보 ---");

		int year = 12;
		int yearlyWorkingHour = year * monthlyWorkingHour;
		int yearlyWage = year * monthlyWage;
		System.out.println("연간 총 근무시간: "+numberformat.format(yearlyWorkingHour)+"시간");
		System.out.println("연봉: "+numberformat.format(yearlyWage)+"원");
		
		int second = 60;
		int minute = 60;
		int hours = 24;
		int days = 7;
		int secondDay = hours * minute * second;
		int minuteWeek = days * hours * minute;
		System.out.println("하루는 총 "+numberformat.format(secondDay)+"초입니다.");
		System.out.println("일주일은 총 "+numberformat.format(minuteWeek)+"분입니다.");		
	}
}
