package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	static char[][] map;
	static int N;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	private static void bfs(int row, int col, int num) {
		visited[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int tRow = q.peek()[0];
			int tCol = q.poll()[1];
			
			for (int dir = 0; dir < 4; dir++) {
				int mRow = tRow + deltas[dir][0];
				int mCol = tCol + deltas[dir][1];
				
				if(mRow<0 || mRow>=N || mCol<0 || mCol>=N) continue;
				
				if(num==0) {
					// R==G, B
					if(!visited[mRow][mCol]) {
						if(map[tRow][tCol]=='R' || map[tRow][tCol]=='G') {
							if(map[mRow][mCol]=='R' || map[mRow][mCol]=='G') {
								visited[mRow][mCol] = true;
								q.offer(new int[] {mRow, mCol});
							}
						}else if(map[mRow][mCol]==map[tRow][tCol]) {
							visited[mRow][mCol] = true;
							q.offer(new int[] {mRow, mCol});
						}
					}
				}else if(num==1) {
					// R, G, B
					if(!visited[mRow][mCol] && map[mRow][mCol]==map[tRow][tCol]) {
						visited[mRow][mCol] = true;
						q.offer(new int[] {mRow, mCol});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 적록색약 => R==G, B
		// 적록색약X => R, G, B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans1=0, ans2=0;
		
		// 적록색 약
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i,j,0);
					ans1++;
				}
			}
		}
		
		// 적록색 약X
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i,j,1);
					ans2++;
				}
			}
		}
		
		System.out.println(ans2+" "+ans1);
	}
}
