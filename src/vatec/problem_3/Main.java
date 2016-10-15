package vatec.problem_3;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new FileInputStream("src/vatec/problem_3/usaco10.txt"));
		//Scanner scanner = new Scanner(System.in);
		
		int open = 0;	// 여는 괄호 횟수
		int close = 0;	// 닫는 괄호 횟수
		
		// 앞에서부터 체크
		String str = "";
		while(scanner.hasNext()) {
			String x = scanner.next();
			str += x;
			if(x.equals("(")) {
				open++;
			} else {
				close++;
			}
			// 닫는 괄호 횟수가 여는 괄호 횟수보다 많아지는 순간 이전의 닫는 괄호를 여는 괄호로 변경하는 경우의 수가 답
			if(close > open) {
				System.out.println(close);
				return;
			}
		}
		
		// 뒤에서부터 체크
		open = 0;
		close = 0;
		int length = str.length();
		for(int i = 0; i < length; i ++) {
			char c = str.charAt(length - i - 1);
			if(c == ')') {
				open++;
			} else {
				close++;
			}
			if(close > open) {
				System.out.println(close);
				return;
			}
		}
		
		// 이상 없음
		System.out.println(0);
	}
}