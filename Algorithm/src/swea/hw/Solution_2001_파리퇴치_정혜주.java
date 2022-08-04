package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());


		for(int tc = 1; tc <= TC ; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());


			int[][] flies = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					if(i==0  && j==0) flies[i][j] = Integer.parseInt(st.nextToken());
					else if (i==0) {
						flies[i][j] = flies[i][j-1]+Integer.parseInt(st.nextToken());
					}else if (j==0) {
						flies[i][j] = flies[i-1][j]+Integer.parseInt(st.nextToken());
					}else if(0<i && i<N && 0<j && j<N) {
						flies[i][j] = flies[i][j-1]+flies[i-1][j]-flies[i-1][j-1]+Integer.parseInt(st.nextToken());
					}
				}
			}

			// 시작 : 우측 이동
			// 경계에 닿으면 아래로 이동(y는 초기 M-1로)

			int x=M-1, y=M-1; // 시작시 우측 하단 좌표(M크기구간 마지막) 
			int max = flies[x][y++];
			int sum = 0;
			while(true) {
				if(x==N-1 && y==N-1) break;

				// 경계 체크
				if(0<=x-M && 0<=y-M) {
					// 경계 안 닿음
					sum = flies[x][y] - flies[x][y-M] - flies[x-M][y] + flies[x-M][y-M]; 
				}else if(0>y-M) {
					// 왼쪽 경계 닿음
					sum = flies[x][y] - flies[x-M][y];
				}else if(0>x-M) {
					// 위쪽 경계 닿음
					sum = flies[x][y] - flies[x][y-M];
				}

				max = Math.max(max, sum);
				y++; // 좌표 우측 이동
				// 만약 우측 경계에 닿으면 아래로 이동하고 다시 앞으로
				if(y==N){
					x++;
					y=M-1;
				}

			}

			System.out.println("#"+tc+" "+max);
		}
	}
}
