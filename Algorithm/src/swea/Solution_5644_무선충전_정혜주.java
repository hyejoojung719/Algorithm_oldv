package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_정혜주 {

	// 제자리, 상, 우, 하, 좌
	static int[][] deltas =  {{0,0}, {-1,0}, {0,1}, {1,0}, {0,-1}};

	static class Bc{
		int col;	//x좌표
		int row;	//y좌표
		int c_range;	// 충전범위
		int performance;	// 처리량

		Bc(int col, int row, int c_range, int performance) {
			this.col = col;
			this.row = row;
			this.c_range = c_range;
			this.performance =performance;
		}
	}

	public static void main(String[] args) throws Exception{

		// 이동 - > 큐에 넣어도 될 것 같다 
		
		// 1. BC 클래스를 담는 배열 선언
		// 2. delta = {{0,0}, {-1,0}, {0,1}, {1,0}, {0,-1}};	-> 제자리, 상, 우, 하, 좌
		// 3. A 시작 : (0,0), B 시작 : (9,9)
		// 4. time 변수 : 0 ~ M초
		// 5. 매초마다 위치 갱신 && 범위에 속한 BC 체크(A,B두개) -> boolean[] bcCheck = new boolean[A];
		// 거리 <= C -> bcCheck에 반영
		// 충전량 비교
		// 이중 for문
		// i -> bcCheckA, j -> bcCheckB 
		// -> 둘다 true일 때  충전량 계산, 만약 index 같으면 공유

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=TC; tc++) {

			st = new StringTokenizer(br.readLine(), " ");

			// 이동 시간
			int move_time = Integer.parseInt(st.nextToken());
			// BC 개수
			int bc_cnt = Integer.parseInt(st.nextToken());

			// 0초부터 생각해야하므로 정확히 move_time+1초까지 범위가 됨
			// A 이동 정보
			st = new StringTokenizer(br.readLine(), " ");
			int[] move_a = new int[move_time+1];
			for(int i=1; i<move_time+1; i++) {
				move_a[i] = Integer.parseInt(st.nextToken());
			}

			// B 이동 정보
			st = new StringTokenizer(br.readLine(), " ");
			int[] move_b = new int[move_time+1];
			for(int i=1; i<move_time+1; i++) {
				move_b[i] = Integer.parseInt(st.nextToken());
			}
			
			move_a[0]=move_b[0]=0;
			
			// BC 정보 받기
			Bc[] bc_info = new Bc[bc_cnt];
			for(int i=0; i<bc_cnt; i++) {
				st  = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc_info[i] = new Bc(x, y, c, p);
			}

			// 초기 위치
			int rowA=0, colA=0, rowB=9, colB=9;



			// BC 체크 
			boolean[] bcCheckA;
			boolean[] bcCheckB;

			// 시간 변수
			int time=0;
			// 답
			int answer = 0;
			while(true) {
				// 거리 구하기(범위 안에 있는지) -> 충전기마다 돌아야함 
				bcCheckA = new boolean[bc_cnt];
				bcCheckB = new boolean[bc_cnt];
				for(int i=0; i<bc_cnt; i++) {
					int disA = Math.abs(rowA-(bc_info[i].row-1)) + Math.abs(colA-(bc_info[i].col-1));
					int disB = Math.abs(rowB-(bc_info[i].row-1)) + Math.abs(colB-(bc_info[i].col-1));
					
					if(disA <= bc_info[i].c_range) {
						// A가 BC범위 안에 속한다면
						bcCheckA[i] = true;
					}
					
					if(disB <= bc_info[i].c_range) {
						// B가 BC범위 안에 속한다면
						bcCheckB[i] = true;
					}
				}
				
				
				
				// 충전량 비교..
				int max_charge = 0;
				for (int i = 0; i < bc_cnt; i++) {
					for (int j = 0; j < bc_cnt; j++) {
						int charge = 0;
						if(bcCheckA[i] && bcCheckB[j]) {
							// 둘다 범위 에 속 할 때 
							if(i==j) charge = bc_info[i].performance;	// 둘이 같은 범위 일 경우	
							else charge = bc_info[i].performance + bc_info[j].performance;	// 다른 범위 일 경우
						}else if(bcCheckA[i] && !bcCheckB[j]) {
							// A만 범위에 속할 때
							charge = bc_info[i].performance;
						}else if(!bcCheckA[i] && bcCheckB[j]) {
							// B만 범위에 속할 때
							charge = bc_info[j].performance;
						}
						
						max_charge = Math.max(max_charge, charge);
					}
				}

				
				answer += max_charge;
				
				// 시간 추가
				time++;
				if(time>move_time) break;	// 이동 시간을 넘어가면 끝난다. 
				// A 이동 
				rowA += deltas[move_a[time]][0];
				colA += deltas[move_a[time]][1];
				// B 이동
				rowB += deltas[move_b[time]][0];
				colB += deltas[move_b[time]][1];
			}
			
			
			
			System.out.println("#" + tc + " " + answer);

		}
	}
}
