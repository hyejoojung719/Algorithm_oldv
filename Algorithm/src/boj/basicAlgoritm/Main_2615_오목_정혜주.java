package boj.basicAlgoritm;

import java.util.Scanner;

public class Main_2615_오목_정혜주 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);

		final int N = 19;	
		int[][] map = new int[N+1][N+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = s.nextInt();
			}
		}

		int[] dr = {-1, 1, 0, 0, 1, -1, -1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};	


		//step 01. 바둑알 탐색
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int cur = map[i][j];	
				if(cur!=0) {
					for(int d=0; d<8; d+=2) {

						int cnt=1; //연속한 바둑알 개수

						//오목의 시작 위치
						int sR=i;
						int sC=j;

						//d=0인경우 - 발견한 바둑알 기준 상하 탐색
						for(int k=d; k<=d+1; k++) {

							//현 탐색 위치
							int r = i;
							int c = j;

							while(true) {
								r += dr[k];
								c += dc[k];
								
								if(r < 1 || r > N || c <1 || c> N || map[r][c]!=cur) break;
								cnt++;	
								
								if(k%2==0) {
									sR = r;
									sC = c;
								}
							}
						}
						if(cnt==5) {
							System.out.println(cur);
							System.out.println(sR+" "+sC);
							System.exit(0);	
						}
					}
				}
			}
		}
		System.out.println(0);

	}

}
