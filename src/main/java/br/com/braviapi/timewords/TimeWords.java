package br.com.braviapi.timewords;

import java.util.Scanner;

public class TimeWords {

	public static void main(String[] args) {
        String[] numberWords = new String[] {
				"",
				"one",
				"two",
				"three",
				"four",
				"five",
				"six",
				"seven",
				"eight",
				"nine",
				"ten",
				"eleven",
				"twelve",
				"thirteen",
				"fourteen",
				"fifteen",
				"sixteen",
				"seventeen",
				"eighteen",
				"nineteen",
				"twenty",
				"twenty one",
				"twenty two",
				"twenty three",
				"twenty four",
				"twenty five",
				"twenty six",
				"twenty seven",
				"twenty eight",
				"twenty nine"
		};
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digite a hora");
		int hour = in.nextInt();

		System.out.println("Digite os minutos");
		int minute = in.nextInt();
		
		int nextHour = (hour % 12) + 1;
		
		if(minute == 0) {
			System.out.printf("%s o' clock\n", numberWords[hour]);
		}
		
		else if(minute == 15) {
			System.out.printf("quarter past %s\n", numberWords[hour]);
		}
		
		else if(minute == 30) {
			System.out.printf("half past %s\n", numberWords[hour]);
		}
		
		else if(minute == 45) {
			System.out.printf("quarter to %s\n", numberWords[nextHour]);
		}
		
		else if(minute < 30) {
			System.out.printf("%s minutes past %s\n", numberWords[minute], numberWords[hour]);
		}
		
		else {
			System.out.printf("%s minutes to %s\n", numberWords[60 - minute], numberWords[nextHour]);
		}

	}
	
	
}
