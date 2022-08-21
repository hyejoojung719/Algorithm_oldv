package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색_정혜주 {
	
	static int N, M; 
	static int[][] map;
	static int cnt=1;
	static int[][] deltas = {{1,0},{0,1}, {-1,0}, {0,-1}};	// 하우상좌
	static boolean[][] isVisited;
	
	public static void bfs(int row, int col) {
		isVisited[row][col] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int nrow = temp[0];
			int ncol = temp[1];
			
			for(int dir=0; dir<4; dir++) {
				int mrow = temp[0] + deltas[dir][0];
				int mcol = temp[1] + deltas[dir][1];
				
				if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
					// 경계내에 있다면
					if(!isVisited[mrow][mcol] && map[mrow][mcol]==1) {
						q.offer(new int[] {mrow, mcol});
						isVisited[mrow][mcol] = true;
						// 칸수를 카운트하는 데서 많이 고민함
						map[mrow][mcol] = map[nrow][ncol]+1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// 1 : 이동 가능 
		// 0 : 이동 불가능
		
		// (1,1)에서 출발하여 (N,M)까지 이동 할 떄 지나야 하는 최소 칸 수 출력
		
		// N, M 입력
		// 미로가 붙어서 입력 받음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int col=0, row=0;
		isVisited = new boolean[N][M];
		bfs(row, col);
		System.out.println(map[N-1][M-1]);
	}
}
