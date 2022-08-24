package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_PuyoPuyo_정혜주 {
	static char[][] board = new char[12][6];
	static boolean[][] isVisited = new boolean[12][6];
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	
	public static void dfs() {
		
	}
	
//	public static void bfs(int row, int col) {
//		Queue<int[]> q = new LinkedList<>();
//		isVisited[row][col] = true;
//		q.offer(new int[] {row,col});
//		
//		int cnt = 0;	// 4개 이상인지 체크하기 
//		while(!q.isEmpty()) {
//			int trow = q.peek()[0];
//			int tcol = q.poll()[1];
//			char check = board[trow][tcol];
//			
//			for(int dir=0; dir<4; dir++) {
//				int mrow = trow + deltas[dir][0];
//				int mcol = tcol + deltas[dir][1];
//				
//				if(0<=mrow && mrow <12 && 0<=mcol && mcol<6) {
//					if(!isVisited[mrow][mcol] && board[mrow][mcol]==check) {
//						cnt++;
//						isVisited[mrow][mcol] = true;
//						q.offer(new int[] {mrow, mcol});
//					}
//				}
//			}
//		}
//	}
	
	public static void main(String[] args) throws Exception{
		// 같은 색 4개 이상 모이면 터짐
		// 중력 영향 O
		// 연쇄가 몇 번?
		//  R G B P Y
		// 12 * 6
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				board[i][j] = str.charAt(j);
			}
		}
	}
}
