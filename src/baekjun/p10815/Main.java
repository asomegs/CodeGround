package baekjun.p10815;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p10815/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int[] positives = new int[10000001];
    	int[] negatives = new int[10000001];
    	int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int card = scanner.nextInt();
			if(card >= 0) {
				positives[card] = 1;
			} else {
				negatives[card*(-1)] = 1;
			}
		}
    	int m = scanner.nextInt();
    	for(int i = 0; i < m; i ++) {
    		int card = scanner.nextInt();
    		if(card >= 0) {
    			if(positives[card] == 1) System.out.print("1 ");
    			else System.out.print("0 ");
    		} else {
    			if(negatives[card*(-1)] == 1) System.out.print("1 ");
    			else System.out.print("0 ");
    		}
    	}
    }
}