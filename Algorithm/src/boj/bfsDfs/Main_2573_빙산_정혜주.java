package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산_정혜주 {
	static int N, M;
	static int[][] sea;
	static int year;	// 시간
	static int mass=1;	// 덩어리
	static int[] delRow = {-1,1,0,0};
	static int[] delCol = {0,0,-1,1};
	static boolean[][] isVisited;


	// 빙산 녹이는 메소드 --> 빙하는 동시에 녹는다!!!!!!!!!!!
	public static void melting() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int row=0; row<N; row++) {
			for (int col = 0; col < M; col++) {
				if(sea[row][col] != 0) {
					int zeroCnt=0;

					for(int dir=0; dir<4; dir++) {
						int mrow = row + delRow[dir];
						int mcol = col + delCol[dir];

						if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
							// 경계 안에 있을 때 
							if(sea[mrow][mcol]==0) {
								zeroCnt++; 	// 인접한 바다 개수만큼 +1
							}
						}
					}
					q.add(new int[] {row, col, zeroCnt});
				}
			}
		}


		while(!q.isEmpty()) {
			if(sea[q.peek()[0]][q.peek()[1]] < q.peek()[2]) {
				sea[q.peek()[0]][q.peek()[1]] = 0 ;
			}else {
				sea[q.peek()[0]][q.peek()[1]] -= q.peek()[2];
			}
			
			q.poll();
		}
		
	}

	// 덩어리 개수 찾는 함수
	public static int massCnt() {
		// 빙산 개수 반환
		isVisited = new boolean[N][M];

		int cnt=0;
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				if(isVisited[i][j] == false && sea[i][j]!=0) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

	// 덩어리 개수 찾기 위해 dfs 호출
	public static void dfs(int row, int col) {
		isVisited[row][col] = true;

		for(int dir=0; dir<4; dir++) {
			int mrow = row + delRow[dir];
			int mcol = col + delCol[dir];

			if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
				// 경계 안에 있을 때 
				if(isVisited[mrow][mcol] == false && sea[mrow][mcol]!=0) {
					dfs(mrow, mcol);
				}
			}
		}
	}


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sea = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		while(true) {
			mass = massCnt();
			if(mass >= 2) break;
			else if(mass == 0) {
				year = 0;
				break;
			}
			melting();
			year++;
		}

		System.out.println(year);

	}
}
