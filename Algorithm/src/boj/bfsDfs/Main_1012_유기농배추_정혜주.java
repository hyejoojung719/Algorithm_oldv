package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_정혜주 {

	static int N,M,K;
	static int[][] field;
	static boolean[][] isVisited;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};	// 상 하 좌 우

	public static void dfs(int row, int col) {
		isVisited[row][col] = true;
		
		for(int dir=0; dir<4; dir++) {
			int mrow = row + deltas[dir][0];
			int mcol = col + deltas[dir][1];
			
			if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
				if(!isVisited[mrow][mcol] && field[mrow][mcol]==1) {
					dfs(mrow,mcol);
				}
			}
		}
	}
	
	public static int cnt() {
		isVisited = new boolean[N][M];
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				if(!isVisited[i][j] && field[i][j]==1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {

		// 필요한 최소 배추 흰지렁이 개수 구하기
		// TC
		// M, N, 배추 K개

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC= Integer.parseInt(br.readLine());

		for(int tc=0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());	// col
			N = Integer.parseInt(st.nextToken());	// row
			K = Integer.parseInt(st.nextToken());	// 배추 개수

			field = new int[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());

				field[row][col] = 1;
			}

			System.out.println(cnt());
		}
		
	}
}

