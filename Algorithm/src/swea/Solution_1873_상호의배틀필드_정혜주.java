package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_정혜주 {
	
	
	public static void main(String[] args) throws Exception{
		// . : 평지(통과)
		// * : 벽돌벽 - 포탄 파괴 O
		// # : 강철벽
		// - : 물(통과x)
		// ^ v < > : 전차가 바라보는 방향

		// U D L R
		// S : 포탄

		// 상 하 좌 우
		char[] car = {'^', 'v', '<', '>'};
		int[][] deltas = {{-1,0},{1,0},{0, -1},{0, 1}};

		// 맵 입력 받을 때 시작 좌표값 받기
		// 명령어 앞에서부터 차례대로 한글자씩 
		// 먼저 차 방향이 어디인지 보기 -> 차 방향에 따라 deltas 셋팅
		// 만약 명령어가 play에  있다면 move 메소드로 이동
		// 만약 명령어가 S라면 attack 메소드로 이동

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int cx = 0, cy = 0, dir=0;
			char[][] map = new char[H][W];
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
						// 시작
						cx = i; cy = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			
			if(map[cx][cy]=='^') dir = 0;
			else if(map[cx][cy]=='v') dir = 1;
			else if(map[cx][cy]=='<') dir = 2;
			else dir = 3;

			for(int i=0; i<N; i++) {
				if(str.charAt(i)=='S') {
					// 공격할 때 --> 좌표 변화는 없다
					int tmpx = cx+deltas[dir][0];
					int tmpy = cy+deltas[dir][1];
					while( 0<=tmpx && tmpx<H
							&& 0<=tmpy && tmpy<W) { // 경계 체크

						if(map[tmpx][tmpy]=='#') break; // 강철벽 만나면 나가기
						
						if(map[tmpx][tmpy]=='.' 
								|| map[tmpx][tmpy]=='-' ) {
							// 뚫린 공간 만나면
							tmpx += deltas[dir][0];
							tmpy += deltas[dir][1];
						}
						
						if( 0<=tmpx && tmpx<H
								&& 0<=tmpy && tmpy<W && map[tmpx][tmpy]=='*') {
							map[tmpx][tmpy]='.';
							break;
						}
					}

				}else {
					// 이동할 때
					if(str.charAt(i)=='U') { //상
						map[cx][cy] = '^'; dir = 0;
						if(0<=cx+deltas[dir][0] && map[cx+deltas[dir][0]][cy+deltas[dir][1]] == '.') {
							map[cx][cy] = '.';
							cx += deltas[dir][0];
							cy += deltas[dir][1];
							map[cx][cy] = '^';
						}
						
					}else if(str.charAt(i)=='D') { //하
						map[cx][cy] = 'v'; dir = 1;
						if(cx+deltas[dir][0]<H && map[cx+deltas[dir][0]][cy+deltas[dir][1]] == '.' ) {
							map[cx][cy] = '.';
							cx += deltas[dir][0];
							cy += deltas[dir][1];
							map[cx][cy] = 'v';
						}
						
					}else if(str.charAt(i)=='L') { //좌
						map[cx][cy] = '<'; dir = 2;
						if(0<=cy+deltas[dir][1] && map[cx+deltas[dir][0]][cy+deltas[dir][1]] == '.') {
							map[cx][cy] = '.';
							cx += deltas[dir][0];
							cy += deltas[dir][1];
							map[cx][cy] = '<';
						}
						
					}else { //우
						map[cx][cy] = '>'; dir = 3;
						if(cy+deltas[dir][1]<W && map[cx+deltas[dir][0]][cy+deltas[dir][1]] == '.') {
							map[cx][cy] = '.';
							cx += deltas[dir][0];
							cy += deltas[dir][1];
							map[cx][cy] = '>';
						}
						
					}
				}
			}

			
			for(char[] x : map) {
				for(char y : x) {
					sb.append(y);
				}
				sb.append("\n");
			}
			System.out.print("#"+tc+" "+sb);

		}
	}
}
