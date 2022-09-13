package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int[][] map;
	static int w,h;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1},
							{-1,-1},{1,1},{-1,1},{1,-1}};
	static boolean[][] visited;
	
	private static void bfs(int row, int col) {
		visited[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		
		while(!q.isEmpty()) {
			int tRow = q.peek()[0];
			int tCol = q.poll()[1];
			for(int dir=0; dir<8; dir++) {
				int mRow = tRow + deltas[dir][0];
				int mCol = tCol + deltas[dir][1];
				
				if(mRow<0 || mRow>=h || mCol<0 || mCol>=w) continue;
				
				if(!visited[mRow][mCol] && map[mRow][mCol]==1) {
					visited[mRow][mCol] = true;
					q.offer(new int[] {mRow, mCol});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			visited  = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] &&  map[i][j]==1) {
						bfs(i,j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}
