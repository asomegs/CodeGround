package baekjun.p2503;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p2503/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int n = scanner.nextInt();
    	int[] num = new int[100];
    	int[] s = new int[100];
    	int[] b = new int[100];
    	int count = 0;
    	
    	
    	for(int i = 0; i < n; i ++) {
    		num[i] = scanner.nextInt();
    		s[i] = scanner.nextInt();
    		b[i] = scanner.nextInt();
    	}

    	for(int i = 123; i < 988; i ++) {
    		int a1 = (i / 100) % 10;
    		int a2 = (i / 10) % 10;
    		int a3 = i % 10;
    		
    		if(a1 != a2 && a2 != a3 && a1 != a3 && a1 != 0 && a2 != 0 && a3 != 0) {
    			boolean canBeAnswer = true;
    			for(int j = 0; j < n; j ++) {
    				int strike = 0;
    				int ball = 0;
    				int b1 = num[j] / 100 % 10;
    				int b2 = num[j] / 10 % 10;
    				int b3 = num[j] % 10;
    				
    				if(a1 == b1) strike++;
    				if(a2 == b2) strike++;
    				if(a3 == b3) strike++;
    				if(a1 == b2) ball++;
    				if(a1 == b3) ball++;
    				if(a2 == b3) ball++;
    				if(a2 == b1) ball++;
    				if(a3 == b1) ball++;
    				if(a3 == b2) ball++;
    				
    				if(s[j] != strike || b[j] != ball) {
    					canBeAnswer = false;
    					break;
    				}
    			}
    			if(canBeAnswer == true) {
    				count ++;
    			}
    		}
    	}
    	System.out.println(count);
    	return;
    }
}