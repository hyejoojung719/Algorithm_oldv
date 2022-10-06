package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2805_나무자르기 {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		int low=0;
		int high= 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			high = Math.max(high, input);
			arr[i] = input;
		}
		
		while(low <= high) {
			int mid = (low+high)/2;
			
			
			long sum=0;
			for (int height : arr) {
				if(height > mid) {
					sum += (height-mid);
				}
			}
			
			if(sum<M) {
				// 자른 나무 길이 합이 필요한 나무 길이 보다 작은 경우
				System.out.println("자른 나무 길이 합 < 필요한 나무 길이");
				System.out.println("high : mid : low = " + high + " : "  + mid + " : " + low);
				System.out.println("sum = " + sum);
				high = mid-1;
			}else if(sum>M){
				// 자른 나무 길이 합이 필요한 나무 길이 보다 큰 경우
				System.out.println("자른 나무 길이 합 > 필요한 나무 길이");
				System.out.println("high : mid : low = " + high + " : "  + mid + " : " + low);
				System.out.println("sum = " + sum);
				low = mid+1;
			}else {
				// 자른 나무 길이 합이 필요한 나무 길이와 같은 경우
				System.out.println("자른 나무 길이 합 == 필요한 나무 길이");
				System.out.println("high : mid : low = " + high + " : "  + mid + " : " + low);
				System.out.println("sum = " + sum);
				System.out.println(mid);
				System.exit(0);
			}
		}
		
		System.out.println(low-1);
		
	}
}