package swea.hw;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// 상 하 좌 우
		int[] dx = {-1, 1, 0, 0 };
		int[] dy = {0, 0, -1, 1};

		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int sx=0, sy=0;
			int dir = 0;

			char[][] map = new char[H][W];
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);

					// 시작 좌표 인덱스
					if(str.charAt(j)=='^') {
						sx = i; sy = j; dir = 0;
					}else if(str.charAt(j)=='>') {
						sx = i; sy = j; dir = 3;
					}else if(str.charAt(j)=='v') {
						sx = i; sy = j; dir = 1;
					}else if(str.charAt(j)=='<'){
						sx = i; sy = j; dir = 2;
					}
				}
			}


			int N = Integer.parseInt(br.readLine());
			char[] com = new char[N];
			String str = br.readLine();
			com = str.toCharArray();

			System.out.println("sx : " + sx + ", sy : " + sy);

			for(int i=0; i<N; i++) {
				if(com[i]=='S') {
					// 바라보는 방향으로 포 던짐(#통과x)
					int tempx = sx;
					int tempy = sy;
					
					// 경계 만나면 out
					// # 만나면 out
					//	* 만나면 .
					
					while(true) {
						
//						if(0 < x && x <= N && 0 < y && y <= N)
						
						if(!((tempx+dx[dir])<0 || (tempy+dy[dir])<0 || (tempx+dx[dir])>=N || (tempy+dy[dir])>=N)){
							if(map[tempx+dx[dir]][tempy+dy[dir]]=='#') {
								break;
							}
						}
						
						if(map[tempx+dx[dir]][tempy+dy[dir]]=='*') {
							map[tempx+dx[dir]][tempy+dy[dir]] = '.';
							break;
						}
						
						if(dir==1) {
							tempx++;
						}else if(dir==0){
							tempx--;
						}
						else if(dir==3){
							tempy++;
						}
						else if(dir==2){
							tempy--;
						}
						
					}
					

//					for(char[] x : map) {
//						for(char y : x) {
//							System.out.print(y);
//						}
//						System.out.println();
//					}
//					System.out.println();

				}else if(com[i]=='U') {
					// ^로 변경하고 위로(.만통과)
					map[sx][sy] = '^'; dir = 0;
					int tempx = sx;
					int tempy = sy;
					if((tempx+dx[dir])>=0 && (tempy+dy[dir])>=0 && (tempx+dx[dir])<N && (tempy+dy[dir])<N
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='-' && map[tempx+dx[dir]][tempy+dy[dir]]!='#'
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='*') {
						map[sx][sy] = '.';
						sx = tempx+dx[dir];
						sy = tempy+dy[dir];
						map[sx][sy] = '^';
					}
					for(char[] x : map) {
						for(char y : x) {
							System.out.print(y);
						}
						System.out.println();
					}
					System.out.println();
				}else if(com[i]=='D') {
					// v로 변경하고 아래로(.만통과)
					map[sx][sy] = 'v'; dir = 1;
					int tempx = sx;
					int tempy = sy;
					if((tempx+dx[dir])>=0 && (tempy+dy[dir])>=0 && (tempx+dx[dir])<N && (tempy+dy[dir])<N
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='-' && map[tempx+dx[dir]][tempy+dy[dir]]!='#'
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='*') {
						map[sx][sy] = '.';
						sx = tempx+dx[dir];
						sy = tempy+dy[dir];
						map[sx][sy] = 'v';
					}
					for(char[] x : map) {
						for(char y : x) {
							System.out.print(y);
						}
						System.out.println();
					}
					System.out.println();
				}else if(com[i]=='R') {
					// >로 변경하고 오른쪽(.만통과)
					map[sx][sy] = '>'; dir = 3;
					int tempx = sx;
					int tempy = sy;
					if((tempx+dx[dir])>=0 && (tempy+dy[dir])>=0 && (tempx+dx[dir])<N && (tempy+dy[dir])<N
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='-' && map[tempx+dx[dir]][tempy+dy[dir]]!='#'
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='*') {
						map[sx][sy] = '.';
						sx = tempx+dx[dir];
						sy = tempy+dy[dir];
						map[sx][sy] = '>';
					}
					for(char[] x : map) {
						for(char y : x) {
							System.out.print(y);
						}
						System.out.println();
					}
					System.out.println();
				}else {
					// <로 변경하고 왼쪽(.만통과)
					map[sx][sy] = '<'; dir = 2;
					int tempx = sx;
					int tempy = sy;
					if((tempx+dx[dir])>=0 && (tempy+dy[dir])>=0 && (tempx+dx[dir])<N && (tempy+dy[dir])<N
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='-' && map[tempx+dx[dir]][tempy+dy[dir]]!='#'
							&& map[tempx+dx[dir]][tempy+dy[dir]]!='*') {
						map[sx][sy] = '.';
						sx = tempx+dx[dir];
						sy = tempy+dy[dir];
						map[sx][sy] = '<';
					}
					for(char[] x : map) {
						for(char y : x) {
							System.out.print(y);
						}
						System.out.println();
					}
					System.out.println();
				}

			}

			sb.append("#").append(tc).append(" ");
			for(char[] x : map) {
				for(char y : x) {
					sb.append(y);
				}
				sb.append("\n");
			}

			System.out.println(sb);


		}

	}
}
