package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	static int[][] map;
	static int N, H;
	static int[][] deltas = {{0,-1},{0,1},{1,0}};	// 좌, 우, 하
	
	// 자기 자신으로 돌아오는지 체크
	private static void game(int start) {
		int row = 0;
		int col = start;
		
		while(true) {
			if(map[row][col]==1) {
				
			}
		}
		
		if(map[row][col]==1) {
			for(int dir=0; dir<2; dir++) {
				int mRow = row + deltas[dir][0];
				int mCol = col + deltas[dir][1];
				
				if(mRow<0 || mCol<0 || mRow>=H || mCol>=N) continue;
				
				if(map[mRow][mCol]==1) {
					row = mRow;
					col = mCol;
					break;
				}
			}
		}else {
			while()
		}
	}
	
	public static void main(String[] args) throws Exception {
		// N : 세로선
		// M : 가로선
		// H : 각각의 세로선마다 가로선을 놓을 수 있는 위치 개수
		
		// i번 세로선 결과가 i번이 나와야 함
		// 추가해야하는 가로선 개수 최소값?
		// 불가능하거나 3보다 큰 값이면 -1 출력
		
		// N M H
		// 가로선 정보  a b
		// b, b+1을 a점 위치에서 연결
		
		// 초기 0으로 셋팅
		// 가로선 연결된 점은 1로 셋팅
		// 처음 1 만나면 1있는 쪽으로 좌우 셋팅
		// 만약 델타가 0 or 1일경우 상하로 셋팅(2,3)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			map[a][b] = 1;
			map[a][b+1] = 1;
		}
		
		for(int i=0; i<N; i++) {
			game(i);
		}
	}
}
