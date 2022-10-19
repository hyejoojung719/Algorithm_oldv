package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9205_맥주마시면서걸어가기 {

	static int N;
	static Node[] nodes;
	static boolean[] visited;
	static int[][] dist;
	static int INF = Integer.MAX_VALUE;

	static class Node{
		int row,col;

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N+2];
			for(int i = 0; i < N+2; ++i){
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(row,col);
			}

			dist = new int[N+2][N+2];
			for(int i=0; i<N+1; i++) {
				for(int j=i+1; j<N+2; j++) {
					dist[i][j] = dist[j][i] = INF;
					int dis = Math.abs(nodes[i].col - nodes[j].col) + Math.abs(nodes[i].row - nodes[j].row);
					if(dis <= 100) dist[i][j] = dist[j][i] = 1;							
				}			
			}

			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);	
					}
				}
			}

			if(dist[0][N+1] > 0 && dist[0][N+1] < INF) System.out.println("happy");				
			else System.out.println("sad");
		}		
	}
}
