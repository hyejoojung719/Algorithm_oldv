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
			
			// N*N까지 입력
			// 3 2 2 1 1
			// 4 3 3 2 2 1 1 
			// 5 4 4 3 3 2 2 1 1
			
			int x = 0;
			int y = 0;
			int num = 1;
		
			for(int i=0; i<N/2+1; i++) {
				while(x>=0 && x<N && y>=0 && y<N) {
					if(snail[x][y]==0) snail[x][y]=num;
					else break;
					y++;
					num++;
				}
				
				x++;
				// (x,y) = (0,2)
				while(x>=0 && x<N && y>=0 && y<N) {
					if(snail[x][y]==0) snail[x][y]=num;
					else break;
					x++;
					num++;
				}
				
				y--;
				// (x,y) = (2,2)
				while(x>=0 && x<N && y>=0 && y<N) {
					if(snail[x][y]==0) snail[x][y]=num;
					else break;
					y--;
					num++;
				}
				x--;
				// (x,y) = (2,0)
				while(x>=0 && x<N && y>=0 && y<N) {
					if(snail[x][y]==0) snail[x][y]=num;
					else break;
					x--;
					num++;
				}
			}
			
			
			System.out.println("#"+tc);
			for(int[] i : snail) {
				for(int j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
		}
	}
}
