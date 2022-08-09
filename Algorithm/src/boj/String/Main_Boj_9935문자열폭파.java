package boj.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_Boj_9935문자열폭파 {

	public static void main(String[] args) throws Exception
	{
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = br.readLine();
			String exploStr = br.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int i=0; i < str.length(); i++) {
				stack.push(str.charAt(i)); // 문자 하나씩 스택에 집어 넣기
				
				if(stack.size() >= exploStr.length()) // 스택의 사이즈가 폭발 문자열 길이보다 크거나 같아지는 순간
				{
					boolean check = true; // 같은 문자열이 있는지 체크하기위해
					
					// 같은 문자열 있는지 체크
					for(int j=0; j<exploStr.length(); j++) {
						if(stack.get(stack.size() - exploStr.length() + j) != exploStr.charAt(j)) {
							check = false;
							break;
						}
					}
					if(check) {
						for(int j=0; j<exploStr.length(); j++) {
							stack.pop();
						}
					}
				}
			}
			
			if(stack.size() == 0) System.out.println("FRULA");
			else {
				StringBuilder sb = new StringBuilder();
				for(char ch : stack) {
					sb.append(ch);
				}
				System.out.println(sb.toString());
			}
			
			
			
		}

	}
