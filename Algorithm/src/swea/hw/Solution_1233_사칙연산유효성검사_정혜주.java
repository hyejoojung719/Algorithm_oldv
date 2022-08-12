package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 1. 부모 노드가 연산자인 경우
			// - 좌, 우 자식 노드 유효성 체크
		// 2. 노드가 숫자 -> 자식노드 없을때만 유효
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;
		
		StringTokenizer st;
		for(int tc=1 ; tc<=TC; tc++) {
			int nodes = Integer.parseInt(br.readLine());
			int result = 1;
			
			for(int i=0; i<nodes; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int idx;
				char ch;
				
				// 부모노드 
				if(st.countTokens() >=4) {
					idx = Integer.parseInt(st.nextToken());
					ch = st.nextToken().charAt(0);
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					
					// 부모노드가 연산자 아닐때
					if(!(ch == '+' || ch == '*' ||ch == '/' ||ch == '-') ) {
						result = 0;
					}
				}
				// 자식노드
				else {
					idx = Integer.parseInt(st.nextToken());
					ch = st.nextToken().charAt(0);
					
					if(ch == '+' || ch == '*' ||ch == '/' ||ch == '-') {
						result = 0;
					}
				}
				
				
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
