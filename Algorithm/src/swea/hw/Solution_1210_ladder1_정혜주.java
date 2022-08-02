//package swea.hw;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class Solution_1210_ladder1_정혜주 {
//
//	private static final int CASE = 1;
//	private static final int N = 10;
//	
//	// 하 좌 우
////	private static int[] dx = {1,0,0};
//	private static int[] dy = {0,-1,1};
//
//	public static void main(String[] args) throws FileNotFoundException {
//
//		System.setIn(new FileInputStream("Ladder_input2.txt"));
//
//		Scanner sc = new Scanner(System.in);
//
//		// map 입력 받고
//		int[][] map = new int[N][N];
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
//
//		int col = 0;
//		// 2를 탐색
//		for(int i=0; i<N; i++) {
//			if(map[N-1][i]==2) {
//				col = i;
//			}
//		}
//
//		// 위로 이동(좌,우 1 만날 때까지)
//		while() {
//			if() {
//				
//			}else if() {
//				
//			}
//			col -= 1; 
//		}
//
//
//	}
//}
