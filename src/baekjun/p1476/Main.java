package baekjun.p1476;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p1476/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int E = scanner.nextInt(); // 1 <= E <= 15
    	int S = scanner.nextInt(); // 1 <= S <= 28
    	int M = scanner.nextInt(); // 1 <= M <= 19
    	int max = 15*28*19;
    	
    	for(int i = 1; i <= max; i ++) {
    		int e = i % 15;
    		int s = i % 28;
    		int m = i % 19;
    		if(e == 0) e = 15;
    		if(s == 0) s = 28;
    		if(m == 0) m = 19;
    		if(e == E && s == S && m == M) {
    			System.out.println(i);
    			break;
    		}
    	}
    }
}