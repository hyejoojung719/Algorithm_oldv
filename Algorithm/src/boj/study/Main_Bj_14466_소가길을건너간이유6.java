package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj_14466_소가길을건너간이유6 {
	static int N, K, R;
	static Point[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	
	static class Point {
		int row, col;
		List<Point> linked = new ArrayList<>();
		int cow;
		boolean check;
		public Point(int row, int col, List<Point> linked, int cow, boolean check) {
			super();
			this.row = row;
			this.col = col;
			this.linked = linked;
			this.cow = cow;
			this.check = check;
		}
	}
	
	// 길 안거너고 만날 수 있는 지 확인
	private static void dfs(int srow, int scol) {
		visited[srow][scol] = true;
		
		for (int dir = 0; dir < 4; dir++) {
			int mrow = srow + deltas[dir][0];
			int mcol = scol + deltas[dir][1];
			
			if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;
			
			if(!visited[mrow][mcol]) {
				if(map[mrow][mcol].linked==null 
						|| !map[mrow][mcol].linked.contains(map[srow][scol])) {
					dfs(mrow,mcol);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		// input
		// N(목초지 크기) K(마리) R(개 길) 
		// R개 줄에 (행, 열, 행, 열) 형태로 주어진다.
		// K개 줄에 소의 위치가 주어진다. 
		
		// output : 길을 건너지 않으면 만날 수 없는 소는 몇 쌍?
		
		// 길이 있는 곳 제외하고 만날 수 있는 지 체크
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new Point[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Point(i,j,null,0,false);
			}
		}
		
		for (int i = 0, idx = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int srow1 = Integer.parseInt(st.nextToken());
			int scol1 = Integer.parseInt(st.nextToken());
			int srow2 = Integer.parseInt(st.nextToken());
			int scol2 = Integer.parseInt(st.nextToken());
			
			map[srow1][scol1].linked.add(map[srow2][scol2]);
			map[srow2][scol2].linked.add(map[srow1][scol1]);
		}
		
		Queue<int[]> cow_point = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col].cow = 1;
			cow_point.offer(new int[] {row, col});
		}
		
		for (int i = 0; i < K; i++) {
			visited = new boolean[N][N];
			int row = cow_point.peek()[0];
			int col = cow_point.poll()[1];
			
			map[row][col].check=true;
			dfs(row, col);
		}
	}
}
