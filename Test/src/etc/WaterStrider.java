package etc;

import java.util.Scanner;

public class WaterStrider {
	public static void main(String[] args) {
		
		// N*N 정사각형 연못 
		// 1st : 3칸, 2nd : 2칸, 3rd : 1칸
		// 소금쟁이의 처음 위치와 방향이 주어짐(다 다름)
		// 처음 소금쟁이는 1번, 다음 소금쟁이는 2번 순으로 번호 부여
		// 여러마리 소금쟁이가 순서대로 3번씩 뜀 
		// 밖으로 나가면 멈춤
		// 같은 장소를 두번 뛴 소금쟁이 번호 출력
		// 어떤 소금쟁이 시작 위치가 이미 뛰었던 곳 -> 그 소금쟁이 번호 출력
		// 같은 자리 뛴 소금쟁이가 없다면 0...
		
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for(int tc = 1; tc<=test_case; tc++) {
			int n = sc.nextInt(); 
			int strider = sc.nextInt();
		
			boolean[][] check = new boolean[n][n];
			int answer = 0;
			
			out: for(int i=1; i<=strider; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt(); 
				int dir = sc.nextInt();
				int rut = 0;
				
				
				if(dir==1) {
					for(int j=0; j<=3; j++) {
						if(rut==0) {
//							System.out.println(i+"번째 소금쟁이 : 제자리 ("+ col + ", " + row + ")" );
							if(!check[col][row]) check[col][row] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==1 && col+3<n) {
//							System.out.println(i+"번째 소금쟁이 : 아래측 3칸 ("+ (col+3) + ", " + row + ")" );
							if(!check[col+3][row]) check[col+3][row] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==2 && col+5<n) {
//							System.out.println(i+"번째 소금쟁이 : 아래측 2칸");
							if(!check[col+5][row]) check[col+5][row] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==3 && col+6<n){
//							System.out.println(i+"번째 소금쟁이 : 아래측 1칸");
							if(!check[col+6][row]) check[col+6][row] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}
						
					}
				}else if(dir==2) {
					for(int j=0; j<=3; j++) {
						if(rut==0) {
//							System.out.println(i+"번째 소금쟁이 : 제자리");
							if(!check[col][row]) check[col][row] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==1 && row+3<n) {
//							System.out.println(i+"번째 소금쟁이 : 우측 3칸");
							if(!check[col][row+3]) check[col][row+3] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==2 && row+5<n) {
//							System.out.println(i+"번째 소금쟁이 : 우측 2칸");
							if(!check[col][row+5]) check[col][row+5] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}else if(rut==3 && row+6<n) {
//							System.out.println(i+"번째 소금쟁이 : 우측 1칸");
							if(!check[col][row+6]) check[col][row+6] = true;
							else {
								answer = i;
								break;
							}
							rut++;
						}
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
