package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_10836_여왕벌 {
	static int M, N;
	static int zero, one, two;
	static int[][] honey;


	// 1. 제일 왼쪽 열, 제일 위쪽 행부터 크기 갱신
	//		- 총 2*M-1 개
	//		- 크기는 수열을 이룬다(0..1..2)
	//		- 가장 큰 수 2부터 적용할 것 
	// 2. 이후 나머지 애벌레들 크기 갱신

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		honey = new int[M][M];
		
		for (int[] row : honey) {
			Arrays.fill(row, 1);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			zero = Integer.parseInt(st.nextToken());
			one  = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());

			// 1번 수행
			first();
			
			// 2번 수행 -> 무조건 내 위에 애가 제일 큼
//			for(int r=1; r<M; r++) {
//				for (int c=1; c<M; c++) {
//					honey[r][c]=honey[0][c];
//				}
//			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if(i!=0 && j!=0) {
					sb.append(honey[0][j]+" ");
				}else {
					sb.append(honey[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void first() {

		for(int i=M-1; i>=0; i--) {
			if(zero!=0) zero--;
			else if(one!=0) {
				one--;
				honey[i][0]+=1;
			}else if(two!=0){
				two--;
				honey[i][0]+=2;
			}
		}

		for(int i=1; i<M; i++) {
			if(zero!=0) zero--;
			else if(one!=0) {
				one--;
				honey[0][i]+=1;
			}else if(two!=0){
				two--;
				honey[0][i]+=2;
			}
		}
	}

}
