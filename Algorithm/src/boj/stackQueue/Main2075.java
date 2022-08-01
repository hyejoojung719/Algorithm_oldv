package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2075 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N*N];
		
		for(int i=0, index = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				arr[index++] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-N]);
		
	}
}
