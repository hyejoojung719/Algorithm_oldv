package boj.basicAlgoritm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기_정혜주 {
	public static void main(String[] args) throws Exception{
		// 1. 학생 수만큼 받은 번호에 따라 스위치 처리
			// 남, 녀 구분
			// 남 : 받은 번호 배수인 스위치 모두 변경 => 받은 번호에 숫자를 곱하며 진행할 경우 스위치 개수 이하까지
			// 여 : 받은 번호 스위치 중심을 상태 대칭되는 구간 스위치 모두 변경
				// 1. 받은 번호 스위치 변경
				// 2. 받은 번호부터 거리를 1씩 증가하여 좌우 스위치 체크 후 변경
					// - 경계체크
					// - 좌우 대칭 체크
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] lamp = new int[N];
		
		// 남학생 1
		// 여학생 2
		for(int i=0; i<N; i++) {
			lamp[i] = sc.nextInt();
		}
		
		int man = sc.nextInt();
		for(int i=0; i<man; i++) {
			
			int gender = sc.nextInt();
			int cnt = sc.nextInt();
			
			// 성별에 따라 메소드 처리
			if(gender == 1) {
				
				for(int idx=0; idx<N; idx++) {
					if((idx+1)%cnt==0) { // 배수로도 가능(while문)
						lamp[idx] = (lamp[idx]==0) ? 1 : 0;
					}
				}
				
			}else {
				
				// 1. 받은 번호의 스위치 변경 -> 굳이 if문 안 해도 됨
				if((cnt-1)==0 || (cnt-1)==N-1) {
					lamp[cnt-1] = (lamp[cnt-1]==0) ? 1 : 0;
					continue;
				}
				
				// 2. 좌우 대칭 확인(거리 1씩 증가하며 좌우 체크)
				// 거리 변수 dis=1 선언후 dis 증가하면서 체크하는 방법도 있음
				// int pointL = (cnt-1)-dis; int pointR = (cnt-1)+dis;
				// 경계 넘어가거나 대칭이 아니면 break문 처리(아래 while 조건문 반대로)
				// 바로 좌우 스위치 변경해도 됨
				int num = 0;
				int pointL = (cnt-1)-1;
				int pointR = (cnt-1)+1;
				while((pointL>=0 && pointR<N)&& lamp[pointL]==lamp[pointR]) {
					pointL--;
					pointR++;
					num++;
				}
				
				for(int idx=(cnt-1)-num; idx <=(cnt-1)+num; idx++) {
					lamp[idx] = (lamp[idx]==0) ? 1 : 0;
				}
				
			}
		}
		
		// 출력 -> StringBuilder쓰기
		// 출력 주의 -> 한 줄에 20개씩
		for(int i=0; i<N; i++) {
			System.out.print(lamp[i] + " ");
			if((i+1)%20==0) System.out.println();
		}
	}
}
