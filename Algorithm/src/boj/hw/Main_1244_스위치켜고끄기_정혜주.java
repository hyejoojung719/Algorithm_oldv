package boj.hw;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기_정혜주 {
	public static void main(String[] args) throws Exception{
		// 1 : 스위치 켜져 있음
		// 0 : 꺼져있음
		
		// 남학생 스위치번호 = 받은수의 배수일때 상태 바꿈
		// 여학생 자기가 받은 수와 같은 번호 스위 중심으로 좌우 대칭이면서 가장 많은 스위치 포함 구간의 상태 모두 바꿈
		// 이때 구간에 속한 스위치 개수는 항상 홀수
		
		
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
			
			if(gender == 1) {
				
				for(int idx=0; idx<N; idx++) {
					if((idx+1)%cnt==0) {
						lamp[idx] = (lamp[idx]==0) ? 1 : 0;
					}
				}
				
			}else {
				
				if((cnt-1)==0 || (cnt-1)==N-1) {
					lamp[cnt-1] = (lamp[cnt-1]==0) ? 1 : 0;
					continue;
				}
				
				// 좌우 대칭 확인
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
		
		
		// 출력 주의 -> 한 줄에 20개씩
		for(int i=0; i<N; i++) {
			System.out.print(lamp[i] + " ");
			if((i+1)%20==0) System.out.println();
		}
	}
}
