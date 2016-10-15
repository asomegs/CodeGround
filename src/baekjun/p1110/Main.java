package baekjun.p1110;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p1110/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	int number = scanner.nextInt();
    	int count = 0;
    	int[] numbers = new int[2];
    	numbers[0] = (number/10)%10;
    	numbers[1] = number%10;
    	int[] temp = new int[3];
    	temp[0] = numbers[0];
    	temp[1] = numbers[1];
    	temp[2] = temp[0] + temp[1];
    	do {
    		temp[0] = temp[1];
    		temp[1] = temp[2]%10;
    		temp[2] = temp[0] + temp[1];
    		count++;
    	} while(numbers[0] != temp[0] || numbers[1] != temp[1]);
    	System.out.println(count);
    }
}