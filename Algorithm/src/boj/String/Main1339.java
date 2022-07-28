package boj.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.Comparator;


public class Main1339 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

			
		Integer[] arr = new Integer[26]; 
		
		Arrays.fill(arr, 0);
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[str.charAt(j)-'A'] += (int)Math.pow(10, (str.length()-(j+1)));
			}
		}
		
		// 배열 크기 순 정렬 (내림차순)
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int sum=0, num = 9, i=0;
		
		while(arr[i]!=0) {
			sum += arr[i]*(num--);
			i++;
		}
		
		System.out.println(sum);

	}
}
