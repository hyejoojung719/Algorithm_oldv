package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4_정혜주 {
	static int N, M, R;
	static boolean[] isSelected;
	static int[][] arr;
	static int[] permArr;
	static int[][] copyArr;
	static int[][] cal ;
	static int r, c, s;
	// 행 델타 
	static int[] delRow = {0, 1, 0, -1}; // 우 하 좌 상
	// 열 델타
	static int[] delCol = {1, 0, -1, 0}; // 우 하 좌 상
	static int min = Integer.MIN_VALUE;
	static int answer = Integer.MIN_VALUE;



	public static void move(int r, int c, int s) {
		N = 2*s+1;
		M = 2*s+1;	
		for(int j=0;  j<Math.min(N, M)/2; j++) {
			int row = r-s-1+1*j;
			int col = c-s-1+1*j;
			int dir = 0; // 우측

			int temp = copyArr[row][col];
			while(dir<4){
				if(r-s-1+1*j<=row+delRow[dir] && row+delRow[dir]<=r+s-1*(j+1)
						&& c-s-1+1*j<=col+delCol[dir] && col+delCol[dir]<=c+s-1*(j+1)) {

					int temp2 = copyArr[row+delRow[dir]][col+delCol[dir]];
					copyArr[row+delRow[dir]][col+delCol[dir]] = temp;
					temp = temp2;

					row += delRow[dir];
					col += delCol[dir];
				}else {
					dir++;
				}
			}
		}
	}


	public static void perm(int cnt) {
		
		if(cnt==R) {

			copyArr = arr.clone();
			
			for(int i=0; i<R; i++) {
				r = cal[permArr[i]][0];
				c = cal[permArr[i]][1];
				s = cal[permArr[i]][2];
				move(r,c,s);
			}
			
			int sum=0;
			for(int[] row : arr) {
				for(int col : row) {
					sum += col;
				}
				min = Math.min(min, sum);
				sum=0;
			}
			answer = Math.min(min, answer);

			return;
		}

		// 가능한 모든 수에 대해 시도
		for(int i = 1; i <= R; i++) {	// 선택지
			// 시도하는 수가 선택되었는지 판단
			if(isSelected[i]) continue;
			isSelected[i] = true;
			permArr[cnt] = i;
			// 다음수 뽑으러 가기
			perm(cnt+1);
			// 사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
			permArr[cnt] = 0;

		}
	}

	public static void main(String[] args) throws IOException {

		// (r, c, s) 
		// -> 시작 좌표 (r-s-1, c-s-1)
		// -> 끝좌표 (r+s-1, c+s-1)

		// 경계 
		// r-s-1<= row(행) <= r+s-1
		// c-s-1<= col(열) <= c+s-1


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permArr = new int[R];
		copyArr = new int[N][M];
		cal = new int[R][3];
		isSelected = new boolean[R+1];
		
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			cal[i][0] = r;
			cal[i][1] = c;
			cal[i][2] = s;
		}

		perm(0);

		
		System.out.println(answer);

	}
}
