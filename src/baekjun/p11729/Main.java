package baekjun.p11729;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p11729/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int N = scanner.nextInt(); // 1 <= N <= 20
    	int count = 1;
    	for(int i = 0; i < N; i++) {
    		count *= 2;
    	}
    	System.out.println(count-1);
    	hanoi(N, 1, 3, 2);
    	
    }
	
	static void hanoi(int k, int from, int to, int spare) {
		if (k != 1){
	        hanoi(k-1,from, spare,to);
	        hanoi(1, from, to, spare);
	        hanoi(k-1, spare, to, from);
	    }
	    else {
	        System.out.println(from + " " + to);
	        return;
	    }
	}
}