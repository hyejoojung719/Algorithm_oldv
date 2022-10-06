package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2805_나무자르기 {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		// input
		// N(나무 수) M(필요한 나무 길이)
		// 나무 높이가 N개 만큼 주어짐 
		
		// 최소 M미터 나무를 가져가기 위해 절단기에 설정할 수 있는 높이 최대값??
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			max = Math.max(max, input);
			arr[i] = input;
		}
		
		int ans = binarySearch(M, 0, max);
		
		System.out.println(ans);
	}
	
	// 이분탐색 메소드 기본 골격
	private static int binarySearch(int key, int low, int high) {
		
		while(low <= high) {
			int mid = (low+high)/2;
			
			// 나무 자르고 남은 나무
			long sum=0;
			for(int i=0; i<N; i++) {
				if(arr[i]>mid) {
					sum += (arr[i]-mid);
				}
			}
			
			if(key==sum) {
				// 탐색 성공 
				return mid;
			}else if(key<sum) {
				// 나무 길이 합이 더 크다면
				// 가장 낮은값을 높인다 => 그러면 mid가 높아짐
				low = mid + 1;
			}else {
				// 필요한 나무 길이가 더 크다면 
				// 가장 높은값을 낮춘다 => 그러면 mid가 더 낮아짐 
				high = mid - 1;
			}
		}
		
		return high;
	}
}
