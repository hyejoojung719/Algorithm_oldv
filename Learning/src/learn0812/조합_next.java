package learn0812;

import java.util.Arrays;

//5C3
public class 조합_next {
	
	static int[] arr = {1,2,3,4,5};
	static int N=5;
	static int R=3;
	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static boolean next(int[] arr) {
		
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(arr,i++,k--);
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		int[] isSelected = new int[N];
		// 00111 -> 3,4,5 선택
		// 00111만들기
		for(int i=0; i<R; i++) {
			isSelected[N-i-1] = 1;
		}
		
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(isSelected));
			for(int i=0; i<N; i++) {
				if(isSelected[i]==1) System.out.print(arr[i]);
			}
			System.out.println();
			
		} while (next(isSelected));
	}
}
