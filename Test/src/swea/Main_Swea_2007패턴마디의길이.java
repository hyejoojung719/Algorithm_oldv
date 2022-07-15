package swea;

import java.util.Scanner;

public class Main_Swea_2007패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for(int tc=1; tc<=test_case; tc++) {
			String str = sc.next();
			
			for(int i=1; i < str.length(); i++) {
				if(str.charAt(i)==str.charAt(0)) {
					for(int j=0; j<i; j++) {
						if(str.charAt(j) != str.charAt(j+i)) break;
						i+=(i-2);
					}
				}
			}
		}
	}
}
