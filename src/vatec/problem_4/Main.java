package vatec.problem_4;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	public static void main(String args[]) throws Exception	{
		Scanner scanner = new Scanner(new FileInputStream("src/vatec/problem_4/test_case_2.txt"));
		//Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();		// 시작 숫자
		int b = scanner.nextInt();		// 끝 숫자
		int[] counts = new int[b - a + 1];	// 박수 횟수 저장할 배열
		int result = 0;					// 결과값
		
		while(a <= b) {
			int mid = (a+b) / 2;
			
		}
		
		
		System.out.println(result);
	}
	
	public static int binarySearch(int start, int end) {
		int result = 0;
		int mid = end - start;
		if(mid > start) binarySearch(start, mid);
		else {
			
		}
		if(end > mid) binarySearch(mid, end);
		else {
			
		}
		return result;
	}
}