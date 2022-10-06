package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다가자_정혜주 {
	static int N, M;
	static char[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][][] visited;

	static class Node{
		int row, col, key, cnt;

		public Node(int row, int col, int key, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.key = key;
			this.cnt = cnt;
		}

	}

	private static void bfs(int row, int col) {
		visited[row][col][0] = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(row, col, 0, 0));

		while(!q.isEmpty()) {
			int trow = q.peek().row;
			int tcol = q.peek().col;
			int key = q.peek().key;
			int cnt = q.poll().cnt;
			

			for (int dir = 0; dir < 4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=M
						|| map[mrow][mcol]=='#') continue;

				if(map[mrow][mcol]=='1') {
					System.out.println(cnt+1);
					System.exit(0);
				}
				
				if(!visited[mrow][mcol][key]) {
					
					if(map[mrow][mcol]=='.') {
						visited[mrow][mcol][key] = true;
						q.offer(new Node(mrow, mcol, key, cnt+1));
					}

					if(map[mrow][mcol]-97>=0 && map[mrow][mcol]-97<=5) {
						// 키를 찾으면
						int num = map[mrow][mcol]-97;
						visited[mrow][mcol][key | (1 << num)] = true;
						q.offer(new Node(mrow, mcol, (key | (1 << num)), cnt+1));
					}

					if(map[mrow][mcol]-65>=0 && map[mrow][mcol]-65<=5) {
						// 문을 만나면
						if((key & (1<<(map[mrow][mcol]-65))) != 0) {
							visited[mrow][mcol][key] = true;
							q.offer(new Node(mrow, mcol, key, cnt+1));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		// 민식이가 미로를 탈출하는데 드는 이동횟수 최솟값?
		// 이동할 수 없으면 -1

		// # : 벽
		// . : 공간
		// a~f - A~F : 열쇠 - 문
		// 1 : 출구
		// 0 : 현재 위치

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		int srow=0, scol=0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char input = str.charAt(j);
				map[i][j] = input;
				if(input=='0') {
					srow = i;
					scol = j;
					map[i][j]='.';
				}
			}
		}


		visited = new boolean[N][M][65];
		bfs(srow, scol);
		System.out.println(-1);
	}
}
