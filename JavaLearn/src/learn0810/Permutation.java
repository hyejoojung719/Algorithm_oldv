package learn0810;

import java.util.Arrays;


public class Permutation {
	
	static int[] arr = {1,2,3,4,5};
	static int N = 5;
	static int R = 3;
	static int[] result = new int[R];
	static boolean[] isSelected = new boolean[N];// 이미 선택된 요소 체크
	
	
	/**
	 *	요소 하나 선택, 다음 요소 선택을 재귀 호출에 넘김
	 *	@param cnt cnt번째 요소 선택 or 현재 뽑은 요소의 개수
	 */
	public static void permutation(int cnt) {
		
		// 기저 조건 - 종료 조건
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		
		// 중복순열은 isSelected 체크하는 부분을 없애주면 된다.
		for(int i=0; i<N; i++ ) {
			// 이미 선택된 요소라면 다음 요소 고려
			if(isSelected[i]) continue; 
			
			result[cnt] = arr[i];	// cnt 번째 자리에 요소 선택
			
			isSelected[i] = true;	// i번째 요소 사용 체크
			
			permutation(cnt+1);	// 다음 요소 뽑기
			
			isSelected[i] = false; // 다음 요소 고려 위해 체크 해제
		}
	}
	
	public static void main(String[] args) {
		
		
		
		
		permutation(0);
		
		/*
		// 0번째 요소 서택
		for(int i=0; i<N; i++) {
			result[0] = arr[i];
			// 1번째 여서 산택
			for(int j=0; j<N; j++) {
				// 0번째 요소에서 뻡은 애라면 넘김
				if(i==j) continue;
				result[1] = arr[j];
				//2번째 요소 선택
				for(int k=0; k<N; k++) {
					// 0,1 번째에서 뽑은 요소라면 넘김
					if(i==k || j==k) continue; 
					result[2] = arr[k];
					System.out.println(Arrays.toString(result));
				}
				
			}
		}*/
	}
}
