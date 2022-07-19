package etc;

import java.util.Scanner;

public class Robot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A : 우
		// B : 좌 + 우
		// C : 상 + 하 + 좌 + 우

		// 출력 : 각 로봇들이 갈 수 있는 거리

		// 벽이 있는 공간을 만나면 로봇은 더 이상 이동 X
		// 다른 로봇이 있던 초기 위치를 넘어가지 못한다고 가정

		// 1. 이동 위치는 0부터
		// N * N -> 3~20
		
		// switch로 푸는 법
		
		/*
		// delta로 푸는 법
		// 행,열 변화량 --> 
		//     	    우  좌  상  하
		// 행(i) : 0  0 -1 +1
		// 열(j) : 1 -1  0  0
		int[] dr = {0, 0, -1, 1}; // 행의 변화량
		int[] dc = {1, -1. 0, 0}; // 열의 변화량
		// 또는 int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}}; 을 사용해도 좋다
		
		// 또는 robot <= 'c'로 해서 한번 에 처리해도 좋다.
		if(robot == 'A' || robot == 'B' || robot === 'C') {
			
			// A 로봇이면 delta의 0 인덱스 사용
			// B 로봇이면 delta의 0,1 인덱스 사용
			// c 로봇이면 delta의 0,1,2,3 인덱스 사용
			int size = 0;
			if(robot == 'A') {
				size = 1;
			}else if(robot == 'B') {
				size = 2;
			}else{
				size = 4;
			}
			// d: 사용하려는 델타값의 인덱스 번호 
			for(int d = 0; d<size; d++) {
				int r = i;
				int c = j;
				while(true) {
					r += dr[d];
					c += dc[d];
					
					if(r>=0 && r<N && c>=0 && c<N && map[r][c]=='s') answer++;
					// 그 외의 경우는 경계를 벗어나므로 빈 공간이 아니므로 더 이상 볼 필요 없음
					else break; 
				}
			}

		}
		*/
		
		Scanner sc = new Scanner(System.in);

		int  test_case = sc.nextInt();

		for(int tc = 1; tc <= test_case; tc++) {

			// 배열의 크기인 N 입력
			int n = sc.nextInt();

			String [][] arr = new String[n][n]; // char 형으로 받아도 된다.

			// S는 공백, W는 벽,  ABC 로봇
			// S일 경우룰 기준으로 해도 됨!!
			// 입력 받기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++){
					arr[i][j] = sc.next();
				}
			}
			
			int cnt = 0;
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++) {
					int tmp = 0;
					if(arr[i][j].equals("A")) {
						if(j!=(n-1)) tmp = j+1;
						else tmp = j;
						while(!(arr[i][tmp].equals("A")||arr[i][tmp].equals("B")||arr[i][tmp].equals("C")||arr[i][tmp].equals("W"))) {
							cnt++;
							tmp++;
							if(tmp == n) break;
						}
					}else if(arr[i][j].equals("B")) {
						
						//1. 오른쪽으로 가기 
						if(j!=(n-1)) tmp = j+1;
						else tmp = j;
						while(!(arr[i][tmp].equals("A")||arr[i][tmp].equals("B")||arr[i][tmp].equals("C")||arr[i][tmp].equals("W"))) {
							cnt++;
							tmp++;
							if(tmp == n) break;
						}
						
						//2. 왼쪽으로 가기
						if(j!=0) tmp = j-1;
						else tmp = 0;
						while(!(arr[i][tmp].equals("A")||arr[i][tmp].equals("B")||arr[i][tmp].equals("C")||arr[i][tmp].equals("W"))) {
							cnt++;
							tmp--;
							if(tmp<0) break;
							
						}
					}else if(arr[i][j].equals("C")) {
						
						//1. 오른쪽으로 가기 
						if(j!=(n-1)) tmp = j+1;
						else tmp = j;
						while(!(arr[i][tmp].equals("A")||arr[i][tmp].equals("B")||arr[i][tmp].equals("C")||arr[i][tmp].equals("W"))) {
							cnt++;
							tmp++;
							if(tmp==n) break;
							
						}
						
						//2. 왼쪽으로 가기
						if(j!=0) tmp = j-1;
						else tmp = 0;
						while(!(arr[i][tmp].equals("A")||arr[i][tmp].equals("B")||arr[i][tmp].equals("C")||arr[i][tmp].equals("W"))) {
							cnt++;
							tmp--;
							if(tmp<0) break;
							
						}
						
						//3. 아래로 가기
						if(i!=(n-1)) tmp = i+1;
						else tmp = i;
						while(!(arr[tmp][j].equals("A")||arr[tmp][j].equals("B")||arr[tmp][j].equals("C")||arr[tmp][j].equals("W"))) {
							cnt++;
							tmp++;
							if(tmp<0) break;
							
						}
						
						//4. 위로 가기
						if(i!=0) tmp = i-1;
						else tmp = 0;
						while(!(arr[tmp][j].equals("A")||arr[tmp][j].equals("B")||arr[tmp][j].equals("C")||arr[tmp][j].equals("W"))) {
							cnt++;
							tmp--;
							if(tmp==n) break;
							
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
