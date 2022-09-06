package learn0810;

import java.util.ArrayList;
import java.util.List;


public class SubSet {

	static int[] arr = {1,2,3,4,5};
	static int N = 5;
	static boolean[] isSelected = new boolean[N];	// 요소의 선택여부 판별
	static List<Integer> selected = new ArrayList<Integer>();
	

	/**
	 * 요소를 선택/비선택 후 다음 요소의 고려는 재귀로 넘김
	 * @param cnt 선택/비선택을 결정할 요소의 인덱스
	 */
	public static void subSet(int cnt) {
		
		
		if(cnt == N) {
			
			/*
			for(int i=0; i<N; i++) {
				if(isSelected[i])
					System.out.print(arr[i]);
			}
			System.out.println();*/
			System.out.println(selected);
			return;
		}
		
		// cnt인덱스의 요소를 뽑는 경우
//		isSelected[cnt] = true;
		selected.add(arr[cnt]);
		subSet(cnt+1);
		
		// cnt인덱스의 요소를 뽑지 않는 경우
//		isSelected[cnt] = false; 
		selected.remove(new Integer(arr[cnt]));
		subSet(cnt+1);
	}
	
	public static void main(String[] args) {
		
		subSet(0);
		
	}
}
