package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2468_안전영역_정혜주 {
	
	static boolean[][] isVisited;
	// 상 우 하 좌
	static int N;
	static int[] delRow = {-1,0,1,0};
	static int[] delCol = {0,1,0,-1};
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		int maxHeight = Integer.MIN_VALUE;
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				map[i][j] = h;
				
				maxHeight = Math.max(h, maxHeight);
			}
		}
		
		int answer = Integer.MIN_VALUE;
		// 비는 건물들 최대 높이-1부터 계산한다.
		int rainHeight = maxHeight-1;
		while(rainHeight>=0) {
			int cnt = 0;
			// 비의 높이가 바뀔 때마다 방문여부체크 배열을 선언해야한다. 
			isVisited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 해당 좌표가 비높이보다 높고, 방문한적이 없다면 dfs메소드를 호출한다. 
					if(map[i][j] > rainHeight && isVisited[i][j]==false) {
						dfs(i, j,rainHeight);
						 // 영역 하나 돌면 카운트 +1
						cnt++;
					}
				}
			}
			rainHeight--;
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	} 
	
	// 붙어있는 영역들을 다 탐색할 때까지 돈다. 
	public static int dfs(int row, int col, int rainHeight) {
		isVisited[row][col] = true;	// 방문하자마자 체크
		for(int dir=0; dir<4; dir++) {	// 해당 좌표 기준으로 상하좌우 탐색
			int mrow = row + delRow[dir];
			int mcol = col + delCol[dir];
			
			if(0<=mrow && mrow<N && 0<=mcol && mcol<N) {
				// 경계안에 있다면 
				if(isVisited[mrow][mcol]==false && map[mrow][mcol] > rainHeight) {
					// 방문한적이 없고 비의 높이보다 높다면 
					// 재귀로 dfs 호출하여 반복한다.
					dfs(mrow, mcol, rainHeight);
				}
			}
		}
		
		return 1;
	}
}
