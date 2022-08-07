package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝짓기_정혜주 {
	
	static final int TEST_CASE = 10;
	static Stack<Character> stack  = new Stack<>();
	static Stack<Character> tempStack  = new Stack<>();
	
	public static boolean openCheck(char ch) {
		if(ch == '{' || ch == '(' || ch == '<' || ch == '[') {
			return true;
		} 
		else return false;
	}
	
	public static boolean closeCheck(char ch) {
		
		tempStack = stack;
		
		if(ch=='}') {
			ch='{';
		}else if(ch==')') {
			ch='(';
		}else if(ch=='>') {
			ch='<';
		}else {
			ch='[';
		}
		
		while(!tempStack.isEmpty()) {
			// 스택에서 하나씩 값을 꺼내 input값과 비교
			// 짝이 맞는 애 만날 때까지 반복..(stack이 비어있으면 break)
			if(tempStack.peek() != ch) tempStack.pop(); // 짝이 아니면 계속 꺼냄
			else return true; // 짝이 맞으면 true 
		}
		return false; // 결국 짝이 없으면 false
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=TEST_CASE; tc++) {
			int length = Integer.parseInt(br.readLine());
			
			int result=0;
			
			if(length%2==1) result = 0;
			else {
				String str = br.readLine();
				
				for(int j=0; j<length; j++) {
					
					char input = str.charAt(j);
					
					if(openCheck(input)) {
						stack.add(input);
					}else {
						if(closeCheck(input)) result=1;
						else result = 0;
						
						tempStack.clear();
					}
				}
			}
			stack.clear();
			tempStack.clear();
			
			System.out.println("#"+tc+" "+result);
			
			
		}
		
		
	}
}
