package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_정혜주 {
	
	static int[][] arr;
	static int N;
	// 우 하 좌 상
	static int[][] deltas = {{1,0}, {0,-1}, {-1,0}, {0, 1}};
	static int cnt = 0;
	static int check = 0;
	
	public static int countMethod(int temp_x, int temp_y, int dir) {
		
		
		if(check==4) return 0;
		
		
		// 경계 체크 -> 경계 안에 있다면
		if(N>temp_x+arr[dir][0] && temp_x+arr[dir][0]>=0 
				&& N>temp_y+arr[dir][1] && temp_y+arr[dir][1]>=0) {
			// 탐색
			if(arr[temp_x][temp_y]+1 
					== arr[temp_x+arr[dir][0]][temp_y+arr[dir][1]]) {
				// 주변에 1큰 애가 있다면 해당 좌표로 셋팅하고 cnt++
				temp_x = temp_x+arr[dir][0];
				temp_y = temp_y+arr[dir][1];
				cnt++;
				check=0;
			}else {
				// dir 바꾸기 
				dir = (dir+1)%4;	// 우 하 좌 상 순...
			}
		}else {
			// dir 바꾸기 
			dir = (dir+1)%4;	// 우 하 좌 상 순...
		}
		check++ ;
		
		countMethod(temp_x, temp_y, dir);
		return arr[temp_x][temp_y];
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// N*N 개의 방
		// 1~N*N의 숫자가 적혀있음
		// 자기보다 +1인 인접한 방에 이동 가능
		// 처음에 어떤 수가 적힌 방에 있어야 가장 많은 방 이동 가능??
		// 중복인 경우 작은 숫자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// (0,0)부터 상하좌우 탐색(경계체크) -> 나보다 1이 큰 애가 있는지
			// 1이 큰 애가 있다면 해당 좌표로 이동(계속 count)
			// 없으면 (0,0)에서 우측으로 한칸 이동 (경계벗어나면 한줄내려가고 방향 바꾸기)

			int x=0, y=0, dir=3;
			int temp_x=x;
			int temp_y=y;
			int cycle=0;
			
			int[] cntArr = new int[N+1];

			
			while(true) {
				
				if(cycle==4) {
					
					for(int i=0; i<4; i++) {
						// 포인트에서 상하좌우 모두 탐색했다면
						// 다음 좌표로 이동
						if(N>temp_x+arr[dir][0] && temp_x+arr[dir][0]>=0 
								&& N>temp_y+arr[dir][1] && temp_y+arr[dir][1]>=0) {
							x += arr[dir][0];
							y += arr[dir][1];
							
							temp_x = x;
							temp_y = y;
							cycle = 0;
							break;
						}else {
							dir = (dir+1)%4;
						}
					}
					
				}
				
				cntArr[countMethod(temp_x, temp_y, dir)] = cnt;
				cnt = 0;
				// 싸이클 계산
				cycle++;
				
			}
			
			Arrays.sort(cntArr);
			

		}
	}
}
