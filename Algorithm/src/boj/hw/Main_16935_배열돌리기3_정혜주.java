package boj.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3_정혜주 {

	//	우	하	좌 	상
	static int[] delCol = {0, 1, 0, -1};
	static int[] delRow = {1, 0, -1, 0};
	static int[][] arr;
	static int N, M, R;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());	 // 수행 하는 연산의 수

		// 배열 입력 받기
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<R; i++) {
			int com = Integer.parseInt(st.nextToken());

			switch(com) {
			case 1:
				first();
				break;
			case 2:
				second();
				break;
			case 3:
				third();
				break;
			case 4:
				forth();
				break;
			case 5:
				fifth();
				break;
			default:
				sixth();
				break;
			}
		}

		// 1번 연산 수행 
		//		first();

		// 2번 연산 수행
		//		second();

		// 3번 연산 : 오른쪽 90도 회전
		//		third();

		// 4번 연산 : 왼쪽 90도 회전
		//		forth();

		// 5번 연산
		//		fifth();

		// 6번 연산
//		sixth();

		// 출력
		for(int[] col : arr) {
			for(int row : col) {
				System.out.print(row + " ");
			}
			System.out.println();
		}

	}

	// 1번 연산 : 상하 반전
	// 1. 각 열마다 N(행)/2 번씩 비교한다
	// 2. (col, row) <-> (N-j, row)를 바꾼다. 
	// 3. N/2번 비교가 끝나면 열을 한칸 옮겨준다(M번 비교). 
	public static void first() {
		int dir = 1;	// 아래방향
		int col=0, row=0;
		for(int i=0; i<M ; i++) {
			for(int j=1; j<=N/2; j++) {
				int tmp = arr[col][row];
				arr[col][row] = arr[N-j][row];
				arr[N-j][row] = tmp;
				col+=delCol[dir];
				row+=delRow[dir];
			}
			// 한 열을 끝나면 옆으로 옮겨준다. 행은 다시 맨위로 올림.
			col=0;
			row++;
		}

	}

	// 2번 연산 : 좌우 반전 -> 1번 연산 반대
	// 1. 각 행마다 M(열)/2 번씩 비교한다
	// 2. (col, row) <-> (col, M-j)를 바꾼다. 
	// 3. M/2번 비교가 끝나면 행을 한칸 옮겨준다(N번 비교).
	public static void second() {
		int dir = 0;	// 우측방향
		int col=0, row=0;
		for(int i=0; i<N ; i++) {
			for(int j=1; j<=M/2; j++) {
				int tmp = arr[col][row];
				arr[col][row] = arr[col][M-j];
				arr[col][M-j] = tmp;
				col+=delCol[dir];
				row+=delRow[dir];
			}
			// 한 행이 끝나면 아래로 옮겨준다. 열은 다시 맨왼쪽으로 당김.
			col++;
			row=0;
		}

	}

	// 3번 연산 : 오른쪽 90도 회전
	// 1. 90도 회전 한 배열을 담을 새로운 배열 [M][N]을 만든다. 
	// 2. 초기 : (0,0) -> (0, N-1) col=0, row=0, new_col=0, new_row=N-1
	// 3. org_dir -> 우측 방향을 시작  / new_dir -> 아래 방향 시작
	// 4. 원본 배열 옆으로 한칸 이동(M-1만큼), 새로운 배열 아래로 한칸 이동(M-1만큼)
	// 5. 한 줄 다 채우면 원본 배열 col값 -1, row값 0, 새배열 row값 -1, col값 0
	public static void third() {
		int[][] new_arr = new int[M][N];	// 새 배열
		int col=0, row=0, new_col=0, new_row=N-1;

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				new_arr[new_col][new_row] = arr[col][row];
				row++;
				new_col++;
			}
			col++;
			row=0;
			new_row--;
			new_col=0;
		}
		arr = new_arr.clone();
		int tmp = N;
		N=M;
		M=tmp;
	}

	// 4번 연산 : 왼쪽 90도 회전
	// 1. 90도 회전 한 배열을 담을 새로운 배열 [M][N]을 만든다. 
	// 2. 초기 : (0,M-1) -> (0, 0) 
	// 3. org_dir -> 우측 방향을 시작  / new_dir -> 아래 방향 시작
	// 4. 원본 배열 옆으로 한칸 이동(M-1만큼), 새로운 배열 아래로 한칸 이동(M-1만큼)
	// 5. 한 줄 다 채우면 원본 배열 col값 -1, row값 0, 새배열 row값 -1, col값 0
	public static void forth() {
		int[][] new_arr = new int[M][N];	// 새 배열
		int col=0, row=M-1, new_col=0, new_row=0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				new_arr[new_col][new_row] = arr[col][row];
				row--;
				new_col++;
			}
			col++;
			row=M-1;
			new_row++;
			new_col=0;
		}
		arr = new_arr.clone();
		int tmp = N;
		N=M;
		M=tmp;
	}

	// 5번 연산 : 부분 배열 옮기기 
	public static void fifth() {
		int[][] new_arr = new int[N][M];	// 새 배열
		int[][] num = {{0,0}, {0, M/2}, {N/2,M/2}, {N/2,0}};

		for(int k=0; k<4; k++) {
			int col = num[k][0], row = num[k][1];
			int new_col = num[(k+1)%4][0], new_row = num[(k+1)%4][1];

			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					new_arr[new_col][new_row] = arr[col][row];
					row++;
					new_row++;
				}
				col++;
				row = num[k][1];
				new_col++;
				new_row = num[(k+1)%4][1];
			}
		}
		arr = new_arr.clone();
	}

	// 6번 연산 : 부분 배열 옮기기 
	public static void sixth() {
		int[][] new_arr = new int[N][M];	// 새 배열
		int[][] num = {{0,0}, {N/2, 0}, {N/2,M/2}, {0,M/2}};

		for(int k=0; k<4; k++) {
			int col = num[k][0], row = num[k][1];
			int new_col = num[(k+1)%4][0], new_row = num[(k+1)%4][1];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					new_arr[new_col][new_row] = arr[col][row];
					row++;
					new_row++;
				}
				col++;
				row = num[k][1];
				new_col++;
				new_row = num[(k+1)%4][1];
			}
		}
		arr = new_arr.clone();
	}
}
