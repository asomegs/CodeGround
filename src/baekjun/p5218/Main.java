package baekjun.p5218;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p5218/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int numberOfTestCase = scanner.nextInt();
    	for(int i = 0; i < numberOfTestCase; i ++) {
    		String stringFirst = scanner.next();
    		String stringSecond = scanner.next();
    		int length = stringFirst.length();
    		System.out.print("Distances:");
    		for(int j = 0; j < length; j ++) {
    			char charFirst = stringFirst.charAt(j);
    			char charSecond = stringSecond.charAt(j);
    			int x = (int)charFirst - 64;
    			int y = (int)charSecond - 64;
    			
    			if(y >= x) {
    				System.out.print(" " + (y-x));
    			} else {
    				System.out.print(" " + (y+26-x));
    			}
    		}
    		System.out.println();
    	}
    }
}