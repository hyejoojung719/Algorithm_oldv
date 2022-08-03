package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 풀이
// 공백 기준으로 접근 => 공백의 크기
// 수확 너비 

// N = 7
// 공백 : 3 2 1 0 1 2 3
// 수확너비 : 1 3 5 7 5 3 1
// 공백을 통해 수확 너비를 구할 수 있다.수확 너비 = N - 공백*2
// 공백 초기값 : N/2 --> 행이 절반을 넘어갈 때 다시 증가
// start = 공백
// end = 공백 + 너비 - 1

// 또는 중앙을 기준을 거리를 재서 풀 수 있다..
// (N/2 - gap) + (N/2 + gap)

public class Solution_2805_농작물수확하기_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<N; j++) {
					farm[i][j] = input.charAt(j) - 48;
				}
			}

			int start_cnt = 1;
			int sum = 0;
			int y = N/2;
			// 가운데 기준 상단
			for(int x=0; x<N/2; x++) {
				// 시작 좌표 farm[i][N/2]
				int tmp = y;
				for(int j=0; j<start_cnt; j++) {
					sum += farm[x][tmp];
					tmp++;
				}
				start_cnt += 2;
				y--;
			}
			
			// 가운데
			for(int i=0; i<N; i++) {
				sum += farm[N/2][i];
			}
			
			start_cnt -= 2;
			y++;
			// 가운데 기준 하단
			for(int x=N/2+1; x<N; x++) {
				// 시작 좌표 farm[i][N-1]
				int tmp = y;
				for(int j=0; j<start_cnt; j++) {
					sum += farm[x][tmp];
					tmp++;
				}
				start_cnt -= 2;
				y++;
			}
			
			
			
			
			System.out.println("#"+tc+" "+sum);
		}
	
	}
}
