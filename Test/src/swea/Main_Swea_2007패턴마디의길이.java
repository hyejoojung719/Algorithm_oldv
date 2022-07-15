package swea;

import java.util.Scanner;

public class Main_Swea_2007패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for(int tc=1; tc<=test_case; tc++) {
			String str = sc.next();
			
			int result = 0;
			for(int i=1; i < str.length(); i++) {
				if(str.charAt(i)==str.charAt(0)) {
					for(int j=0; j<i; j++) {
						if(str.charAt(j) != str.charAt(j+i)) break;
						// i=5 j=0...4
						// KOREAKOREASK KOREAKOREASK KOREAKOREASK
						result = i;
					}
					i += (i-2);
					if( str.charAt(++i) != str.charAt(0)) {
						--i;
						result = 0;
						continue;
					}
				}
				
			}
			
			
			System.out.println("#"+tc+" "+result);
			
		}
	}
}
