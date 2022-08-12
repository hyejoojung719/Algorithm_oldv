package learn0812;

import java.util.Arrays;

public class Perm_비트마스킹 {
	
	static int[] arr = {1,2,3,4,5};
	static int N = 5,  R = 3;
	static int[] result = new int[R];
	static int totalCnt;
	
	// 여기서는 5개의 flag를 쓴다. 
	// flag = 3 -> 00011
	public static void perm(int cnt, int flag) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if((flag & 1 << i) > 0) continue; // 0이 아니면 선택된 것
			// flag와 1의 비트열을 비교 -> 두 비트 모두 1이면 1, 아니면 0
			result[cnt] = arr[i];
			System.out.println("flag1 = " + flag);
			perm(cnt+1, flag | 1 << i);
			System.out.println("flag2 = " + flag);
			totalCnt++;
		}
	}
	
	
	public static void main(String[] args) {
		perm(0, 0);
		System.out.println(totalCnt);
	}
}
