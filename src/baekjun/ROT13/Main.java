package baekjun.ROT13;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/ROT13/sample_input.txt"));
    	//Scanner scanner =	 new Scanner(System.in);
    	
    	String str = scanner.nextLine();
    	String result = "";
    	for(int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if(c >= 65 && c <= 90) {
    			c += 13;
    			if(c > 90) {
    				c -= 26;
    			}
    		}
    		if(c >= 97 && c <= 122) {
    			c += 13;
    			if(c > 122) {
    				c -= 26;
    			}
    		}
    		result += c;
    	}
    	System.out.println(result);
    }
}