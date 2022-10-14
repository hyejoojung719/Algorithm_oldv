package practice;

import java.util.Arrays;

public class 순조부연습 {
	static int R = 3;
	static int N = 6;
	static int[] arr = {1,2,3,4,5,6};
	static boolean[] visited = new boolean[N];
	static int[] permArr = new int[R];
	static int[] combArr = new int[R];
	
	// 순열 
	private static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(permArr));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permArr[cnt] = arr[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	// 조합
	private static void comb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(combArr));
			return;
		}
		
		for(int i=start; i<N; i++) {
			combArr[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
	
	
	// 부분집합
	private static void subSet(int index) {
		
		if(index == N) {
			for (int i = 0; i < N; i++) {
				if(visited[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		visited[index] = true;
		subSet(index+1);
		visited[index] = false;
		subSet(index+1);
	}
	
	// 중복 순열
	private static void perm2(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(permArr));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			permArr[cnt+1] = arr[i];
			perm2(cnt+1);
		}
	}
	
	// 중복 조합
	private static void comb2(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(combArr));
			return;
		}
		
		for (int i = start; i < N; i++) {
			combArr[cnt] = arr[i];
			comb2(cnt+1, i);
		}
	}
	
	public static void main(String[] args) {
		perm(0);
	}
}
