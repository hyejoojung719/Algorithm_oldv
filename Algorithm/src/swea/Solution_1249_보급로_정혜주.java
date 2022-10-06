package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_1249_보급로_정혜주 {
	static int N;
	static int[][] map;
	static int ans;
	static boolean[][] visited;
	static int[][] dels = {{1,0},{-1,0},{0,1},{0,-1}};	

	static class Point implements Comparable<Point>{
		int row, col, cost;

		public Point(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost-o.cost;
		}

	}

	private static void bfs(int row, int col) {
		visited[row][col] = true;
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(row,col,0));

		while(!q.isEmpty()) {

			int trow = q.peek().row;
			int tcol = q.peek().col;
			int tcost = q.poll().cost;

			if(trow==N-1 && tcol==N-1) {
				ans = Math.min(ans,  tcost);
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int mrow = trow + dels[dir][0];
				int mcol = tcol + dels[dir][1];

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;

				if(!visited[mrow][mcol]) {
					q.offer(new Point(mrow, mcol, map[mrow][mcol]+tcost ));
					visited[mrow][mcol] = true;
				}


			}

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
					map[i][j]=str.charAt(j)-'0';
				}
			}

			ans = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			bfs(0,0);

			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
