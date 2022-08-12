package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040_백설공주와일곱난쟁이_정혜주 {
	
	static int N=9, R=7;
	
	
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static boolean method(int[] arr) {
		
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(i-1, j , arr);
		
		int k = N-1;
		while(i<k) {
			swap(i++, k--, arr);
		}
		return true;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		// 난쟁이 모자에 100보다 작은 양의 정수 적어놓음 -> 7난쟁이 모자 숫자 합하면 100
		// 9난쟁이 중 합이 100이 되는 7개 수 찾기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		int[] isSelected = new int[N];
		
		for(int i=0; i<R; i++) {
			isSelected[N-i-1] = 1;
		}
		
		do {
			int sum=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]==1) {
					sum+=arr[i];
				}
				
			}
			
			if(sum==100) {
				for(int i=0; i<N; i++) {
					if(isSelected[i]==1) {
						System.out.println(arr[i] + " ");
					}
				}
			}
		} while (method(isSelected));
		 
	}
}
