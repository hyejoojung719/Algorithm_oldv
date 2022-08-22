package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스_정혜주 {
	// 틀렸지만, 일단 제출해봅니다.. (반례 찾는 중이에요..ㅜㅜ)

	static int N,M,D;
	static int R = 3; // 궁수 수
	static int[][] board;
	static int[][] copy_board;
	static int[][] archer_spot = new int[3][2];
	static int[][] deltas = {{0,-1}, {-1,0}, {0,1}};	// 좌, 상, 우 -> 왼쪽 우선이니까
	static Queue<int[]> willdie_enemy;
	static boolean[][] isVisited;
	static int died_enemy, answer=Integer.MIN_VALUE;


	public static void comb(int cnt, int start) {
		// 5칸 중 3칸을 뽑음

		if(cnt==R) {
			died_enemy = 0 ;
//			System.out.println("궁수위치 ");
//			for(int[] x : archer_spot) {
//				System.out.print(x[1]+" ");
//			}
//			System.out.println();
			copyBoard();
			while(check_enemy()!=0) {
				target(); 
				attack();
//				
//				System.out.println("========");
//				for(int[] x : copy_board) {
//					for(int y : x) {
//						System.out.print(y+" ");
//					}
//					System.out.println();
//				}
			}
//			System.out.println("죽인 적 :" + died_enemy);
			answer = Math.max(answer, died_enemy);
			return;
		}

		for(int i=start; i<M; i++) {
			archer_spot[cnt][0] = N;
			archer_spot[cnt][1] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void copyBoard() {
		copy_board = new int[N+1][M];
		
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M; j++) {
				copy_board[i][j] = board[i][j];
			}
		}
	}
	
	public static int check_enemy() {
		int cnt =0;
		for(int[] x : copy_board) {
			for(int y : x) {
				if(y==1) cnt++;
			}
		}
		return cnt;
	}
	
	public static int attack() {
		while(!willdie_enemy.isEmpty()) {
			// 죽일 적들이 사라질 때 까지...
//			System.out.println("죽일 애들 좌표 : "+ willdie_enemy.peek()[0] + " : " + willdie_enemy.peek()[1]);
			int erow = willdie_enemy.peek()[0];
			int ecol = willdie_enemy.poll()[1];
			
			copy_board[erow][ecol] = 0;
			died_enemy++;
		}
		
		// 궁수의 공격이 끝나면 적이 아래로 한 칸 이동해야함...
		for(int i=N-2; i>=0; i--) { // 궁수들이 위치한 행과 캐슬 직전행은 제외하고 생각
			for(int j=0; j<M; j++) {
				if(copy_board[i][j]==1) {
					copy_board[i][j] = 0;
					copy_board[i+1][j] = 1;
				}else {
					copy_board[i+1][j] = 0;
				}
			}
		}
		
//		System.out.println("현재까지 죽인 적 :" + died_enemy);
		
		return died_enemy;
	}

	public static void target() {	// bfs로 타겟들 설정하기
		// 죽일 적들 좌표를 담음
		willdie_enemy = new LinkedList<>();
		isVisited = new boolean[N+1][M];
		Queue<int[]> q;

		for(int i=0; i<3; i++) {	// 궁수는 3명이니까..
			int arow = archer_spot[i][0];
			int acol = archer_spot[i][1];
			q  = new LinkedList<>();
			q.offer(new int[] {arow, acol});

			wh : while(!q.isEmpty()) {
				int[] temp = q.poll();
				int nrow = temp[0];
				int ncol = temp[1];
				
				for(int dir=0; dir<3; dir++) {
					int mrow = nrow + deltas[dir][0];
					int mcol = ncol + deltas[dir][1];
					
					if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
						int dis = Math.abs(arow-mrow) + Math.abs(acol-mcol);
						if(dis <= D) {
							if(copy_board[mrow][mcol]==1) {
								if(!isVisited[mrow][mcol]) {	// 방문한 적 이 없는 적이라면..
									willdie_enemy.offer(new int[] {mrow, mcol});
									isVisited[mrow][mcol] = true;
								}
								break wh;
							}else if(!isVisited[mrow][mcol]){
								q.offer(new int[] {mrow, mcol});
								isVisited[mrow][mcol] = true;
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		// 1. 궁수는 성이 있는 칸(N+1, ?)에 있을 수 있다 => 총 3명 -> row값은 N으로 고정(인덱스 0부터 시작할 경우)
		// ex) M칸 중 3칸 -> 조합(전체=M, 뽑을개수=3)
		// 2. 3번 돌면서 => bfs로 탐색하면서 먼저 거리 안에 있는 애들 중 가장 가까운애들 찾기 -> willdie배열에 좌표 담기..?

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 행 길이
		M = Integer.parseInt(st.nextToken());	// 열 길이
		D = Integer.parseInt(st.nextToken());	// 거리 제한

		board = new int[N+1][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 자리는 0으로 셋팅
		for(int i=0; i<M; i++) {
			board[N][i] = 0;
		}

		comb(0,0);
		System.out.println(answer);
	}
}
