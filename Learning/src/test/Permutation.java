package test;

import java.util.Arrays;

public class Permutation {
	static int r;
	static int[] arr;
	static boolean[] isVisited;
	static int[] checked;
	static int totalCnt;
	
	public static void perm(int cnt) {
		
		if(cnt == r) {
			System.out.println(Arrays.toString(checked));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			checked[cnt] = arr[i];
			perm(cnt+1);
			isVisited[i] = false;
			totalCnt++;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		r = 2;
		
		isVisited = new boolean[arr.length];
		checked = new int[r];
		perm(0);
		System.out.println(totalCnt);
		
	}
}
