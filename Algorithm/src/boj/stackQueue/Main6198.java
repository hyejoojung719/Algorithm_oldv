package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main6198 {
	public static void main(String[] args) throws Exception{
		// 각 관리인들이 벤치마킹 가능한 빌딩 수의 합 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] height = new int[N];
		
		for(int i=0; i<N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		stack.add(height[0]);
		int result = 0;
		for(int i=0; i<N; i++) {
			int h = height[i];
			
			if(stack.peek() > h) {
				stack.add(h);
				result += stack.size()-1;
			}else {
				while(!stack.isEmpty() && stack.peek() <= h) {
					stack.pop();
				}
				stack.add(h);
				result += stack.size()-1;
			}
		}
		
		System.out.println(result);
		
	}
}
