package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동 {
	static int N, L, R;
	static Point[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;

	static class Point{
		int row;
		int col;
		int top;
		int bottom;
		int left;
		int right;
		int popul;
		public Point(int row, int col, int top, int bottom, int left, int right, int popul) {
			super();
			this.row = row;
			this.col = col;
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
			this.popul = popul;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new Point[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = new Point(i,j,-1,-1,-1,-1, Integer.parseInt(st.nextToken()));
			}
		}

		// 방문 체크를 Point의 right, left로 체크
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bfs(i,j);
			}
		}
	}

	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(map[row][col]);

		while(!q.isEmpty()) {
			Point temp = q.poll();

			for (int dir = 0; dir < 4; dir++) { // 상 하 좌 우
				int mrow = temp.row+deltas[dir][0];
				int mcol = temp.col+deltas[dir][0];

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;

				Point next = map[mrow][mcol];
				switch (dir) {
				case 0:	// 상 방문
					if(temp.top!=dir) {
						int dis = Math.abs(temp.popul-next.popul);
						if(L<=dis && dis<=R) {
							temp.top = 0;
							next.bottom = 1;
						}
						q.offer(next);
					}
					break;
				case 1:	// 하 방문
					if(temp.bottom!=dir) {
						int dis = Math.abs(temp.popul-next.popul);
						if(L<=dis && dis<=R) {
							temp.bottom = 1;
							next.top = 0;
						}
						q.offer(next);
					}
					break;
				case 2:	// 좌 방문
					if(temp.left!=dir) {
						int dis = Math.abs(temp.popul-next.popul);
						if(L<=dis && dis<=R) {
							temp.left = 2;
							next.right = 3;
						}
						q.offer(next);
					}
					break;
				case 3:	// 우 방문
					if(temp.right!=dir) {
						int dis = Math.abs(temp.popul-next.popul);
						if(L<=dis && dis<=R) {
							temp.right = 3;
							next.left = 2;
						}
						q.offer(next);
					}
					break;
				}

			}
		}
	}
	
	// 연합구 인구수 나누기
	// (연합 인구수) / (연합 이루는 칸 수)
	private static void populDiv() {
		
		int popul=0;
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Point point = map[i][j];
				if(point.top>=0) {
					
				}
			}
		}
	}
}
