package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_10836_여왕벌 {
	// 1. 제일 왼쪽 열, 제일 위쪽 행부터 크기 갱신
	//		- 총 2*M-1 개
	//		- 크기는 수열을 이룬다(0..1..2)
	//		- 가장 큰 수 2부터 적용할 것 
	// 2. 이후 나머지 애벌레들 크기 갱신

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int size = 2*M-1;
		int[] grow = new int[size];
		
		int zero=0, one=0, two=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			zero = Integer.parseInt(st.nextToken());
			one  = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());

			for(int j=zero; j<size; j++) {
				if(j>=zero+one) grow[j]+=2;
				else grow[j]+=1;
			}
		}
		
		// 출력
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(j==0) {
					// 가장 첫번쨰 열일때 
					sb.append((grow[size/2-i]+1)+" ");
				}else {
					sb.append((grow[size/2+j]+1)+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
