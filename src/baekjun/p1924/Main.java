package baekjun.p1924;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p1924/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int month = scanner.nextInt();
    	int day = scanner.nextInt();
    	int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    	
    	int a = 1;
    	int b = 1;
    	int dayOfWeek = 0;
    	while(a != month || b != day) {
    		b++;
    		if(b > daysOfMonth[a-1]) {
    			a++;
    			b = 1;
    		}
    		dayOfWeek++;
    		if(dayOfWeek > 6) {
    			dayOfWeek = 0;
    		}
    	}
    	System.out.println(daysOfWeek[dayOfWeek]);
    }
}