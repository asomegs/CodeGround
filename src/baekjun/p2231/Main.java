package baekjun.p2231;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p2231/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int N = scanner.nextInt();
    	int result = 0;
    	for(int i = 0; i < N; i ++) {
    		int number = i;
    		int[] numbers = new int[7];
    		int sum = number;
    		int cnt = 0;
    		while (number > 0) {
    			numbers[cnt] = number % 10;
    			number /= 10;
    			sum += numbers[cnt];
    			cnt ++;
    		}
    		if(sum == N) {
    			result = i;
    			break;
    		}
    	}
    	System.out.println(result);
    }
}