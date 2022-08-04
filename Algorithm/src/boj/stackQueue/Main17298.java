package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			int idx = i;
			while(!stack.isEmpty() && stack.peek()<input) {
				
				if(idx-1 >=0 && arr[idx-1] == 0) {
					arr[--idx] = input;
					stack.pop();
				}else idx--;
			}
			stack.push(input);
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 0) arr[i] = -1;
		}
		
		for(int x : arr) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
		
		
	}
}
