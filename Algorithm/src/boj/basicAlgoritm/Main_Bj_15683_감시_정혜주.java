//package boj.basicAlgoritm;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_Bj_15683_감시_정혜주 {
//	static int N,M;
//	static int[][] room;
//	static int zero_cnt, cctv_cnt;
//	static Queue<CCTV> q = new LinkedList<>();
//	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상,우, 하, 좌
//	static boolean[] isOverlap;
//
//	public static class CCTV{
//		int num;
//		int row;
//		int col;
//		int watch_range;
//		int dir;
//
//		public CCTV(int num, int row, int col, int watch_range, int dir) {
//			super();
//			this.num = num;
//			this.row = row;
//			this.col = col;
//			this.watch_range = watch_range;
//			this.dir = dir;
//		}
//
//	}
//
//	public static void watchMaxCnt(int num) {
//		int max_watch=0;
//
//		CCTV cctv = q.poll();
//
//		switch (num) {
//		case 1:
//			// 1번 cctv
//			max_watch = cctv1(cctv);
//			break;
//		case 2:
//			// 2번 cctv
//			max_watch = cctv2(cctv);
//			break;
//		case 3:
//			// 3번 cctv
//			max_watch = cctv3(cctv);
//			break;
//		case 4:
//			// 4번 cctv
//			max_watch = cctv4(cctv);
//			break;
//		case 5:
//			// 5번 cctv
//			max_watch = cctv5(cctv);
//			break;
//		}
//	}
//	
//	public static int cctv1(CCTV ct) {	// 상 하 좌 우
//		int max_watch = Integer.MIN_VALUE;
//		
//		for(int  dir=0; dir<4; dir++) {
//			int mrow = ct.row+deltas[dir][0];
//			int mcol = ct.col+deltas[dir][1];
//			int watch_cnt=0;
//			
//			while(true) {
//				// 경계를 만나거나, 벽(6)을 만나면 break
//				if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
//				
//				if(room[mrow][mcol]==0)watch_cnt++;
//			}
//			
//			if(max_watch < watch_cnt) {
//				max_watch = watch_cnt;
//				ct.watch_range = max_watch;
//				ct.dir = dir;
//			}
//		}
//		
//		
//		q.offer(ct);
//		return max_watch;
//	}
//	
//	public static int cctv2(CCTV ct) {	// 상하 , 좌우
//		int max_watch = Integer.MIN_VALUE;
//		int watch_cnt_odd=0;	// 좌(3), 우(1)
//		int watch_cnt_even=0;	// 상(0), 하(2)
//		
//		for(int  dir=0; dir<4; dir++) {	
//			int mrow = ct.row+deltas[dir][0];
//			int mcol = ct.col+deltas[dir][1];
//			
//			while(true) {
//				// 경계를 만나거나, 벽(6)을 만나면 break
//				if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
//				
//				if(dir%2==0 && room[mrow][mcol]==0) watch_cnt_even++;
//				else if(room[mrow][mcol]==0) watch_cnt_odd++;
//			}
//		}
//		
//		if(watch_cnt_even < watch_cnt_odd) {
//			max_watch = watch_cnt_odd;
//			ct.watch_range = max_watch;
//			ct.dir = dir;
//		}else {
//			
//		}
//		
//		max_watch = Math.max(watch_cnt_even, watch_cnt_odd);
//		ct.watch_range = max_watch;
//		q.offer(ct);
//		return max_watch;
//	}
//	
//	public static int cctv3(CCTV ct) {	// 상우, 우하, 좌하, 좌상  01, 12, 23, 30 
//		int max_watch = Integer.MIN_VALUE;
//		int watch_cnt_up=0;
//		int watch_cnt_down=0;
//		int watch_cnt_left=0;
//		int watch_cnt_right=0;
//		Queue<Integer> tq = new LinkedList<>();
//		
//		for(int  dir=0; dir<4; dir++) {	// 0 : 상, 1 : 우, 2: 하, 3 : 좌
//			int mrow = ct.row+deltas[dir][0];
//			int mcol = ct.col+deltas[dir][1];
//			
//			while(true) {
//				// 경계를 만나거나, 벽(6)을 만나면 break
//				if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
//				
//				if(room[mrow][mcol]==0 && dir==0) {
//					watch_cnt_up++;
//				}else if(room[mrow][mcol]==0 && dir==1) {
//					watch_cnt_right++;
//				}else if(room[mrow][mcol]==0 && dir==2) {
//					watch_cnt_down++;
//				}else if(room[mrow][mcol]==0 && dir==3) {
//					watch_cnt_left++;
//				}
//			}
//		}
//		
//		int watch1 = watch_cnt_up + watch_cnt_right;
//		tq.offer(watch1);
//		int watch2 = watch_cnt_right + watch_cnt_down;
//		tq.offer(watch2);
//		int watch3 = watch_cnt_left + watch_cnt_down;
//		tq.offer(watch3);
//		int watch4 = watch_cnt_left + watch_cnt_up;
//		tq.offer(watch4);
//		
//		for(int x : tq) max_watch = Math.max(max_watch, tq.poll());
//		ct.watch_range = max_watch;
//		q.offer(ct);
//		
//		return max_watch;
//	}
//	
//	public static int cctv4(CCTV ct) {	
//		int max_watch = Integer.MIN_VALUE;
//		int whole_watch=0;
//		int watch_cnt_up=0;
//		int watch_cnt_down=0;
//		int watch_cnt_left=0;
//		int watch_cnt_right=0;
//		Queue<Integer> tq = new LinkedList<>();
//		
//		for(int  dir=0; dir<4; dir++) {	// 0 : 상, 1 : 우, 2: 하, 3 : 좌
//			int mrow = ct.row+deltas[dir][0];
//			int mcol = ct.col+deltas[dir][1];
//			
//			while(true) {
//				// 경계를 만나거나, 벽(6)을 만나면 break
//				if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
//				
//				if(room[mrow][mcol]==0) whole_watch++;
//				
//				if(room[mrow][mcol]==0 && dir==0) {
//					watch_cnt_up++;
//				}else if(room[mrow][mcol]==0 && dir==1) {
//					watch_cnt_right++;
//				}else if(room[mrow][mcol]==0 && dir==2) {
//					watch_cnt_down++;
//				}else if(room[mrow][mcol]==0 && dir==3) {
//					watch_cnt_left++;
//				}
//			}
//		}
//		
//		int watch1 = whole_watch - watch_cnt_up;
//		tq.offer(watch1);
//		int watch2 = whole_watch - watch_cnt_right;
//		tq.offer(watch2);
//		int watch3 = whole_watch - watch_cnt_down;
//		tq.offer(watch3);
//		int watch4 =whole_watch - watch_cnt_left;
//		tq.offer(watch4);
//		
//		for(int x : tq) max_watch = Math.max(max_watch, tq.poll());
//		ct.watch_range = max_watch;
//		q.offer(ct);
//		
//		return max_watch;
//	}
//	
//	public static int cctv5(CCTV ct) {	
//		int whole_watch=0;
//		
//		for(int  dir=0; dir<4; dir++) {	// 0 : 상, 1 : 우, 2: 하, 3 : 좌
//			int mrow = ct.row+deltas[dir][0];
//			int mcol = ct.col+deltas[dir][1];
//			
//			while(true) {
//				// 경계를 만나거나, 벽(6)을 만나면 break
//				if(mrow<0 || mrow>N || mcol<0 || mcol>M || room[mrow][mcol]==6) break;
//				
//				if(room[mrow][mcol]==0) whole_watch++;
//			}
//		}
//		
//		ct.watch_range = whole_watch;
//		q.offer(ct);
//		return whole_watch;
//	}
//	
//	public static int blindCnt() {
//		CCTV ct = q.poll();
//	
//		
//	}
//
//	public static void main(String[] args) throws Exception{
//		// 1. cctv 위치 파악 & 0인 갯수 카운트(zero_cnt)
//		// 2. 큐에 cctv 위치 담기 -> cctv 클래스 만들기..?
//		// cctv 번호, 좌표, 감시범위(초기값 0)
//		// 3. 큐에서 하나씩 꺼내면서 감시 범위 카운트 = watch_cnt
//		// cctv 별로 watch_cnt 최대값 갱신... = max_watch
//		// 최대값일 때 감시범위를 담은 인스턴스를 다시 큐에 담기
//		// 4.  cctv 마다 사각지대 계산 끝나면, 이제 다시 큐에서 꺼내면서 방문여부 체크하면서 감시범위 카운트
//		// 다음 cctv가 방문한 곳을 지날 때 겹치는 구간이므로  overlap 변수 +1
//		// 5. 최종적으로 zero_cnt에서 감시범위를 뺀다(Overlap만큼 더해줌)
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine(), " ");
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//
//		room = new int[N][M];
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for (int j = 0; j < M; j++) {
//				int input = Integer.parseInt(st.nextToken());
//				room[i][j] = input;
//
//				if(input==0) zero_cnt++;	// 뚫린 공간 카운트
//				if(input!=0 && input!=6) {
//					// cctv라면 큐에 해당 cctv 정보 담기
//					q.offer(new CCTV(input, i, j , 0, 0));
//					cctv_cnt++; // cctv개수 계산
//				}
//			}
//		}
//
//		for(int i=0; i<cctv_cnt; i++) {
//			int num = q.peek().num;
//			watchMaxCnt(num);
//		}
//		
//		isOverlap = new boolean[cctv_cnt];
//		blindCnt();
//		
//		
//
//	}
//}
