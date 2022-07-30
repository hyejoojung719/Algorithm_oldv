package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int stack[] = new int[N];
		int start = 0;
		int index = 0;
		
		while(N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			if(input > start) {
				for(int i=start+1; i<=input; i++) {
					stack[index] = i;					
					index++;
					sb.append("+").append('\n');
				}
				start = input;
			}else if(stack[index-1] != input) {
				System.out.println("NO");
				System.exit(0);
			}
			
			index--;
			sb.append("-").append('\n');
		}
		System.out.println(sb);
	}
}