package baekjun.p1753;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
    	Scanner scanner = new Scanner(new FileInputStream("src/baekjun/p1753/sample_input.txt"));
    	//Scanner scanner = new Scanner(System.in);
    	
    	class Element implements Comparable<Element>{
    	    private int index;
    	    private int distance;
    	    
    	    Element(int index, int distance){
    	        this.index = index;
    	        this.distance = distance;
    	    }
    	    
    	    public int getIndex(){
    	        return index;
    	    }
    	    
    	    public int getDistance(){
    	        return distance;
    	    }
    	    
    	    public int compareTo(Element o){
    	        return distance <= o.distance ? -1 : 1;
    	    }
    	}
    	
    	int V = scanner.nextInt();
    	int E = scanner.nextInt();
    	int inf = 100;
    	
    	int[][] graph = new int[V][V];
    	for(int i = 0; i < V; i ++) {
    		for(int j = 0; j < V; j ++) {
    			graph[i][j] = inf;
    		}
    	}
    	
    	int startV = scanner.nextInt() - 1;
    	
    	for(int i = 0; i < E; i ++) {
    		 int u = scanner.nextInt() - 1;
    		 int v = scanner.nextInt() - 1;
    		 int value = scanner.nextInt();
    		 if(graph[u][v] > value) graph[u][v] = value;
    	}
    	
    	boolean[] visit = new boolean[V];
    	int[] dis = new int[V];
    	int[] prev = new int[V];
    	
		// 초기화
		for (int i = 0; i < V; i++) {
			visit[i] = false;
			dis[i] = inf;
			prev[i] = startV;
		}

		PriorityQueue<Element> q = new <Element> PriorityQueue();
		dis[startV] = 0; // 시작지점부터 시작지점까지 거리는 0
		q.offer(new Element(startV, dis[startV]));

		while (!q.isEmpty()) { // 정점 갯수만큼 반복
			int visitV = q.peek().getIndex();
			int disMin = q.peek().getDistance();
			q.poll();
			
			if(disMin > dis[visitV]) {
				continue;
			}

			if (disMin == inf) {
				break;
			}

			visit[visitV] = true;

			for (int j = 0; j < V; j++) {
				if (dis[visitV] + graph[visitV][j] < dis[j]) {
					dis[j] = dis[visitV] + graph[visitV][j];
					q.offer(new Element(j, dis[j]));
				}
			}
		}
		
		for(int i = 0; i < V; i++) {
			if (dis[i] == inf)
				System.out.println("INF");
			else
				System.out.println(dis[i]);
		}
    }
}