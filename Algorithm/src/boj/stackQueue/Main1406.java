package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1406 {
	
	static Stack stack1 = new Stack<>();
	static Stack stack2 = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		// 커서는 문장의 맨 앞
		// 커서는 문장의 맨 뒤
		// 커서는 문장 중간 임의의 곳에 위치 가능
		// Length+1 가지 경우에 커서 위치 가능


		// L : 왼쪽 이동(맨앞 x)
		// D : 오른쪽 이동(맨뒤 x)
		// B : 커서 왼쪽에 있는 문자 삭제 (맨앞 x)
		// P $ : $라는 문자를 커서 왼쪽에 추가 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		for(int i=0; i<str.length(); i++) {
			stack1.push(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());

		for(int i=0; i< M; i++) {
			String command = br.readLine();
			
			if(command.equals("L")) {
				if(!stack1.empty()) stack2.push(stack1.pop());
				
			}else if(command.equals("D")) {
				if(!stack2.empty()) stack1.push(stack2.pop());
				
			}else if(command.equals("B")) {
				if(!stack1.empty()) stack1.pop();
				
			}else { //P $
				stack1.push(command.charAt(2));
			}
		}

		while(!stack1.empty()) stack2.push(stack1.pop());
		
		StringBuilder sb = new StringBuilder();

		while(!stack2.empty()) sb.append(stack2.pop());
		
		System.out.println(sb);

	}
}
