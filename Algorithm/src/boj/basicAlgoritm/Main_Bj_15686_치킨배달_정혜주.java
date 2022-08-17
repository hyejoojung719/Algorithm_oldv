package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Bj_15686_치킨배달_정혜주 {

	static int M, N;
	static Stack<int[]> chicken;
	static Stack<int[]> home;
	static boolean[] chickenCheck; // 조합 경우의 수 담을 배열

	static int result = Integer.MAX_VALUE;


	public static void main(String[] args) throws IOException {

		// N*N
		// 치킨 거리  : 집과 가장 가까운 치킨집 사이 거리
		// (r1,c1)~(r2,c2) = |r1-r2| + |c1-c2|
		// 도시의 치킨 거리 : 모든 집의 치킨 거리 합

		// 폐업 시키지 않을 치킨집 최대 M개를 고르고, 도시의 치킨 거리가 가장 작은 경우 구하기

		// M : 가장 수익 을 많이 낼 수 있는 치킨집 개수 -> 최대한 집과의 거리가 가까워야함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 어차피 좌표값만 있으면 거리비교가 가능하기 때문에 map 그릴필요 없음
		chicken = new Stack<>();
		home = new Stack<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());

				if(input==0) continue;
				else if(input==1) home.add(new int[] {i,j});
				else if(input==2) chicken.add(new int[] {i,j});
			}
		}

		// 1. 치킨집 중 M개를 뽑음
		chickenCheck = new boolean[chicken.size()];
		comb(0, 0); 

		System.out.println(result);

	}

	// 1. 치킨 집 중 M개 뽑기 -> 조합
	public static void comb(int cnt, int start) {

		if(cnt == M) {
			// 경우의 수들 중 한 개의 조합이 나왔을 떄 

			// 2. 그 M개의 치킨집의 치킨 거리를 구함
			int total = 0;
			for(int[] home : home) {
				int sum = Integer.MAX_VALUE; 
				for(int j=0; j<chickenCheck.length; j++) {
					if(chickenCheck[j]) {
						sum = Math.min(sum,Math.abs(home[0]-chicken.get(j)[0])
								+ Math.abs(home[1]-chicken.get(j)[1]));
					}
				}
				total += sum;
			}

			result = Math.min(result, total);

			return;
		}

		for(int i=start; i<chicken.size();i++) {
			//			int[] stack_arr = chicken.pop();
			//			chick_result[cnt][0] = stack_arr[0];
			//			chick_result[cnt][1] = stack_arr[1];
			//			이렇게 하면 다음 루프를 돌 떄 스택값에 값이 없어서 제대로 안 됨

			chickenCheck[i] = true;
//			comb(cnt+1, start+1); 
			comb(cnt+1, i+1);
			chickenCheck[i] = false;	// 이거 추가해줘야하징
		}
	}


}
