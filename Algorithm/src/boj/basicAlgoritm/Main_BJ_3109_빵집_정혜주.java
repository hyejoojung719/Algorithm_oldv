package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3109_빵집_정혜주 {
	static int N, M;
	static char[][] map;
	static int[][] deltas = {{-1,1}, {0,1}, {1,1}}; // 우상, 우, 우하 -> 가장 위로 가는걸 우선으로..
	static boolean[][] isVisited;
	static int cnt;
	static boolean flag;
	
	public static void dfs(int row, int col) {
		isVisited[row][col] = true;
		
		
		for(int dir=0; dir<3; dir++) {
			if(flag) {
				return;
			}
			
			int mrow = row + deltas[dir][0];
			int mcol = col + deltas[dir][1];
			
			if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
				if(map[mrow][mcol]=='.' && !isVisited[mrow][mcol]) {
					isVisited[mrow][mcol] = true;
					if(mcol==M-1) {
						cnt++;
						flag=true;
						return;
					}
					dfs(mrow, mcol);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// 1. 첫열과 끝열을 제외하고, X가 아닌 구간 부터 시작
		// 2. 방향은 우(col+1), 우상(row-1, col+1), 우하(row+1, col+1)
		//		- 끝열 직전까지, 방문한 적이 없고 .일 때 방문 
		// 3. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			flag=false;
			dfs(i,0);
		}
		System.out.println(cnt);
		
	}
}
