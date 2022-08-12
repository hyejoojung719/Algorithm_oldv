package learn0812;

import java.util.Arrays;

// nPn일때만 사용가능
public class Perm_NextPerm {

	// 1. 꼭대기 인덱스 올라가는 구간 찾기
	
	// 2. 찾은 값과 교환할 값 찾기 -> 오른쪽에서부터 찾은 값 보다 큰 값으로
	
	// 3. 두 개의 요소 swap
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static boolean next_perm(int[] arr) {
		
		int N = arr.length;

		//1. 꼭대기 인덱스 찾기 -> 증가하는 구간 찾기
		int i=N-1;
		while(i>0 && arr[i-1] >= arr[i]) {
			i--;	
		}
		
		// 꼭데기 인덱스가 0이라면? 모든 수가 내려가는 구간이므로 이미 가장 큰 수
		if(i==0) return false;
		
		// 2. i-1요소와 교환할 요소의 인덱스를 찾는다. 
		int j=N-1;
		while(arr[i-1]>=arr[j]) { // 경계체크 필요 X -> 올라가는 구간이므로 나보다 큰 값이 있기 때문에
			j--;	// i-1요소보다 큰 값을 뒤에서부터 탐색함..., 
		}
		
		// 3. (i-1)요소와 j요소 swap
		swap(arr, i-1, j);
		
		// 4. i부터 n-1까지 swap하면서 오름차순 정렬을 해준다. 
		int k = N-1; // k는 뒤에 있는 요소의 포인터, i는 앞에 있는 요소의 포인터
		while(i<k) {
			swap(arr, i++, k--);
		}
		
		// 큰 순열을 만들어내는데 성공했으므로  true 반환
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3,5,4,2,1};
		// 가장 작은 숫자로 정렬
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		} while (next_perm(arr));
	}
}
