package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_적록색약_dfs {
	static char[][] map;
	static int N;
	static boolean[][] visited1, visited2;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

	// 적록색약X
	private static void dfs1(int row, int col) {
		visited1[row][col] = true;

		for (int dir = 0; dir < 4; dir++) {
			int mRow = row + deltas[dir][0];
			int mCol = col + deltas[dir][1];

			if(mRow<0 || mRow>=N || mCol<0 || mCol>=N) continue;

			if (!visited1[mRow][mCol] && (map[mRow][mCol] == map[row][col])) {
				dfs1(mRow, mCol);
			}
		}
	}

	// 적록색약O
	private static void dfs2(int row, int col) {
		visited2[row][col] = true;

		for (int dir = 0; dir < 4; dir++) {
			int mRow = row + deltas[dir][0];
			int mCol = col + deltas[dir][1];

			if(mRow<0 || mRow>=N || mCol<0 || mCol>=N) continue;

			if (!visited2[mRow][mCol]) { 
				if(map[row][col]=='B') { 
					if(map[mRow][mCol]=='B') dfs2(mRow,mCol);
				
				}
				else {
					if(map[mRow][mCol]=='G' || map[mRow][mCol]=='R')dfs2(mRow,mCol);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 적록색약 => R==G, B
		// 적록색약X => R, G, B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int ans1=0, ans2=0;
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 적록색약 X
				if(!visited1[i][j]) {
					dfs1(i,j);
					ans1++;
				}

				// 적록색약 O
				if(!visited2[i][j]) {
					dfs2(i,j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}
