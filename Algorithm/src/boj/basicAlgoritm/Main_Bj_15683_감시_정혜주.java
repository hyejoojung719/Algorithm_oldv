package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj_15683_감시_정혜주 {
	static int N,M;
	static int[][] room;
	static int zero_cnt, cctv_cnt;
	static Queue<CCTV> q = new LinkedList<>();
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상,우, 하, 좌
	static int [][][] sel_del = {
			{},
			{{0},{1}, {2}, {3}},	// 1번 - up, right, down, left
			{{0,2}, {1,3}},	// 2번 - up & down, left & right
			{{0,1}, {0,3}, {2,1}, {2,3}},	// 3번 - up & right, up & left, down & right, down & left 
			{{0,1,3}, {2,1,3}, {0,1,2}, {0,3,2}},	// 4번 - u & r & l, d & r & l, u & r & d, u & l & d
			{{0,1,2,3}}	//5번 - u & r & l & d
	};
	//sel_del[2][0] : 
	static boolean[][] isVisited;

	public static class CCTV{
		int num;
		int row;
		int col;
		int watch_range;
		int dir;

		public CCTV(int num, int row, int col, int watch_range, int dir) {
			super();
			this.num = num;
			this.row = row;
			this.col = col;
			this.watch_range = watch_range;
			this.dir = dir;
		}

	}

	public static void watchCount(int num) {

		CCTV ct = q.poll();

		if(num==1) {
			int max_watch=Integer.MIN_VALUE;
			int size = sel_del[num].length;
			for(int i=0; i<size; i++) {
				int watch_cnt = 0;

				if(i==0) {
					watch_cnt = up(ct);
				}else if(i==1) {
					watch_cnt = right(ct);
				}else if(i==2) {
					watch_cnt = down(ct);
				}else if(i==3) {
					watch_cnt = left(ct);
				}

				if(max_watch < watch_cnt) {
					max_watch = watch_cnt;
					ct.dir = i;
					ct.watch_range = max_watch;
				}
			}
			q.offer(ct);
		}else if(num==2) {
			int max_watch=Integer.MIN_VALUE;
			int size = sel_del[num].length;
			for(int i=0; i<size; i++) {
				int watch_cnt = 0;

				if(i==0) {
					watch_cnt = up(ct)+down(ct);
				}else if(i==1) {
					watch_cnt = left(ct)+right(ct);
				}

				if(max_watch < watch_cnt) {
					max_watch = watch_cnt;
					ct.dir = i;
					ct.watch_range = max_watch;
				}
			}
			q.offer(ct);
		}else if(num==3) {
			int max_watch=Integer.MIN_VALUE;
			int size = sel_del[num].length;
			for(int i=0; i<size; i++) {
				int watch_cnt = 0;

				if(i==0) {
					watch_cnt = up(ct)+right(ct);
				}else if(i==1) {
					watch_cnt = up(ct)+left(ct);
				}else if(i==2) {
					watch_cnt = down(ct)+right(ct);
				}else if(i==3) {
					watch_cnt = down(ct)+left(ct);
				}

				if(max_watch < watch_cnt) {
					max_watch = watch_cnt;
					ct.dir = i;
					ct.watch_range = max_watch;
				}
			}
			q.offer(ct);
		}else if(num==4) {
			int max_watch=Integer.MIN_VALUE;
			int size = sel_del[num].length;
			for(int i=0; i<size; i++) {
				int watch_cnt = 0;

				if(i==0) {
					watch_cnt = up(ct)+right(ct)+left(ct);
				}else if(i==1) {
					watch_cnt = down(ct)+right(ct)+left(ct);
				}else if(i==2) {
					watch_cnt = up(ct)+right(ct)+down(ct);
				}else if(i==3) {
					watch_cnt = up(ct)+left(ct)+down(ct);
				}

				if(max_watch < watch_cnt) {
					max_watch = watch_cnt;
					ct.dir = i;
					ct.watch_range = max_watch;
				}
			}
			q.offer(ct);
		}else if(num==5) {
			int max_watch=up(ct)+right(ct)+down(ct)+left(ct);
			ct.watch_range = max_watch;
			q.offer(ct);
		}
	}

	public static int up(CCTV ct) {
		isVisited[ct.row][ct.col] = true;
		
		int mrow = ct.row+deltas[0][0];
		int mcol = ct.col+deltas[0][1];
		int watch_cnt=0;

		while(true) {
			if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
			if(room[mrow][mcol]==0 && !isVisited[mrow][mcol]) watch_cnt++; isVisited[mrow][mcol]=true;
			
			mrow += deltas[0][0];
			mcol += deltas[0][1];
		}

		return watch_cnt;
	}

	public static int right(CCTV ct) {
		int mrow = ct.row+deltas[1][0];
		int mcol = ct.col+deltas[1][1];
		int watch_cnt=0;

		while(true) {
			if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
			if(room[mrow][mcol]==0 && !isVisited[mrow][mcol]) watch_cnt++; isVisited[mrow][mcol]=true;
			
			mrow += deltas[1][0];
			mcol += deltas[1][1];
		}

		return watch_cnt;
	}


	public static int down(CCTV ct) {
		int mrow = ct.row+deltas[2][0];
		int mcol = ct.col+deltas[2][1];
		int watch_cnt=0;

		while(true) {
			if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
			if(room[mrow][mcol]==0 && !isVisited[mrow][mcol]) watch_cnt++; isVisited[mrow][mcol]=true;
			
			mrow += deltas[2][0];
			mcol += deltas[2][1];
		}

		return watch_cnt;
	}

	public static int left(CCTV ct) {
		int mrow = ct.row+deltas[3][0];
		int mcol = ct.col+deltas[3][1];
		int watch_cnt=0;

		while(true) {
			
			if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
			if(room[mrow][mcol]==0 && !isVisited[mrow][mcol]) watch_cnt++; isVisited[mrow][mcol]=true;
			
			mrow += deltas[3][0];
			mcol += deltas[3][1];
		}

		return watch_cnt;
	}
	
	public static void blindSpot(CCTV ct) {
		int answer = 0;
		for(int i=0; i<q.size(); i++) {
			int num = q.peek().num;
			watchCount(num);
		}
	}

	public static void main(String[] args) throws Exception{
		// 1. cctv 위치 파악 & 0인 갯수 카운트(zero_cnt)
		// 2. 큐에 cctv 위치 담기 -> cctv 클래스 만들기..?
		// cctv 번호, 좌표, 감시범위(초기값 0)
		// 3. 큐에서 하나씩 꺼내면서 감시 범위 카운트 = watch_cnt
		// cctv 별로 watch_cnt 최대값 갱신... = max_watch
		// 최대값일 때 감시범위를 담은 인스턴스를 다시 큐에 담기
		// 4.  cctv 마다 사각지대 계산 끝나면, 이제 다시 큐에서 꺼내면서 방문여부 체크하면서 감시범위 카운트
		// 다음 cctv가 방문한 곳을 지날 때 겹치는 구간이므로  overlap 변수 +1
		// 5. 최종적으로 zero_cnt에서 감시범위를 뺀다(Overlap만큼 더해줌)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				room[i][j] = input;

				if(input==0) zero_cnt++;	// 뚫린 공간 카운트
				if(input!=0 && input!=6) {
					// cctv라면 큐에 해당 cctv 정보 담기
					q.offer(new CCTV(input, i, j , 0, 0));
					cctv_cnt++; // cctv개수 계산
				}
			}
		}

		for(int i=0; i<cctv_cnt; i++) {
			int num = q.peek().num;
			isVisited = new boolean[N][M];
			watchCount(num);
		}

		isVisited = new boolean[N][M];
		for(CCTV ct : q) {
			blindSpot(ct);
		}
		
		int answer=0;
		for(CCTV ct : q) {
			answer += ct.watch_range;
		}

		System.out.println(answer);
	}
}
