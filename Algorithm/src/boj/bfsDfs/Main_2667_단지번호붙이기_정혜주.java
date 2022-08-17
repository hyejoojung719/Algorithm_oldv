package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2667_단지번호붙이기_정혜주 {
	
	static int N;
	static int[][] arr;
	static boolean[][] isVisited;
	static int house; 
	// 상 하 좌 우
	static int[] delRow = {-1, 1, 0, 0};
	static int[] delCol = {0, 0, -1, 1};
	
	public static void dfs(int row, int col) {
		isVisited[row][col] = true;
		
		for(int dir=0; dir<4; dir++) {
			int mrow = row + delRow[dir];
			int mcol = col + delCol[dir];
			
			if(0<=mrow && mrow<N && 0<=mcol && mcol<N) {
				if(arr[mrow][mcol]==1 && isVisited[mrow][mcol] == false) {
					dfs(mrow, mcol);
					house++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		isVisited = new boolean[N][N];
		PriorityQueue<Integer> pq  = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				house = 1;
				if(arr[i][j]==1 && isVisited[i][j]==false) {
					dfs(i, j);
					pq.add(house);
				}
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
