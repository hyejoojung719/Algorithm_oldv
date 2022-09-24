package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] del = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	static int ans = Integer.MIN_VALUE;
	
	private static int bfs(int row, int col) {
		int cnt=-1;
		visited[row][col] =  true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				
				int trow = q.peek()[0];
				int tcol = q.poll()[1];
				
				for(int dir=0; dir<4; dir++) {
					int mrow = trow+del[dir][0];
					int mcol = tcol+del[dir][1];
					
					if(mrow<0 || mcol<0|| mrow>=R || mcol>=C) continue;
					if(map[mrow][mcol]=='L' && !visited[mrow][mcol]) {
						q.offer(new int[] {mrow, mcol});
						visited[mrow][mcol] = true;
					}
				}
			}
			cnt++;
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws Exception{
		// 보물섬 -> 한칸에 한시간(육지끼리 이동 가능)
		// 육지L, 바다W
		// 보물은 서로 최단거리, 가장 긴 시간 걸리는 두 곳에 묻혀 이다. 
		// 최단거리 : 같은 곳 두 번X, 멀리 돌아가기 X
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map =  new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[R][C];
					ans = Math.max(ans, bfs(i,j));
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
