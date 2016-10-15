package baekjun.p7568;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p7568/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int N = scanner.nextInt();
    	int[] w = new int[N];
    	int[] h = new int[N];
    	int[] rank = new int[N];
    	
    	for(int i = 0; i < N; i ++) {
    		w[i] = scanner.nextInt();
    		h[i] = scanner.nextInt();
    	}
    	
    	for(int i = 0; i < N; i ++) {
    		for(int j = 0; j < N; j ++) {
    			if(i == j) continue;
    			if(w[j] > w[i] && h[j] > h[i]) {
    				rank[i]++;
    			}
    		}
    		rank[i]++;
    		System.out.print(rank[i] + " ");
    	}
    }
}