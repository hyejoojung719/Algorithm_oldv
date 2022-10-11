package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다 가자와 비슷한 문제
public class Main_BJ_2206_벽부수고이동하기 {
	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

	static class Point{
		int row;
		int col;
		int chance;
		int cnt;
		public Point(int row, int col, int chance, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.chance = chance;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-48;
			}
		}

		visited = new boolean[N][M][2];
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		int ans = -1;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0,1,1));
		visited[0][0][0] = true;
		visited[0][0][1] = true;

		while(!q.isEmpty()) {
			Point temp = q.poll();

			if(temp.row==N-1 && temp.col==M-1) {
				ans = temp.cnt;
				break;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int mrow = temp.row+deltas[dir][0];
				int mcol = temp.col+deltas[dir][1];

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=M) continue;


				if(map[mrow][mcol]==1) {
					if(temp.chance>0) {
						visited[mrow][mcol][1]=true;
						q.offer(new Point(mrow,mcol,temp.chance-1,temp.cnt+1));
					}
				}else {
					if(temp.chance>0 && !visited[mrow][mcol][0]) {
						visited[mrow][mcol][0]=true;
						q.offer(new Point(mrow,mcol,temp.chance,temp.cnt+1));
					}else if(temp.chance==0 && !visited[mrow][mcol][1]) {
						visited[mrow][mcol][1]=true;
						q.offer(new Point(mrow,mcol,temp.chance,temp.cnt+1));
					}
				}
			}
		}

		return ans;
	}
}
