package baekjun.p10798;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p10798/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	String[] strings = new String[5];
    	int[] lengthOfStrings = new int[5];
    	int maxLength = 0;
    	for(int i = 0; i < 5; i ++) {
    		strings[i] = scanner.nextLine();
    		lengthOfStrings[i] = strings[i].length();
    		if(lengthOfStrings[i] > maxLength) maxLength = lengthOfStrings[i];
    	}
    
    	for(int i = 0; i < maxLength; i ++) {
    		for(int j = 0; j < 5; j ++) {
    			if(i < lengthOfStrings[j]) {
    				System.out.print(strings[j].charAt(i));
    			}
    		}
    	}
    }
}