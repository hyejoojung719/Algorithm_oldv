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
		
		long cnt = 0;
		for(int i=0; i<N; i++) {
			int h = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && h >= stack.peek()) {
				// 더 높은 건물이 들어오면 그 건물보다 낮은 건물들 모두 스택에서 빼기
				stack.pop();
			}
			cnt += stack.size();
			stack.push(h);
		}
	
		System.out.println(cnt);
		br.close();
	}
}
