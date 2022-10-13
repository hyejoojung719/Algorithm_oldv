package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17085_십자가2개놓기2 {
	static int N, M;
	static char[][] arr;
	static boolean[] selected;
	static int[] selectedIdx = new int[2];
	static List<int[]> empty = new ArrayList<>();
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static int ans = Integer.MIN_VALUE;
	static  Point point1=null, point2=null;

	// bfs 돌면서 상후좌우 탐색=> 경계선 or . or 다른 십자가를 만나면 끝
	// 상하좌우 한번 탐색 성공 시 count+1
	// 두 개의 십자가를 겹치지 않게 놔야하므로 point 2개에서 시작

	static class Point{
		int row, col, area;

		public Point(int row, int col, int area) {
			super();
			this.row = row;
			this.col = col;
			this.area = area;
		}
	}

	// 누굴 먼저 돌리냐에 따라 순서 영향도 있음
	private static void perm(int cnt) {
		if(cnt==2) {
			int row1 = empty.get(selectedIdx[0])[0];
			int col1 = empty.get(selectedIdx[0])[1];
			int row2 = empty.get(selectedIdx[1])[0];
			int col2 = empty.get(selectedIdx[1])[1];

			visited = new boolean[N][M];
			bfs(row1, col1, row2, col2);

			return;
		}

		for(int i=0, size=empty.size(); i<size; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			selectedIdx[cnt] = i;
			perm(cnt+1);
			selected[i] = false;
		}
	}

	private static void bfs(int row1, int col1, int row2, int col2) {
		Queue<Point> q1 = new LinkedList<>();
		Queue<Point> q2 = new LinkedList<>();
		q1.offer(new Point(row1,col1,1));
		q2.offer(new Point(row2,col2,1));
		visited[row1][col1]=true;
		visited[row2][col2]=true;

		int area1=0, area2=0;
		while(!q1.isEmpty() || !q2.isEmpty()) {
			
			int cnt1=0, cnt2=0;

			if(!q1.isEmpty()) {
                point1 = q1.poll();
                
				for(int dir=0; dir<4; dir++) {
					// Point1
					int mrow1 = point1.row + deltas[dir][0]*point1.area;
					int mcol1 = point1.col + deltas[dir][1]*point1.area;

					if(mrow1<0 || mcol1<0 || mrow1>=N || mcol1>=M ||
							arr[mrow1][mcol1]=='.') break;

					if(!visited[mrow1][mcol1]) {
						visited[mrow1][mcol1] = true;
						cnt1++;
					}
				}
				
				if(cnt1==4) {
					area1 = point1.area;
					q1.offer(new Point(point1.row, point1.col, point1.area+1));
				}
			}
			

			if(!q2.isEmpty()) {
                point2 = q2.poll();
                
				for(int dir=0; dir<4; dir++) {
					// Point2
					int mrow2 = point2.row + deltas[dir][0]*point2.area;
					int mcol2 = point2.col + deltas[dir][1]*point2.area;

					if(mrow2<0 || mcol2<0 || mrow2>=N || mcol2>=M ||
							arr[mrow2][mcol2]=='.') break;

					if(!visited[mrow2][mcol2]) {
						visited[mrow2][mcol2] = true;
						cnt2++;
					}
				}
				
				if(cnt2==4) {
					area2 = point2.area;
					q2.offer(new Point(point2.row, point2.col, point2.area+1));
				}
			}

		}

		int area=(area1*4+1)*(area2*4+1);

		ans = Math.max(ans, area);
	}


	public static void main(String[] args) throws Exception{
		// op : 십자가 넓이곱의 최대값 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				arr[i][j] = ch;
				if(ch=='#') {
					empty.add(new int[] {i, j});
				}
			}
		}


		selected = new boolean[empty.size()];
		perm(0);
		System.out.println(ans);
	}
}
