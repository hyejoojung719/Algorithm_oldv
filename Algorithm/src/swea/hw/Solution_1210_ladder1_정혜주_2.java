package swea.hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1210_ladder1_정혜주_2 {
	
	private static final int CASE = 1;
	private static final int N = 10;
	private static int[][] map = new int[N][N]; 
	private static int idx = 0;
	private static int ycnt = 0;
	
							// 하 좌 우
	private static int[] dx = {1,0,0};
	private static int[] dy = {0,-1,1};
	
	public static int recursion(int x, int y) {
		System.out.println("x : " + x + ", y : " + y);
		int answer = 0;
		if(map[x][y] == 0) { //출발지가 0일 때
			return 0;
		}else if(map[x][y] == 2){
			// 도착지에 가면 탐색 종료
			answer = x;
		}else {
			// 좌우 1 있을 때까지 반복
			while( x<N ) {
//				System.out.println("xx : " + x + ", xy : " + y);
				if((y+1)<N && map[x][y+1]==1) {
					idx = 2;
					y+=1;
					break;
				}else if(  (y-1)>=0 && map[x][y-1]==1) {
					idx = 1;
					y-=1;
					break;
				}
				x += dx[0];
				
			}
			
			
			// 아래 1 있을때까지 반복
			while((y+1)<N && (y-1)>=0) {
//				System.out.println("yx : " + x + ", yy : " + y);
				// 아래에 1 발견할때까지
				if((x+1)<N &&map[x+1][y]==1) {
					x+=1;
					break;
				}
				y += dy[idx];
			}
			
			if((x==N-1) && map[x][y] != 2) {
				x=0;
				y=0;
				ycnt++;
				y+=ycnt; 
//				if(y==N || x==N) return 0;
			}
			recursion(x, y);
			
			
		}
		return y;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("Ladder_input2.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= CASE ; tc++) {
			
			int test_case = sc.nextInt();
			
			// 배열 작성
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("#" + test_case + " " +  recursion(0,0));
		}
	}
}
