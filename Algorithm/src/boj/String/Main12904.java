package boj.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12904 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		// 역순 생각
		// str2 끝에서 부터
		// A면 A제거
		// B면 뒤집고 앞에 B제거 
		// 반복
		
		int i=str2.length()-1;
		while(str1.length() != str2.length()) {
			if(str2.charAt(i) == 'A') str2 = str2.substring(0,i);
			else if(str2.charAt(i) == 'B') {
				StringBuilder sb = new StringBuilder();
				sb.append(str2);
				sb.reverse();
				str2 = sb.toString();
				str2 = str2.substring(1,str2.length());
			}
			i--;
		}
		
		if(str1.equals(str2)) System.out.println(1);
		else System.out.println(0);
	}
}
