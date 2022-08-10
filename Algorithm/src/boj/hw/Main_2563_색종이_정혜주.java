package boj.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 가로 100, 세로 100
		// 가로 10, 세로 10 정사각형 

		// 왼쪽 하단 좌표 

		// 색종이 가장 우츨 상단 기준으로 2차원 배열 만들기(boolean타입)

		// 겹치는 부분 찾기
		// 색종이 범위 = true
		// true인 곳 방문하면 cnt++;

		// 겹치는 부분 고려 안한 전체 색종이 넓이 = 10*10*색종이개수에서 cnt한 값 뺀 것...

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] paper = new int[n][2];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			paper[i][0] = x;
			paper[i][1] = y;

		}

		boolean[][] isDrawing = new boolean[100][100];
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int x=paper[i][0]; x<paper[i][0]+10; x++) {
				for(int y=paper[i][1]; y<paper[i][1]+10; y++) {
					if(!isDrawing[x][y]) {
						isDrawing[x][y] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
