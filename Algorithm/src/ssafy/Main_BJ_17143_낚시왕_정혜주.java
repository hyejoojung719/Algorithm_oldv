package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시왕_정혜주 {
	static int R, C, M;
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}}; // 상 하 우 좌 
	static int[][] sea;
	static int ans;
	static List<Shark> sharks = new ArrayList<>();;
	
	static class Shark{
		int row;
		int col;
		int velocity;
		int dir;
		int size;
		public Shark(int row, int col, int velocity, int dir, int size) {
			super();
			this.row = row;
			this.col = col;
			this.velocity = velocity;
			this.dir = dir;
			this.size = size;
		}
	}
	
	private static void move() {
		for(int i=0; i<M; i++) {
			Shark shark = sharks.get(i);
			int row = shark.row;
			int col = shark.col;
			int vel = shark.velocity;
			int dir = shark.dir;
			
			for(int j=0; j<vel; j++) {
				int mrow = row + deltas[dir-1][0];
				int mcol = col + deltas[dir-1][1];
				
				if(mrow<0 || mcol<0 || mrow>=R || mcol>=C) {
//					dir
				}else {
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// input
		// R C M
		// M개의 줄에 상어 정보 주어짐
		// (r,c) , s(속력)->초당 이동하는 칸 수, d(이동방향), z(크기)
		// 경계 넘어가면 방향을 반대로 바꾸고 이동
		// 한칸에 상어가 두 마리 이상 있게 되면 가장 큰 상어가 나머지 상어 다 잡아먹음
		
		// 낚시왕이 잡은 상어 크기의 합?
		
		sea = new int[R+1][C+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());	// 행
			int c = Integer.parseInt(st.nextToken());	// 열
			int v = Integer.parseInt(st.nextToken());	// 속도
			int d = Integer.parseInt(st.nextToken());	// 이동 방형
			int s = Integer.parseInt(st.nextToken());	// 크기
			
			sea[r][c]++;
			
			sharks.add(new Shark(r,c,v,d,s));
		}
		
		
		// 낚시왕 이동이 먼저
		for (int i = 1; i <= C; i++) {
			// 열의 수 만큼 반복
			for(int j=0; j<M; j++) {
				
			}
		}
		
	}
}
