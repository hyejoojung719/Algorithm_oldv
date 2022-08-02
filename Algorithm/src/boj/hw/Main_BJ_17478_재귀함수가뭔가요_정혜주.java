package boj.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_17478_재귀함수가뭔가요_정혜주 {

	// 1. 반복 -> 자기자신호출(언제)
	// 2. 언제까지 반복
	
	/* C구간
	 * 기저조건 만족시 출력할 부분
	   ________"재귀함수가 뭔가요?"
	   ________"재귀함수는 자기 자신을 호출하는 함수라네"
	   ________라고 답변하였지.
	 */
	
	// 재귀함수
	// 1. A구간 출력이 첫번째 
	// 2. 자기자신호출
	// 3. 반복이 끝나면 C구간 출력(기저조건 만족시) + return
	// 4. B구간 출력
	static int N;
	private static void recursion(int num, String prefix) {

		// 0을 넘겨주고 호출될 때마다 증가하면서 num과 같아질 때까지 반복하는 방법도 있음
		// prefix - 접두사
		// num - 몇 번째로 호출되는 메소드인지
		// 기저 조건 - 반복 종료 시점
		if(num == N) {
			// C구문 출력
			System.out.println(prefix + "\"재귀함수가 뭔가요?\"");
			System.out.println(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(prefix + "라고 답변하였지.");
			
			// else 안할 때 반복 종료
			// return;
		}else {
			// 1. A출력
			System.out.println(prefix + "\"재귀함수가 뭔가요?\"");
			System.out.println(prefix + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(prefix + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(prefix + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			
			// 2. 재귀함수 호출
			recursion(num+1, prefix+"____");
			
			// 3. B호출
			System.out.println(prefix + "라고 답변하였지.");
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(0, "");
		br.close();
	}
}
