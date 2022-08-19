package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스_정혜주 {
	
	static int N,M,D;
	static int R = 3; // 궁수 수
	static int[][] board;
	static int enemy; // 전체 적의 수
	static Queue<int[]> enemy_q = new LinkedList<>();
	static boolean[] archer_spot;
	
	
	public static void comb(int cnt, int start) {
		// 5칸 중 3칸을 뽑음
		
		if(cnt==R) {
			attack(archer_spot);
		}
		
		for(int i=start; i<M; i++) {
			archer_spot[i] = true;
			comb(cnt+1, i+1);
			archer_spot[i] = false;
		}
	}
	
	public static void attack(boolean[] archer_spot) {
		int size = enemy_q.size();	
		enemy = size;	// 현재 적의 수
		
		// 궁수 위치 
		for(int i=0, len=archer_spot.length; i<len; i++) {
			if(archer_spot[i]) {
				
			}
		}
		
		for(int i=0; i<size; i++) {
			int e_row = enemy_q.peek()[0];
			int e_col = enemy_q.peek()[1];
			
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		// 1. 궁수는 성이 있는 칸(N+1, ?)에 있을 수 있다 => 총 3명 -> row값은 N으로 고정(인덱스 0부터 시작할 경우)
				// ex) M칸 중 3칸 -> 조합(전체=M, 뽑을개수=3)
		// 3. 적의 좌표를 큐에 담고 거리를 비교한다. -> 시간복잡도를 생각하자!!
				// 먼저 큐 사이즈를 변수로 받고, 그 사이즈만큼 for문을 돌린다. 
				// - 적의 전체 수 enemy = 큐 사이즈
				// - 거리 <= d 이면, 큐에서 poll 해주고 다시 넣지 않음, enemy--;
				// - 거리>d 이면, 큐에서 poll 한걸 다시 offer(여기서 row+1하고 넣기 -> 만약 row+1한 값이 N보다 크면 offer금지)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 행 길이
		M = Integer.parseInt(st.nextToken());	// 열 길이
		D = Integer.parseInt(st.nextToken());	// 거리 제한
		
		board = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j]==1) {
					enemy_q.offer(new int[] {i, j});
				}
			}
		}
		
		
		archer_spot = new boolean[M];
		comb(0,0);
	}
}
