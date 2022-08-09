package boj.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1_정혜주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 하  우  상 좌
		int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};

		st = new StringTokenizer(br.readLine(), " ");

		// 배열 크기 N*M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 회전 수 R
		int R = Integer.parseInt(st.nextToken());


		Queue<Integer> q = new LinkedList<>();

		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int x=0, y=0, dir=0, cycle=0;
		int temp_N=N, temp_M=M;
		int K = Math.min(N, M);
		for(int i=0; i<K/2; i++) {

			
			// 큐에 담기
			for(int j=0; j<temp_N*2+(temp_M-2)*2; j++) {

				q.add(arr[x][y]);

				if(cycle>x+deltas[dir][0] || x+deltas[dir][0]>=N-1*cycle
						|| cycle>y+deltas[dir][1] || y+deltas[dir][1]>=M-1*cycle) {
					// 경계를 벗어나면 방향을 바꿔준다
					dir = (dir+1)%4;
				}
				x=x+deltas[dir][0];
				y=y+deltas[dir][1];

			}

			// 회전후 시작포인트 지정
			for(int j=0; j<R; j++) {
				
				if(cycle>x+deltas[dir][0] || x+deltas[dir][0]>=N-1*cycle
						|| cycle>y+deltas[dir][1] || y+deltas[dir][1]>=M-1*cycle) {
					dir = (dir+1)%4;
				}

				x+=deltas[dir][0]; 
				y+=deltas[dir][1];
			}

			
			for(int j=0; j<temp_N*2+(temp_M-2)*2; j++) {

				if(!q.isEmpty()) arr[x][y]=q.poll();

				if(cycle>x+deltas[dir][0] || x+deltas[dir][0]>=N-1*cycle
						|| cycle>y+deltas[dir][1] || y+deltas[dir][1]>=M-1*cycle) {
					// 경계를 벗어나면 방향을 바꿔준다
					dir = (dir+1)%4;
				}

				x=x+deltas[dir][0];
				y=y+deltas[dir][1];
			}
			

			temp_N = temp_N-2;
			temp_M = temp_M-2; 

			dir=0;
			cycle++;
			x = cycle;
			y = cycle ;


			q.clear();


		}

		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}






	}
}
