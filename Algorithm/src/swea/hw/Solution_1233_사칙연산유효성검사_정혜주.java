package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 1. 노드 탐색(dfs or bfs)
		// 2. 해당 노드의 유효성을 검사
				// - 해당 노드가 숫자인 경우
					// 자식 노드가 없어야 함
				// - 해당 노드가 연산자인 경우
					// 자식노드가 2개
					// 올 수 있는 조합 (1) 둘 다 숫자 (2) 왼쪽 연산자, 오른쪽 숫자인 경우 (3) 둘다 연산자
		// 이진트리의 특성을 봤을 때 말단은 모두 숫자, 나머지는 연산자여야 함
			// 인덱스 번호를 고려해서 예를들어 노드가 9개일때 2로 나눴을 때 5개는 말단
		
		
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
