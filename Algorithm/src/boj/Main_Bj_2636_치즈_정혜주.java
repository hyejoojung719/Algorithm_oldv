package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj_2636_치즈_정혜주 {
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우
	static int C, R;
	static int[][] map;
	static boolean[][] visited;
	static int time;
	static List<Integer> cheezeCnt=new ArrayList<>();

	static class Point{
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	// 공기가 있는 점부터 시작(0,0) 
	private static void bfs(int srow, int scol) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(srow,scol));
		visited[srow][scol] = true;

		while(!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.poll().col;

			for (int dir = 0; dir < 4; dir++) {
				int mrow = row + deltas[dir][0];
				int mcol = col + deltas[dir][1];

				if(mrow<0 || mcol<0 || mrow>=R || mcol>=C) continue;

				if(map[mrow][mcol]==0 && !visited[mrow][mcol]) {
					visited[mrow][mcol]=true;
					q.offer(new Point(mrow,mcol));
				}else if(map[mrow][mcol]==1 && !visited[mrow][mcol])  {
					// 만약 치즈가 있는 곳이라면(공기랑 밀접)
					visited[mrow][mcol]=true;
					map[mrow][mcol] = 2;
				}
			}
		}
	}


	// 치즈 녹이기
	private static boolean melt() {
		
		boolean flag=false;
		
		int cnt=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 2) {
					flag = true;
					cnt++;
					map[i][j] = 0;
				}
			}
		}
		
		cheezeCnt.add(cnt);
		
		return flag;
	}


	public static void main(String[] args) throws Exception{
		//  치즈가 모두 녹는데 걸리는 시간, 모두 녹기 한 시간 전에 남아있는 치즈 조각 칸 개수??
		// input => col row
		// 0 : 치즈X. 1 : 치즈O

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		boolean flag = true;;
		while(flag) {
			
			visited = new boolean[R][C];
			bfs(0,0);

				
			flag = melt();
			time++;
		}

		System.out.println(time-1);
		System.out.println(cheezeCnt.get(cheezeCnt.size()-2));
	}
}
