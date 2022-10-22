package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지_다익스트라 {
	static int N;
	static int[][] map;
	static int money;
	static int[][] dist;
	static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static final int INF = Integer.MAX_VALUE;
	
	static class Link implements Comparable<Link>{
		int row,col,money;

		public Link(int row, int col, int money) {
			super();
			this.row = row;
			this.col = col;
			this.money = money;
		}

		@Override
		public int compareTo(Link o) {
			// TODO Auto-generated method stub
			return this.money-o.money;
		}
		
		
	}
	
	static int dijkstra(int row, int col, int money) {
		PriorityQueue<Link> q = new PriorityQueue<>();
		q.offer(new Link(row,col,money));
		dist[row][col] = money;
		
		while(!q.isEmpty()) {
			Link temp = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int mrow = temp.row + deltas[dir][0];
				int mcol = temp.col + deltas[dir][1];
			
				if(mrow<0 || mcol<0 || mrow>=N || mcol>=N) continue;
				
				if(dist[mrow][mcol] > temp.money + map[mrow][mcol]) {
					dist[mrow][mcol] = temp.money + map[mrow][mcol];
					q.offer(new Link(mrow,mcol,temp.money + map[mrow][mcol]));
				}
			}
		}
		
		return dist[N-1][N-1];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int index=1;
		while(true) {
			 N = Integer.parseInt(br.readLine()); 
			 
			 if(N<=0) break;
			 
			 dist = new int[N][N];
			 map = new int[N][N];
			 for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}
			money=map[0][0];
			int answer = dijkstra(0,0,money);
			sb.append("Problem "+ (index++) + ": "+answer+"\n");
		}
		System.out.println(sb);
		
	}
}
