package vatec.problem_2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	public static void main(String args[]) throws Exception	{
		Scanner scanner = new Scanner(new FileInputStream("src/vatec/problem_2/test_case_1.txt"));
		//Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();		// 시작 숫자
		int b = scanner.nextInt();		// 끝 숫자
		int[] counts = new int[b - a + 1];	// 박수 횟수 저장할 배열
		int result = 0;					// 결과값

		int i = a;
		while(i <= b) {
			// 마지막 자릿수와 값 찾기
			int numberLast = i;
			int mul = 1;
			while(numberLast >= 10) {
				numberLast = numberLast / 10;
				mul *= 10;
			}
			
			int iPrev = i - (numberLast * mul);
			if (iPrev < a) {
				counts[i-a] = getClappingCount(i);
			} else {
				counts[i-a] = counts[iPrev-a]; // 마지막 자릿수를 뺀 배열의 박수 횟수

				if (numberLast == 3 || numberLast == 6 || numberLast == 9) {
					counts[i-a]++; // 마지막 자릿수 값에 따라 박수 횟수 증가
				}
			}
			
			result += counts[i-a];
			i++;
		}
		System.out.println(result);
	}
	
	/**
	 * 입력 숫자에 3, 6, 9가 발생하는 횟수 구하기
	 * @param number 입력 숫자
	 * @return 3, 6, 9가 발생하는 횟수
	 */
	public static int getClappingCount(int number) {
		int temp = number;
		int count = 0;
		do {
			int i = temp % 10;
			if(i == 3 || i == 6 || i == 9) {
				count++;
			}
			temp /= 10;
		} while(temp > 0);
		return count;
	}
}