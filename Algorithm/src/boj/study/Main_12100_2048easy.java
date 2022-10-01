package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048easy {
	static int N;
	static int[][] map;
	static int[][]  deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // 우 좌 하 상
	static int[] result = new int[5];
	
	private static void duplcomb(int cnt) {
		if(cnt==5) {
			
			for(int i=0; i<5; i++) {
				game(i);
			}
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			result[cnt] = i;
			duplcomb(cnt+1);
		}
	}
	
	private static void game(int dir) {
		
		int row=0, col=0;
		int mrow = row + deltas[dir][0];
		int mcol = col + deltas[dir][1];
		while(true) {
			if(mrow<0 || mcol<0 || mrow>=N || mcol>=0) continue;
			if(map[mrow][mcol]==0) continue;
			
			
		}
		
		
		
	}
	
//	private static void bfs(int row, int col) {
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] {row, col});
//		
//		while(!q.isEmpty()) {
//			int trow = q.peek()[0];
//			int tcol = q.poll()[1];
//			
//			for(int dir=0; dir<4; dir++) {
//				
//			}
//		}
//	}
	
	public static void main(String[] args) throws Exception{
		// 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		N = Integer.parseInt(br.readLine());
//		map = new int[N][N];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
		
		// 같은 숫자끼리 합칠 수 있다. 
		// 가장 큰 숫 자 블록
		// 5번까지만 이동가능
		
		// 더이상 움직일 필요 없는 경우 => 상,하,좌,우 같은 숫자가 없는 경우(0이 있다면 0은 무시하고..)
		// 1이 아니고 같은 숫자가 있는 방향으로 움직이기 => 케이스마다 돌려서 최대 숫자 블록 값 비교하고 가장 최대값 출력
		
//		bfs(0,0);
		duplcomb(0);
		
	}
}
