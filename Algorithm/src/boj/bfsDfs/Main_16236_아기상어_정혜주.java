package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_정혜주 {
	static int N;
	static int row, col;
	static int[][] deltas = {{-1,0}, {0,-1}, {0,1}, {1,0}};	// 상 좌 우 하
	static int shark_size = 2;
	static int[][] sea;
	static boolean[][] isVisited;
	static int fish_cnt;
	static int time;
	static Queue<int[]> eat; 
	static Queue<int[]> can_move;
	static int whole_fish;


	public static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		isVisited[row][col] = true;

		while(!q.isEmpty()) {
			int[] temp = q.poll();
			eat  = new LinkedList<>();
			can_move  = new LinkedList<>();

			for(int dir=0; dir<4; dir++) {
				int mrow  = temp[0] + deltas[dir][0];
				int mcol  = temp[1] + deltas[dir][1];

				if(0<=mrow && mrow<N && 0<=mcol && mcol<N) {
					// 경계 내에 있다면 
					if(sea[mrow][mcol]!=0 && !isVisited[mrow][mcol] 
							&& shark_size > sea[mrow][mcol]) {
						// 물고기 크기가 나보다 작다면 =먹을 수 있는 물고기라면 
						eat.offer(new int[] {mrow, mcol});
					}else if((sea[mrow][mcol]!=0 && !isVisited[mrow][mcol] 
							&& shark_size == sea[mrow][mcol]) || sea[mrow][mcol]==0) {
						can_move.offer(new int[] {mrow, mcol});
					}
				}

				if(eat.size()!=0) {
					int trow = eat.peek()[0];
					int tcol = eat.poll()[1];

					sea[trow][tcol] = 0;
					isVisited[trow][tcol] = true;
					q.offer(new int[] {trow, tcol});
					fish_cnt++;

					if(fish_cnt == shark_size) {
						shark_size++;	// 먹은 물고기 개수가 현재 크기와 같다면 크기 +1
						fish_cnt=0;
					}
				}else if(eat.size()==0) {
					// 먹을 물고기가 없었을 때 
					int trow = can_move.peek()[0];
					int tcol = can_move.poll()[1];

					isVisited[trow][tcol] = true;
					q.offer(new int[] {trow, tcol});
				}

				time++;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());

				if(sea[i][j]==9) row=i; col=j; 
			}
		}

		isVisited = new boolean[N][N];
		bfs(row, col);
	}
}
