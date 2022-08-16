package jungol.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_jungol_1828_냉장고_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());

		int[][] chemsubs = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			chemsubs[i][0] = Integer.parseInt(st.nextToken());
			chemsubs[i][1] = Integer.parseInt(st.nextToken());
		}

		// 두번쨰 원소 기준 오름차순 (최고온도 동일하면 최저온도 오름차순)
		Arrays.sort(chemsubs, (e1, e2) ->{
			if(e1[1]== e2[1]) return e1[0]-e2[0];
			else return e1[1]-e2[1];
		});

		int max = chemsubs[0][1];
		int refCnt = 1;
		for(int i=1; i<N; i++) {
			if(max >= chemsubs[i][0]) continue;
			else {
				refCnt++;
				max = chemsubs[i][1];
			}
		}

		System.out.println(refCnt);
	}
}
