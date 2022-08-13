package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_정혜주 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());	// 가로
		int N = Integer.parseInt(st.nextToken());	// 세로
	
		int[][] box = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		int zeroTomato=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
		
				if(tomato == 1) {
					q.offer(new int[] {i, j});
				}else if(tomato == 0) {
					zeroTomato++;
				}
			}
		}
		
		// 상 우 하 좌
		int[] delRow = {-1,0,1,0};
		int[] delCol = {0,1,0,-1};
		int dir = 0, cnt = 0;
		while(!q.isEmpty() && zeroTomato > 0) {
			cnt++;
			for(int i=q.size(); i>0; i--) {
				int[] info = q.poll();
				
				for(int j=0; j<4; j++) {
					int mrow = info[0]+delRow[dir];
					int mcol = info[1]+delCol[dir];
					
					// 만약 경계를 넘지 않고 주변에 0이라면
					if(0<=mrow  && mrow <N && 0<=mcol && mcol<M
							&& box[mrow][mcol]==0) {
						// 1로 바꿔준다. 
						box[mrow][mcol] = 1;
						q.add(new int[] {mrow, mcol});
						zeroTomato--;
					}
					// 방향 바꾸기
					dir = (dir+1)%4;
				}
			}
		}
		
		if(zeroTomato > 0) System.out.println(-1);
		else System.out.println(cnt);
		
		
		
		
	}
}
