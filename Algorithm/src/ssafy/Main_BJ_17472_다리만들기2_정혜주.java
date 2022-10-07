package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17472_다리만들기2_정혜주 {
	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	static List<int[]> points = new ArrayList<>();
	static int[][] graph;
	static boolean[] visited2;
	static int[] minEdge;
	static int idx;
	static boolean flag = false;
	static int vcnt;
	
	// 섬 번호 지정하기
	private static void island(int row, int col, int num) {
		visited[row][col] = true;
		map[row][col] = num;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});

		while(!q.isEmpty()) {
			int trow = q.peek()[0];
			int tcol = q.poll()[1];

			for (int dir = 0; dir < 4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];

				if(mrow<0 || mcol <0 || mrow>=N || mcol>=M) continue;

				if(!visited[mrow][mcol] && map[mrow][mcol]!=0) {
					visited[mrow][mcol] = true;
					map[mrow][mcol]=num;
					q.offer(new int[] {mrow, mcol});
				}
			}
		}
	}



	public static void main(String[] args) throws Exception{

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

				if(input==1) points.add(new int[] {i,j});
			}
		}

		visited = new boolean[N][M];

		int size = points.size();
		idx=1;
		for (int i = 0; i < size; i++) {
			int row = points.get(i)[0];
			int col = points.get(i)[1];
			if(!visited[row][col]) island(row, col, idx++);
		}

		graph = new int[idx][idx];
		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < idx; j++) {
				graph[i][j] = INF;
			}
		}

		// 다리 연결하기
		for(int i=0; i<size; i++) {
			int row = points.get(i)[0];
			int col = points.get(i)[1];

			for (int dir = 0; dir < 4; dir++) {
				int mrow = row + deltas[dir][0];
				int mcol = col + deltas[dir][1];
				int cnt=0;

				if(mrow<0 || mcol<0 || mrow>=N || mcol>=M) continue;

				if(map[mrow][mcol]==0) {
					while(true) {

						mrow += deltas[dir][0];
						mcol += deltas[dir][1];
						cnt++;

						if(mrow<0 || mcol<0 || mrow>=N || mcol>=M) break;

						if(map[mrow][mcol]!=0) {
							if(cnt >= 2) {
								int from = map[row][col];
								int to = map[mrow][mcol];

								graph[from][to] = graph[to][from] = Math.min(cnt, graph[from][to]);
							}
							break;
						}
					}
				}
			}
		}


		visited2 = new boolean[idx];
		minEdge = new int[idx];
		Arrays.fill(minEdge, INF);

		int result = getMST();
		
		if(vcnt == idx-1) {
			System.out.println(result);
		}else System.out.println(-1);

	}

	private static int getMST() {
		int result = 0;
		vcnt = 0;

		minEdge[1] = 0;
		int V = idx-1;
		while(vcnt < V) {
			int min = Integer.MAX_VALUE;
			int minV = -1;

			for(int i=1; i<=V; i++) {
				if(!visited2[i] && minEdge[i] < min) {
					min = minEdge[i];
					minV = i;
				}
			}

			System.out.println("minV : "  + minV);
			visited2[minV] = true;
			result += min;
			vcnt++;

			for(int to=1; to<=V; to++) {
				if(!visited2[to] && graph[minV][to] != 0 && minEdge[to]>graph[minV][to]) {
					flag = true;
					minEdge[to] = graph[minV][to];
				}
			}
			
			if(!flag) break;
		}
		return result;
	}
}
