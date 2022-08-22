package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_정혜주 {
	static int N, M ;
	static int[][] lab;
	static int[][] copy_lab;
	static boolean[] isSelected;
	static boolean[][] isVisited;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상 우 하 좌
	static List<Point> list = new ArrayList<>();	// 
	static int R=3;
	static int answer = Integer.MIN_VALUE;
	
	static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	
	// 벽 복사
	public static void copyMap() {
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				copy_lab[i][j] = lab[i][j];
			}
		}
	}
	
	// 벽 세우기 -> 좌표를 조합으로 구하기
	public static void combWall(int cnt, int start) {
		if(cnt==R) {
			// 3가지 뽑았을 때 
			
			// 원본 배열에서 배열 복사
			copyMap();
			
			int wall_cnt=0;
			for(int i=0, listSize = list.size(); i<listSize; i++) {
				if(wall_cnt==3) break;
				if(isSelected[i]) {
					copy_lab[list.get(i).row][list.get(i).col]=1;
					wall_cnt++;
				}
			}
			
			// 바이러스 퍼뜨리기
			int safe_cnt = virus();
			// 안전 구역 카운트
			answer = Math.max(answer, safe_cnt);
		}
		
		for(int i=start, list_size = list.size(); i<list_size; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			combWall(cnt+1, i);
			isSelected[i] = false;
		}
		
	}
	
	public static int virus() {
		isVisited = new boolean[N][M];
		Queue<Point> virus_gps = new LinkedList<>();
		 
		
		 for(int i=0; i<N; i++) {
			 for(int j=0; j<M; j++) {
				 if(copy_lab[i][j]==2) {
					 isVisited[i][j] = true;
					 virus_gps.offer(new Point(i,j));
				 }
			 }
		 }
		 
		 
		 // bfs 이용 -> 여기서 왜 무한루프 걸렸지
		 while(!virus_gps.isEmpty()) {
			 Point temp = virus_gps.poll();
			 
			 for(int dir=0; dir<4; dir++) {
				 int mrow = temp.row + deltas[dir][0];
				 int mcol = temp.col + deltas[dir][1];

				 if(0<=mrow && mrow<N && 0<=mcol && mcol<M) {
					 if(!isVisited[mrow][mcol] && copy_lab[mrow][mcol]==0) {
						 isVisited[mrow][mcol] = true;
						 copy_lab[mrow][mcol]=2;
						 virus_gps.offer(new Point(mrow, mcol));
					 }
				 }
			 }
		 }
		 
		 int space = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy_lab[i][j]==0) space++;
				}
			}
			return space;
	}
	
	public static void main(String[] args) throws Exception{
		// 연구소에 벽 세우기
		// N * M
		// 빈칸 0, 벽 1, 바이러스 2
		// 세울 수 있는 벽의 수  3개
		// 바이러스는 상하좌우를 통해 퍼져나간다. 
		
		// 얻을 수 있는 안전 영역의 최대값
		
		// 벽을 하나씩 세워보고... 바이러스 퍼진 개수 비교??
		
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
					list.add(new Point(i,j));	// 리스트에 빈공간 좌표 담기
				}
			}
		}
		
		isSelected = new boolean[N*M];
		copy_lab = new int[N][M];
		combWall(0, 0);
		System.out.println(answer);
	}
}
