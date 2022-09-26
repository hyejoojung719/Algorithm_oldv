package boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
	static int N, M, H, W, Sr, Sc, Fr, Fc, cnt;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	private static boolean bfs(int row, int col) {
		visited[row][col] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row,col,0));

		while(!q.isEmpty()) {
			Point p = q.poll();
			int trow = p.x;
			int tcol = p.y;

			for(int dir=0; dir<4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];

				if(mrow<0 || mcol<0 || mrow+H-1>=N ||  mcol+W-1>=M) continue;

				if(!visited[mrow][mcol]) {
					if(checkWall(mrow, mcol)) {
						q.offer(new Point(mrow,mcol,p.cnt+1));
						visited[mrow][mcol] = true;
						if(mrow==Fr&&mcol==Fc) {
							cnt=p.cnt;
							return true;
						};

					}
				}

			}
		}

		return false;
	}

	private static boolean checkWall(int row, int col) {

		for (int i = row; i <= row+H-1; i++) {
			for (int j = col; j <= col+W-1; j++) {
				if(map[i][j]==1) return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// N*M 격자판 위에 크기가 H*W인 직사각형 있음

		// input
		// N M
		// 칸 정보 0은 빈칸, 1은 벽
		// H W Sr Sc (시작 좌표) Fr Fc (도착 좌표)
		// 격자판 좌표는 (r,c) 형태

		// 시작 좌표를 도착 좌표에 이동시키기 위한 최소 이동 횟수(직사각형 의 가장 왼쪽 위 칸)
		// 이동횟수 출력(이동할 수 없으면 -1)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken())-1;
		Sc = Integer.parseInt(st.nextToken())-1;
		Fr = Integer.parseInt(st.nextToken())-1;
		Fc = Integer.parseInt(st.nextToken())-1;

		// 움직일 때 직사각형 범위 모두 고려할 것 => 모서리 포인트 체크..?

		visited = new boolean[N][M];
		if(bfs(Sr,Sc)) System.out.println(cnt+1);
		else System.out.println(-1);

	}
}
