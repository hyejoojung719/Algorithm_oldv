package learn0810;

import java.util.Arrays;

public class Combination {

	static int[] arr = {1,2,3,4,5};
	static int N = 5;
	static int R = 3;
	static int[] result;
	static boolean[] isVisited;

//	static int[] result = new int[R];	// 뽑을 요소를 담을 배열

	// 요소 한 개를 선택하고 다음 요소 선택은 재귀호출에 넘긴다. 
	// @param cnt 현재 선택된 요소의 개수 or cnt번째 요소 선택
	// @param start 현재 선택시 고려할 요소의 시작 인덱스
	// @param r 뽑을 요소의 개수추가 -> 부분집합 구할 때


	public static void comb(int cnt, int start, int r) {

		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}



		// 반복할 부분 
		for(int i=start; i<N; i++) {
			// 요소 선택
			result[cnt] = arr[i];

			comb(cnt+1, i+1, r);
		}
	}


	public static void main(String[] args) {

		for(int r=0; r<=5; r++) {
			result = new int[r]; // 뽑을 요소 담을 배열
			comb(0,0,r);
		}


//		comb(0,0);

/*
		// 반복문으로 짜보기
		// 0번쨰 요소 뽑기
		for(int i=0; i<N; i++) {
			result[0] = arr[i];
			//  1번째 요소 뽑기
			for(int j=i+1; j<N; j++) {
				result[1] = arr[j];
				// 2번째 요소 뽑기
				for(int k=j+1; k<N; k++) {
					result[2] = arr[k];
					System.out.println(Arrays.toString(result));
				}
			}
		}
*/

	}
}
