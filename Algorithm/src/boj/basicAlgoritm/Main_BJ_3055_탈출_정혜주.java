package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3055_탈출_정혜주 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상, 우, 하, 좌
	static boolean flag;
	
	public static int bfs(int row, int col) {
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		wh : while(!q.isEmpty()) {
			
			// 물 찰 때
			waterAfter();
			
			answer++;
			int size = q.size();
			for(int i=0; i<size; i++) {

				int trow = q.peek()[0];
				int tcol = q.poll()[1];
				
				for(int dir=0; dir<4; dir++) {
					int mrow = trow + deltas[dir][0];
					int mcol = tcol + deltas[dir][1];
					
					if(0<=mrow && mrow<R && 0<=mcol && mcol<C) {
						
						if(map[mrow][mcol]=='D') {
							flag = true;
							break wh;
						}
						
						if(!visited[mrow][mcol] && map[mrow][mcol]=='.') {
							visited[mrow][mcol] = true;
							q.offer(new int[] {mrow, mcol});
						}
					}
				}
			}
			
		}
		
		return answer;
	}
	
	public static void waterAfter() {
		Queue<int[]> waterQ = new LinkedList<>();
		
		// 물덩이 있는 곳 담기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				if(map[i][j]=='*') {
					waterQ.offer(new int[] {i,j});
				}
			}
		}
		
		// 물 차기
		while(!waterQ.isEmpty()) {
			int trow = waterQ.peek()[0];
			int tcol = waterQ.poll()[1];
			
			for(int dir=0; dir<4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];
				
				if(0<=mrow && mrow<R && 0<=mcol && mcol<C) {
					if(map[mrow][mcol]=='.') map[mrow][mcol]='*';
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// input : R C
		// input : map
		// 물  *, 고슴 S, 비버굴 D, 돌 X, 빈칸 .
		// 매분 마다 물은 인접한 칸까지 이동
		// 고슴도치도 매분마다 움직임 -> 물이 찰 예정인 칸은 이동 X(S, X 통과 못함)
		// 비버굴로 이동할 수 있는 가장 빠른 시간 -> bfs
		// 이동 못하면 KAKTUS 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		int row=0, col=0;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j]=='S') {
					row=i; col=j; 
				}
			}
		}
		
		visited = new boolean[R][C];
		
		int result = bfs(row, col);
		if(flag)System.out.println(result);
		else System.out.println("KAKTUS");
	}
}
