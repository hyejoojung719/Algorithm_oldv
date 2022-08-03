package swea.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_ladder1_정혜주 {

	private static final int N = 100;
	private static final int TEST_CASE = 10;
	private static int[] dy = {-1, 1}; // 좌우


	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("Ladder_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=TEST_CASE; tc++) {
			int[][] ladder = new int[N][N];
			
			int test_case = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 출발지 찾기
			int x = N-1;
			int y = 0;
			for(int i=0; i<N; i++) {
				if(ladder[N-1][i]==2) {
					y = i;
				}
			}
			
			int cnt=0;
			while(true) {
				cnt++;
				// 위로 이동(좌측 또는 우측에 1있을때까지)
				if(x<=0) break;
				int idx = 0;
				while(x>0) {
					if((y-1)>=0 && ladder[x][y-1]==1) {
						y--;
						idx = 0;
						break;
					}else if((y+1)<N && ladder[x][y+1]==1) {
						y++;
						idx = 1;
						break;
					}
					x--;
				}
				
				// 위에 1있을떄까지 이동
				while(x!=0) {
					if((x-1)>=0 &&ladder[x-1][y]==1) {
						x--;
						break;	
					}
					y += dy[idx];
				}
			}
			
			System.out.println("#"+ test_case + " " + y);

		}
		

	}
}
