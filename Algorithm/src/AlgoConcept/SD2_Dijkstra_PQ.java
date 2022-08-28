package AlgoConcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */
/**
 * @author taeheekim
 */
public class SD2_Dijkstra_PQ {

	private static class Vertex implements Comparable<Vertex>{
		int no;
		int totalDistance;
		
		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance-o.totalDistance;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + no + ", distance=" + totalDistance + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0; //시작점 인덱스
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim());
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		distance[start] = 0;
		pQueue.offer(new Vertex(start,distance[start]));
		
		Vertex current = null;
        while(!pQueue.isEmpty()){
			
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
        	current = pQueue.poll();
        	if(visited[current.no])continue;
        	
			visited[current.no] = true; // 선택 정점 방문 처리
			if(current.no == end) break; // 선택 정점이 도착정점이면 탈출.
			
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current.no][c] != 0
						&&  distance[c] >current.totalDistance+matrix[current.no][c]){
					distance[c] = current.totalDistance+matrix[current.no][c];
					pQueue.offer(new Vertex(c,distance[c]));
				}
			}
		}
		System.out.println(distance[end]);
	}

}