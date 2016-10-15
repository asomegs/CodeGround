package vatec.problem_1;

import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	public static void main(String args[]) throws Exception	{
		Scanner scanner = new Scanner(new FileInputStream("src/vatec/problem_1/usaco10.txt"));
		//Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();	// 울타리 갯수
		int a = scanner.nextInt();	// 목적지 위치 x
		int b = scanner.nextInt();	// 목적지 위치 y
		
		int x = 0;			// 시야 위치 x
		int y = 0;			// 시야 위치 y
		int direction = 0;	// 시야가 이동하고 있는 방향 (x++ -> 0, y-- -> 1, x-- -> 2, y++ -> 3)
		HashSet<String> visited = new HashSet<String>();
		
		// 거울 클래스
		class Mirror {
			int x;			// 거울 위치 x
			int y;			// 거울 위치 y
			String shape;	// 거울이 놓여있는 모양("/" or "\")
			
			public Mirror(){};
			public Mirror(int x, int y, String shape) {
				this.x = x;
				this.y = y;
				this.shape = shape;
			}
		}
	
		// 거울 배열에 삽입
		Mirror[] mirrors = new Mirror[N];
		for(int i = 0; i < N; i ++) {
			mirrors[i] = new Mirror(scanner.nextInt(), scanner.nextInt(), scanner.next());
		}
		
		// 거울 안바꾸고 목적지 도착하는지 확인
		boolean hasNext = true;
		while(hasNext) {
			// 이동하는 방향에 목적지 유/무 확인
			int distanceToGoal = getDistanceToObject(x, y, direction, a, b);
			if(distanceToGoal > -1) {
				System.out.println("0");
				return;
			}
			
			// 이동하는 방향에 거울 유/무 및 가장 가까운 거울확인
			Mirror mirrorProximate = new Mirror();
			int distanceMin = -1;
			for (int i = 0; i < mirrors.length; i++) {
				Mirror mirror = mirrors[i];
				int distance = getDistanceToObject(x, y, direction, mirror.x, mirror.y);
				if (distance > -1) {
					if (distanceMin > distance || distanceMin == -1) {
						mirrorProximate = mirror;
						distanceMin = distance;
					}
				}
			}
			
			if(distanceMin > -1) {
				x = mirrorProximate.x;
				y = mirrorProximate.y;
				direction = getDirection(direction, mirrorProximate.shape);
				if(visited.contains(x + "," + y + "," + direction)) {
					hasNext = false;
				} else {
					visited.add(x + "," + y + "," + direction);
				}
			} else {
				hasNext = false;
			}
		}
		
		// 시야의 위치,방향 초기화
		x = 0;
		y = 0;
		direction = 0;
		visited.clear();
		hasNext = true;
		
		// 시야 이동하면서 거울 만날 시 거울의 모양 바꿔서 진행해보고 아니면 취소하고 계속 진행
		int result = -1;
		while(hasNext) {
			// 이동하는 방향에 거울 유/무 및 가장 가까운 거울확인
			Mirror mirrorProximate = new Mirror();
			int distanceMin = -1;
			for(int i = 0; i < mirrors.length; i ++) {
				Mirror mirror = mirrors[i];
				int distance = getDistanceToObject(x, y, direction, mirror.x, mirror.y);
				if(distance > -1) {
					if(distanceMin > distance || distanceMin == -1) {
						mirrorProximate = mirror;
						distanceMin = distance;
					}
				}
			}
			
			if(distanceMin > -1) {
				x = mirrorProximate.x;
				y = mirrorProximate.y;
				
				for(int i = 0; i < mirrors.length; i ++) {
					Mirror mirror = mirrors[i];
					if(x == mirror.x && y == mirror.y) {
						// 거울을 만났을 때, 해당 거울 shape를 바꿔서 진행 시 골인지점으로 가는지 확인
						
						// 임시 변수 설정
						int xTemp = x;
						int yTemp = y;
						int directionTemp = direction;
						HashSet<String> visitedTemp = new HashSet<String>();
						Mirror mirrorTemp = new Mirror(mirror.x, mirror.y, mirror.shape);
						
						// 거울의 shape변경
						if(mirrorTemp.shape.equals("/")) {
							mirrorTemp.shape = "\\";
						} else {
							mirrorTemp.shape = "/";
						}
						
						// 변경된 거울로 방향 변경
						directionTemp = getDirection(directionTemp, mirrorTemp.shape);
						
						// 변경된 거울부터 탐색 시작
						boolean hasNextTemp = true;
						while(hasNextTemp) {
							// 이동하는 방향에 목적지 유/무 확인
							int distanceToGoalTemp = getDistanceToObject(xTemp, yTemp, directionTemp, a, b);
							if(distanceToGoalTemp > -1) {
								if(result > i + 1 || result == -1) {
									result = i + 1;
								}
								break;
							}
							
							// 이동하는 방향에 거울 유/무 및 가장 가까운 거울확인
							Mirror mirrorProximateTemp = new Mirror();
							int distanceMinTemp = -1;
							for(int j = 0; j < mirrors.length; j ++) {
								Mirror m = mirrors[j];
								int distanceTemp = getDistanceToObject(xTemp, yTemp, directionTemp, m.x, m.y);
								if(distanceTemp > -1) {
									if(distanceMinTemp > distanceTemp || distanceMinTemp == -1) {
										mirrorProximateTemp = m;
										distanceMinTemp = distanceTemp;
									}
								}
							}
							
							if(distanceMinTemp > -1) {
								xTemp = mirrorProximateTemp.x;
								yTemp = mirrorProximateTemp.y;
								directionTemp = getDirection(directionTemp, mirrorProximateTemp.shape);
								if(visitedTemp.contains(xTemp + "," + yTemp + "," + directionTemp)) {
									hasNextTemp = false;
								} else {
									visitedTemp.add(xTemp + "," + yTemp + "," + directionTemp);
								}
							} else {
								hasNextTemp = false;
							}
						}
						
						// 기존 진행하던 것 방향 업데이트
						direction = getDirection(direction, mirror.shape);
						if(visited.contains("x" + "," + y + "," + direction)) {
							hasNext = false;
						} else {
							visited.add("x" + "," + y + "," + direction);
						}
					}
				}
			} else {
				hasNext = false;
			}
		}
		System.out.println(result);
	}
	
	/**
	 * 진행중인 방향과 만난 거울의 모양을 통해 반사되는 방향 리턴
	 * @param currentDirection 진행중인 방향
	 * @param mirrorShape 거울의 모양
	 * @return x++ -> 0, y-- -> 1, x-- -> 2, y++ -> 3
	 */
	public static int getDirection(int currentDirection, String mirrorShape) {
		int direction = -1;
		if(mirrorShape.equals("/")) {
			if(currentDirection == 0) {
				direction = 3;
			} else if(currentDirection == 1) {
				direction = 2;
			} else if(currentDirection == 2) {
				direction = 1;
			} else {
				direction = 0;
			}
		} else if(mirrorShape.equals("\\")) {
			if(currentDirection == 0) {
				direction = 1;
			} else if(currentDirection == 1) {
				direction = 0;
			} else if(currentDirection == 2) {
				direction = 3;
			} else {
				direction = 2;
			}
		} else {
			return direction;
		}
		return direction;
	}
	
	/**
	 * 시야에서 상,하,좌,우로 진행할 때 Object와의 거리
	 * @param x 시야 위치 x
	 * @param y 시야 위치 y
	 * @param direction 이동 방향
	 * @param xObject Object 위치 x
	 * @param yObject Object 위치 y
	 * @return 상,하,좌,우로 이동해서 만난다면 이동하는 거리 리턴, 만나지 못한다면 -1 리턴
	 */
	public static int getDistanceToObject(int x, int y, int direction, int xObject, int yObject) {
		int distance = -1;
		if(direction == 0) {
			if(x < xObject && y == yObject) {
				distance = xObject - x;
			}
		} else if(direction == 1) {
			if(x == xObject && y > yObject) {
				distance = y - yObject;
			}
		} else if(direction == 2) {
			if(x > xObject && y == yObject) {
				distance = x - xObject;
			}
		} else {
			if(x == xObject && y < yObject) {
				distance = yObject - y;
			}
		}
		return distance;
	}
}