package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로 {
	static int N;
	static int[][] map;
	static int ans;
	static boolean[][] visited;
	static int[][] dels = {{1,0},{0,1}};	//하, 우
	
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
		visited[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row,col,0));
		
		int depth=1;
		while(!q.isEmpty()) {
			
			System.out.println("depth : " + depth);
			int size = q.size();
			for(int i=0; i<size; i++) {
				int trow = q.peek().row;
				int tcol = q.peek().col;
				int tcost = q.poll().cost;
				
//				System.out.println("trow : tcol :  tcost = " + trow + " : " + tcol + " : " + tcost);
				for (int dir = 0; dir < 2; dir++) {
					int mrow = trow + dels[dir][0];
					int mcol = tcol + dels[dir][1];
					
					if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;
					
					if(!visited[mrow][mcol]) {
//						System.out.println("map[mrow][mcol] : " + map[mrow][mcol]);
						System.out.println("mrow : mcol : mcost = " + mrow + " : " + mcol + " : " + (map[mrow][mcol]+tcost));
						q.offer(new Point(mrow, mcol, map[mrow][mcol]+tcost ));
						visited[mrow][mcol] = true;
					}
					
					if(mrow==N-1 && mcol==N-1) {
						System.out.println("비용 " + q.peek().cost);
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
					if(str.charAt(j)=='0') map[i][j]=0;
					else map[i][j]=1;
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
