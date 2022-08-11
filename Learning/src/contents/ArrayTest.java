package contents;
import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		
		// 1차원 배열 선언
		int[] arr = new int[6];
		System.out.println(arr[0]);
		//  배열은 초기화를 안하면 자동으로 0셋팅
		
		
		// 선언과 초기화 한번에 처리
		
		// 방법1
		int[] arr2 = new int[]{1,2,3,4,5};
		System.out.println(Arrays.toString(arr2));
		
		// 방법2
		// new int[]는 선언시에만 생략 가능
		int[] arr3 = {1,2,3,4,5};
		System.out.println(Arrays.toString(arr3));
		/* 이거는 안 됨
		int[] arr4;
		arr4 = {1,2,3,4,5}; 
		*/
		
		// 방법3
		int[] arr4;
		arr4 = new int[] {1,2,3,4,5};
		
		/* for문 이용해서 출력
		for(int idx=0; idx<4; idx++) {
			System.out.println(arr[idx]);
		}*/
		
		// for-each문 이용해서 출력
		// for(배열의 요소 : 배열)
		for(int x : arr4) System.out.println(x);
		// for-each 쓸 때는 값 변경x(따라서 값을 읽을 때만 사용 readonly)
		
	
		
		
	}
}
