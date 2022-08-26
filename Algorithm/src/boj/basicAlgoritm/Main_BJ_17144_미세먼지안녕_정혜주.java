package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕_정혜주 {
	static int R, C, T;
	static int[][] map;
	static int[][] copymap;
	static int[] airrow;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상 하 좌 우
	static int[][] wayUp = {{0,1},{-1,0},{0,-1},{1,0}};	// 우 상 좌 하
	static int[][] wayDown = {{0,1},{1,0},{0,-1},{-1,0}};	// 우 하 좌 상

	// 미세먼지 확산 
	public static void diff() {
		int cnt = 0;
		copymap = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				cnt = 0;
				if(map[i][j] != 0) {
					// 현재 먼지 수
					int  dust = map[i][j];
					// 확산되는 양
					int diff_dust = dust/5;
					// 상 하 좌 우 확산 가능한 칸 수 카운트
					int candiff=0;
					for(int dir=0; dir<4; dir++) {
						int mrow = i + deltas[dir][0];
						int mcol = j + deltas[dir][1];

						if(0<=mrow && mrow<R && 0<=mcol && mcol<C) {
							if(map[mrow][mcol] != -1) {
								candiff++;
								// 임시 배열에 변화량 반영
								copymap[mrow][mcol] += diff_dust;
							}
						}
					}
					copymap[i][j] += dust - candiff*diff_dust;
				}
			}
		}

		afterdiff();
	}

	// 1단계 끝난후 변화량 map에 반영
	public static void afterdiff() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copymap[i][j];
			}
		}
	}

	// 2단계 공기청정기 이동(윗부분)
	// 1. 경계를 만나면 방향을 바꾼다(경계 체크).
	// 2. 다음 칸의 값을 변수에 저장 한다. 
	// 3. 현재 값을 다음 칸에 저장
	// 4. 현재 칸은 이전 값이 -1 이거나 0이면 0을 저장한다. 
	public static void airmoveUp(int row, int col) {	// 파라미터는 공기청정기 다음 칸에서부터 시작한다. 
		// 윗 부분 먼지 이동
		int tmp = 0, tmp2=map[row][col];
		int dir = 0;
		while(dir<4) {
			// 우 상 좌 하
			int mrow = row + wayUp[dir][0];
			int mcol = col + wayUp[dir][1];

			tmp = tmp2;
			if(0<=mrow && mrow<R && 0<=mcol && mcol<C && map[mrow][mcol]!=-1) {
				tmp2 = map[mrow][mcol];
				map[mrow][mcol] = tmp;

				int trow = row + wayUp[(dir+2)%4][0];
				int tcol = col + wayUp[(dir+2)%4][1];
				if( 0<=trow && trow<R && 0<=tcol && tcol<C){
					if( map[trow][tcol] == -1 ) {
						map[row][col] = 0;
					}
				}
				row = mrow; col = mcol;

			}else dir++;
		}

	}


	public static void airmoveDown(int row, int col) {	// 파라미터는 공기청정기 다음 칸에서부터 시작한다. 
		// 아랫 부분 먼지 이동
		int tmp = 0, tmp2=map[row][col];
			int dir = 0;
			while(dir<4) {
				// 우 하 좌 상
				int mrow = row + wayDown[dir][0];
				int mcol = col + wayDown[dir][1];

				tmp = tmp2;
				if(0<=mrow && mrow<R && 0<=mcol && mcol<C && map[mrow][mcol]!=-1) {
					tmp2 = map[mrow][mcol];
					map[mrow][mcol] = tmp;

					int trow = row + wayDown[(dir+2)%4][0];
					int tcol = col + wayDown[(dir+2)%4][1];
					if( 0<=trow && trow<R && 0<=tcol && tcol<C){
						if( map[trow][tcol] == -1 ) {
							map[row][col] = 0;
						}
					}
					row = mrow; col = mcol;

				}else dir++;
			}
		
	}



	public static void main(String[] args) throws Exception {

		// R * C
		// Input 1 : R C T(초)
		// input 2 : map  공기청정기 -1, 나머지는 미세먼지양
		// output : T초가 지난 후 남아 있는 미세먼지 양

		// 1초 동안(1 -> 2)
		// 1. 미세먼지 확산 : 모든 칸에서 동시에!!
		// - 인접한 네 방향으로 확산(단, 공기청정기X, 경계밖X )
		// - 확산 되는 양 = 숫자/5
		// - 남아 있는 양 = 숫자 - 숫자/5*확산개수
		// 2. 공기 청정기 작동
		// 위쪽공기 청정기는 반시계 방향(우 상 좌 하)
		// 아래쪽 공긴기는 시계 방향(우 하 좌 상)
		// 바람 방향대로 미세먼지 한 칸씩 이동
		// 공기청정기로 들어가면 사라짐

		// 1. 미세먼지 확산
		// 경계 밖 X, -1 아닌 곳에서 라는 조건 추가
		// org값을 유지한채 확산후 변하는 값을 한번에 변경해야함
		// 2. 공기 청정기 작동
		// 공기 청정기 작동 후 -> 배열 요소 이동 
		// - up, down 구분
		// - 경계를 만나면 방향을 전환한다. 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		airrow = new int[2];
		int air_idx=0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j]==-1) {
					airrow[air_idx] = i;
					air_idx++;
				}
			}
		}

		for(int i=0; i<T; i++) {
			// 1단계. 미세 먼지 확산
			diff();
			
			// 2단계. 공기 청정기 가동
			airmoveUp(airrow[0], 1);
			airmoveDown(airrow[1], 1);
			
		}

		int sum=0;
		for(int[] x : map) {
			for(int y : x) {
				if(y>0) {
					sum+=y;
				}
			}
		}
		System.out.println(sum);

	}
}
