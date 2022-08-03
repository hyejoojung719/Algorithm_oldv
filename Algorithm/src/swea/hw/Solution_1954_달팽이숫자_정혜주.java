package swea.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int x = 0;
			int y = 0;
			int num = 1;
			
			// 1~N제곱까지 숫자 찍기
			// 방향 변경 조건 : 다음 좌표 경계 벗어남, 다음 좌표가 0이 아님
			// 델타 dr,dc 만듬 (우, 하, 좌, 상)
			
			
			
			for(int i=0; i<N/2+1; i++) {
				// 오른쪽 가로
				while(true) {
					if(y<N && snail[x][y]==0) {
						snail[x][y] = num;
					}else {
						y -= 1;
						break;
					}
					num++; y++;
				}
				x++;
				
				// 아래쪽 세로
				while(true) {
					if(x<N && snail[x][y]==0) {
						snail[x][y] = num;
					}else {
						x -= 1;
						break;
					}
					num++; x++;
				}
				y--;
				
				// 왼쪽 가로
				while(true) {
					if(y>=0 && snail[x][y]==0) {
						snail[x][y] = num;
					}else {
						y += 1;
						break;
					}
					num++; y--;
				}
				x--;
				
				// 위쪽 세로
				while(true) {
					if(x>=0 && snail[x][y]==0) {
						snail[x][y] = num;
					}else {
						x += 1;
						break;
					}
					num++; x--;
				}
				y++;
			}
			
			System.out.println("#" + tc);
			// 확인
			for(int[] col : snail) {
				for(int row : col) {
					System.out.print(row + " ");
				}
				System.out.println();
			}
		}
	}
}