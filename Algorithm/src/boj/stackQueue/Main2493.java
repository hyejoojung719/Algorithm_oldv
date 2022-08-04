package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
	
	static class Tower{
		int h;
		int num;
		
		Tower(int h, int num){
			this.h = h;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<Tower> stack = new Stack<>();
		for(int i=1; i<=N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			
			while(!stack.isEmpty() && input > stack.peek().h) {
				stack.pop();
			}
			
			if(stack.size()==0) sb.append(0).append(" ");
			else {
				sb.append(stack.peek().num).append(" ");
			}
			
			stack.push(new Tower(input, i));
		}
		
		System.out.println(sb);
	}
}
