package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_정혜주2 {
	static int N, M; // N*M
	static int[][] lab; // 실험실 담을 배열
	static int[][] copy_lab; // 실험실 복사 배열
	static int zero_cnt; // 안전 구역 
	static List<int[]> virus = new ArrayList<>(); // 바이러스
	static List<int[]> safezone = new ArrayList<>(); // 안전구역
	static boolean[] select;	// 조합 선택 값 담을 배열
	static boolean[][] isVisited;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};	// 상 하 좌 우
	static int ans = Integer.MIN_VALUE;
	
	
	public static void wall(int cnt, int start) {
		
		if(cnt==3) {
			
			copy_lab = new int[N][M];
			for(int i=0; i<N; i++) {
				for (int j = 0; j < M; j++) {
					copy_lab[i][j] = lab[i][j];
				}
			}
			
			int wall_cnt=0;
			for(int i=0; i<zero_cnt; i++) {
				if(wall_cnt==3) break;
				if(select[i]) {
					copy_lab[safezone.get(i)[0]][safezone.get(i)[1]] = 1;
					wall_cnt++;
				}
			}
			
			ans = Math.max(ans, virusSpread());
			return;
		}
		
		for(int i=start; i<zero_cnt; i++) {
			select[i] = true;
			wall(cnt+1, i+1);
			select[i] = false;
		}
	}
	
	public static int virusSpread() {
		Queue<int[]> q = new LinkedList<>();
		isVisited = new boolean[N][M];
		for(int i=0, size = virus.size(); i<size; i++) {
			int row = virus.get(i)[0];
			int col = virus.get(i)[1];
			isVisited[row][col] = true;
			q.offer(new int[] {row,col});
		}
		
		while(!q.isEmpty()) {
			int trow = q.peek()[0];
			int tcol = q.poll()[1];
			
			for(int  dir=0; dir<4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];
				
				if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
					if(copy_lab[mrow][mcol]==0 && !isVisited[mrow][mcol]) {
						copy_lab[mrow][mcol] = 2;
						isVisited[mrow][mcol] = true;
						q.offer(new int[] {mrow, mcol});
					}
				}
			}
		}
		
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy_lab[i][j]==0) safe++;
			}
		}
		
		return safe;
	}
	
	public static void main(String[] args) throws Exception {
		// 1. 벽을 3개 세운다. 
		//		- 0인 자리에 1셋팅 -> 조합 nC3 (n=0인 좌표 카운트 한 값)
		// 2. 바이러스를 퍼뜨린다.
		//		- virus 좌표 파악 -> bfs를 돌면서 인접한 곳에 0인곳 2로 바꿈
		// 3. 최종적으로 배열에서 0인 곳 카운트 
		// 케이스마다 2번, 3번을 반복한다. -> 4. 안전 구역 최대값으로 갱신
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());

				if(lab[i][j]==0) {
					zero_cnt++;
					safezone.add(new int[] {1,j});
				}else if(lab[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		
		select = new boolean[zero_cnt];
		wall(0,0);
		System.out.println(ans);
	}
}
