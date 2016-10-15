package baekjun.p1916;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p1916/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	int numberOfCity = scanner.nextInt(); // 1 <= n <= 1,000
    	int numberOfBus = scanner.nextInt(); // 1 <= n <= 100,000
    	int infinite = 100000001; // 선이 없는 거리
    	int[][] data = new int[numberOfCity][numberOfCity]; // 버스 데이터
    	for(int i = 0; i < numberOfCity; i++) {
    		for(int j = 0; j < numberOfCity; j++) {
    			data[i][j] = infinite;
    		}
    	}
    	
    	boolean[] visit = new boolean[numberOfCity];	// 방문 도시 확인
    	int[] dis = new int[numberOfCity];			// 시작 도시로부터의 거리
    	int[] prev = new int[numberOfCity];			// 이전 도시 저장
    	
    	for(int i = 0; i < numberOfBus; i ++) {
    		int start = scanner.nextInt() - 1;
    		int end = scanner.nextInt() - 1;
    		int value = scanner.nextInt();
    		if(data[start][end] > value) {
    			data[start][end] = value;
    		}
    	}
    	
    	int startCity = scanner.nextInt() - 1;	// 출발 도시
    	int endCity = scanner.nextInt() - 1;	// 도착 도시
    	
    	// 초기화
    	for(int i = 0; i < numberOfCity; i ++) {
    		visit[i] = false;
    		dis[i] = infinite;
    		prev[i] = startCity;
    	}
    	
    	dis[startCity] = 0;	// 시작점의 거리는 0
    	
    	for(int i = 0; i < numberOfCity; i++) {	// 도시의 수만큼 반복
    		int cityVisit = 0;
    		int min = infinite;
    		for(int j = 0; j < numberOfCity; j++) {	// 아직 방문하지 않은 도시 중 거리가 짧은 도시 검색
    			if(visit[j] == false && dis[j] < min) {
    				cityVisit = j;
    				min = dis[j];
    			}
    		}
    		visit[cityVisit] = true;
    		
    		if(min == infinite) break;
    		
    		for(int j = 0; j < numberOfCity; j++) {
    			if(dis[cityVisit] + data[cityVisit][j] < dis[j]) {
    				dis[j] = dis[cityVisit]  + data[cityVisit][j];
    				prev[j] = cityVisit;
    			}
    		}
    	}
    	if(numberOfCity == 1) System.out.println(0);
    	else System.out.println(dis[endCity]);
    }
}