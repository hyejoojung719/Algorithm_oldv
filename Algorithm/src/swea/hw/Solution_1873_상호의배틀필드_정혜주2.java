package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_정혜주2 {
	public static void main(String[] args) throws Exception{
		// . : 평지(통과)
		// * : 벽돌벽 - 포탄 파괴 O
		// # : 강철벽
		// - : 물(통과x)
		// ^ v < > : 전차가 바라보는 방향

		// U D L R
		// S : 포탄
		
		// 상 하 좌 우
		char[] play = {'U', 'D', 'L', 'R'};
		char[] car = {'^', 'v', '<', '>'};
		int[][] dir = {{-1,0},{1,0},{0, -1},{0, 1}};
		
		// 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
				}
			}


			

	}
}
