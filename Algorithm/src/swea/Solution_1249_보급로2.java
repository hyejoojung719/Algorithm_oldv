package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로2 {
	static int N;
	static int[][] map;
	static int ans;
	static int[][] dels = {{1,0},{0,1}};	//하, 우
//	static int[][] check;

	static class Point{
		int row, col, cost;

		public Point(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row,col,0));
//		check[row][col] = 0;

		int depth=1;
		while(!q.isEmpty()) {

			int size = q.size();
			for(int i=0; i<size; i++) {
				int trow = q.peek().row;
				int tcol = q.peek().col;
				int tcost = q.poll().cost;

//				if()
				
				for (int dir = 0; dir < 2; dir++) {
					int mrow = trow + dels[dir][0];
					int mcol = tcol + dels[dir][1];

					if( mrow>=N || mcol>=N) continue;


					q.offer(new Point(mrow, mcol, map[mrow][mcol]+tcost ));

					if(mrow==N-1 && mcol==N-1) {
						ans = Math.min(ans,  q.peek().cost);
					}
				}
			}


			depth++;
		}
	}


	public static void main(String[] args) throws Exception{
		// 복구 시간 == 깊이
		// 복구 시간이 가장 짧은 경로에 대한 총 복구 시간 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());


		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-48;
				}
			}

			
			ans = Integer.MAX_VALUE;
//			check = new int[N][N];
			bfs(0,0);

			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
