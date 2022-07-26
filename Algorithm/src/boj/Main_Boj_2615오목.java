package boj;

import java.util.Scanner;

public class Main_Boj_2615오목 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);

		final int N = 19;	//바둑판 크기
		int[][] map = new int[N+1][N+1];	//바둑판

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = s.nextInt();
			}
		}

		//(상,하), (좌,우), (좌하, 우상), (좌상, 우하)
		int[] dr = {-1, 1, 0, 0, 1, -1, -1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};	


		//step 01. 바둑알 탐색
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int cur = map[i][j];	//현재 바둑알
				if(cur!=0) {

					//step 02. 오목 탐색
					//(상,하), (좌우), (좌하, 우상), (좌상, 우하)
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
								//다음 위치로 한 칸 이동
								r += dr[k];
								c += dc[k];

								//경계 벗어나거나 같은 바둑알이 아니라면
								if(r < 1 || r > N || c <1 || c> N || map[r][c]!=cur) break;

								//경계 내에 있고 같은 바둑알의 경우
								cnt++;	//바둑알 개수 cnt

								//상, 좌, 좌하, 좌상의 경우 오목 시작위치 갱신
								if(k%2==0) {
									sR = r;
									sC = c;
								}
							}
						}

						//직선 하나의 탐색을 마침
						//cnt 값이 5라면? 정답 출력 후 종료
						if(cnt==5) {
							System.out.println(cur);
							System.out.println(sR+" "+sC);//오목 시작 좌표
							System.exit(0);	//프로그램 종료
						}
					}
				}
			}
		}
		//무사히 반복문을 끝냈다면? 오목을 발견하지 못했으므로 0출력
		System.out.println(0);

	}

}
