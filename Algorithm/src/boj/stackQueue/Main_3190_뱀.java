package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {

	static class Move{
		int time_x;
		char dir_c;

		Move(int time_x, char dir_c){
			this.time_x = time_x;
			this.dir_c = dir_c;
		}
	}

	static class Snake{
		int col;
		int row;

		Snake(int col, int row){
			this.col = col;
			this.row = row;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 좌 하 우 상
		int[][] deltas = {{0,-1},{1,0},{0,1},{-1,0}};
		// 우 -> 상 : 2 -> 3 (L) +1
		// 우 -> 하 : 2 -> 1 (D) +3
		// 좌 -> 상 : 0 -> 3 (D) +3
		// 좌 -> 하 ; 0 -> 1 (L) +1
		// 상 -> 우 : 3 -> 2 (D) +3
		// 상 -> 좌 : 3 -> 0 (L) +1
		// 하 -> 우 : 1 -> 2 (L) +1
		// 하 -> 좌 : 1 -> 0 (D) +3
		// L : (dir+1)%4
		// D : (dir+3)%4


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());	// 보드
		int K = Integer.parseInt(br.readLine());	// 사과

		boolean[][] board = new boolean[N][N];

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;

			board[x][y] = true; 
		}

		// 뱀의 위치를 담는다.
		//		Queue<Snake> snake_q = new LinkedList<>();
		List<Snake> snake_arr= new ArrayList<>();

		// 방향 전환 정보를 담는다. 
		Queue<Move> move_q = new LinkedList<>();

		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			char c= st.nextToken().charAt(0);
			move_q.add(new Move(x , c));
		}

		int time = 0; // 시간 체크

		int col = 0, row = 0; // 시작좌표
		int dir = 2; // 우측 방향 
		snake_arr.add(new Snake(0,0));

		while(true) {
			time++;

			// 임시 좌표
			int temp_col = col;
			int temp_row = row;

			// 경계 체크 
			if(0>temp_col+deltas[dir][0] || temp_col+deltas[dir][0]>=N 
					|| 0>temp_row+deltas[dir][1] || temp_row+deltas[dir][1]>=N)  {
				System.out.println(time);
				System.exit(0);
			}

			// 임시 좌표 이동
			temp_col += deltas[dir][0];
			temp_row += deltas[dir][1];

			// 자기 몸에 부딪혔는지 체크
			for(int i=0; i<snake_arr.size(); i++) {
				if(snake_arr.get(i).col==temp_col && snake_arr.get(i).row == temp_row) {
					System.out.println(time);
					System.exit(0);
				}
			}
			
			// 만약 사과가 없다면
			if(!board[temp_col][temp_row]) {// 기존에 있던 좌표 빼기
				snake_arr.remove(0);
			}else {
				board[temp_col][temp_row] = false;
			}

			col = temp_col;
			row = temp_row;

			snake_arr.add(new Snake(col,row)); // 뱀 좌표를 넣음

			// 방향 전환 확인
			if(!move_q.isEmpty() && move_q.peek().time_x == time) {
				dir = (move_q.poll().dir_c=='L') ? (dir+1)%4 : (dir+3)%4;
			}
		}
	}
}
