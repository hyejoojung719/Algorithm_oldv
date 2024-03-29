package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14466_소가길을건너간이유6 {
	static int N, K, R;
	static int pairs;
	static Point[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean[][] visited;

	static class Point {
		int row, col;
		List<Point> linked;
		int cow;
		boolean check;
		public Point(int row, int col, List<Point> linked, int cow, boolean check) {
			super();
			this.row = row;
			this.col = col;
			this.linked = linked;
			this.cow = cow;
			this.check = check;
		}
	}

	// 길 안거너고 만날 수 있는 지 확인
	private static void bfs(int srow, int scol) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {srow,scol});
		visited[srow][scol] = true;
		
		while(!q.isEmpty()) {
			int trow = q.peek()[0];
			int tcol = q.poll()[1];
			
			
			for (int dir = 0; dir < 4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;

				if(!visited[mrow][mcol]) {
					if(!map[mrow][mcol].linked.contains(map[trow][tcol])) {
						// 길이 연결되어 있지 않은 경우
						if(map[mrow][mcol].cow==1 && !map[mrow][mcol].check) {
							// 소를 만났을 때
							pairs--;
						}

						visited[mrow][mcol]=true;
						q.offer(new int[] {mrow, mcol});
					}
				}
			}
			
		}

		
	}

	public static void main(String[] args) throws Exception{
		// input
		// N(목초지 크기) K(마리) R(개 길) 
		// R개 줄에 (행, 열, 행, 열) 형태로 주어진다.
		// K개 줄에 소의 위치가 주어진다. 

		// output : 길을 건너지 않으면 만날 수 없는 소는 몇 쌍?

		// 길이 있는 곳 제외하고 만날 수 있는 지 체크

		// 먼저 전체 쌍의 개수 구하기 k*(k-1)/2
		// 소를 만날때마다 pair에서 1 감소

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new Point[N][N];
		pairs = K*(K-1)/2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Point(i,j,new ArrayList<>(),0,false);
			}
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int srow1 = Integer.parseInt(st.nextToken())-1;
			int scol1 = Integer.parseInt(st.nextToken())-1;
			int srow2 = Integer.parseInt(st.nextToken())-1;
			int scol2 = Integer.parseInt(st.nextToken())-1;

			map[srow1][scol1].linked.add(map[srow2][scol2]);
			map[srow2][scol2].linked.add(map[srow1][scol1]);
		}

		Queue<int[]> cow_point = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			map[row][col].cow = 1;
			cow_point.offer(new int[] {row, col});
		}

		for (int i = 0; i < K; i++) {
			visited = new boolean[N][N];
			int row = cow_point.peek()[0];
			int col = cow_point.poll()[1];

			map[row][col].check=true;
			bfs(row, col);
		}
		
		System.out.println(pairs);
	}
}
