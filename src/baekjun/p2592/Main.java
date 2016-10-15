package baekjun.p2592;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p2592/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int sum = 0;
    	for(int i = 0; i < 10; i ++) {
    		int n = scanner.nextInt();
    		sum += n;
    		if(map.containsKey(n)) {
    			map.put(n, map.get(n) + 1);
    		} else {
    			map.put(n, 1);
    		}
    	}
    	System.out.println(sum/10);
    	
    	int number = 0;
    	int count = 0;
    	Set set = (Set) map.keySet();
    	Iterator<Integer> it = set.iterator();
    	while(it.hasNext()) {
    		int n = it.next();
    		if(map.get(n) > count) {
    			number = n;
    			count = map.get(n);
    		}
    	}
    	System.out.println(number);
    }
}