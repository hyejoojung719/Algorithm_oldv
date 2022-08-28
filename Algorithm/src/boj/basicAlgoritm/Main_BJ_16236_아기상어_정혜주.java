package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 풀이 참고함
public class Main_BJ_16236_아기상어_정혜주 {
	static int[][] deltas = {{-1,0}, {0,-1}, {1,0}, {0,1}};	// 상 좌 하 우
	static int N;
	static int[][] map;
	static int[][] distAndVisitCheck;
	static int shark_size=2;
	static int minRow, minCol;
	static int minDist;

	public static void play(int row, int col) {
		Queue<int[] > q = new LinkedList<>();
		q.offer(new int[] {row, col});

		while(!q.isEmpty()) {
			int trow = q.peek()[0];
			int tcol = q.poll()[1];

			for(int dir=0; dir<4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];

				if(0<=mrow && mrow<N && 0<=mcol && mcol<N) {
					if(canMove(mrow, mcol) && distAndVisitCheck[mrow][mcol]==0) {
						distAndVisitCheck[mrow][mcol] = distAndVisitCheck[trow][tcol] + 1;
						
						if(edibleCheck(mrow, mcol)) {
							if(minDist > distAndVisitCheck[mrow][mcol]) {
								minDist = distAndVisitCheck[mrow][mcol];
								minRow = mrow;
								minCol = mcol;
							}else if(minDist == distAndVisitCheck[mrow][mcol]) {
								// 거리 같을 떄 비교
								if(minRow == mrow) {
									if(minCol > mcol) {
										minRow = mrow;
										minCol = mcol;
									}
								}else if(minRow > mrow) {
									minRow = mrow;
									minCol = mcol;
								}
							}
						}
						
						q.offer(new int[] {mrow, mcol});
					}
				}
			}

		}
	}

	public static boolean canMove(int row, int col) {
		boolean answer = false;

		if(map[row][col] <= shark_size) answer = true;

		return answer;
	}

	public static boolean edibleCheck(int row, int col) {
		boolean answer = false;

		if(0<map[row][col] && map[row][col] < shark_size) answer = true;

		return answer;
	}

	public static void main(String[] args) throws Exception{
		// input : N
		// input : map -> 9 아기상어, 0 빈칸, 1~6 물고기 크기
		// 아기 상어가 엄마 상어에게 도움 요청하지 않고 물고기 잡아먹을 수 있는 시간

		// 초기 크기 : 2
		// 자기 자신보다 작은 물고기만 먹고 통과 가능
		// 같은 크기는 못 먹지만 통과 가능
		// 가장 가까운 물고기 먹으러 감 -> 상, 좌 우선
		// 자신의 크기만큼 먹어야 크기 1 증가

		// 크기+1 위해 먹어야하는 마리수
		// 크기  2	3	4	5	6	7..
		// 개수  2	3	4	5	6	7..

		// 1. 상어가 돌아다니면서 주변 체크 -> 상 좌 우선으로 / bfs로 돌림
		// 2. 이때 체크 할 것
		// - 먹을 수 있는 물고기 인지
		// - 먹을 수 없지만 크기가 같아 통과할 수 있는 애인지
		// - 그냥 0인지
		// canMove 메소드를 호출해서 먼저 이동하려는 곳이 이동 할 수 있는지 체크 -> 이동할 수 있다면 큐에 담기
		// 이동 했다면 만약 거기에 물고기가 있다면  먹기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int row=0, col=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 9) {
					row = i; col = j; map[i][j]=0;
				}
			}
		}
		
		int eat_cnt=0;
		int time=0;
		while(true) {
			distAndVisitCheck = new int[N][N];
			minRow = Integer.MAX_VALUE;
			minCol = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
			
			play(row, col);
			
			if(minRow != Integer.MAX_VALUE && minCol != Integer.MAX_VALUE) {
				eat_cnt++;
				map[minRow][minCol] = 0;
				row = minRow;
				col = minCol;
				time += distAndVisitCheck[minRow][minCol];
				
				if(eat_cnt == shark_size) {
					shark_size++;
					eat_cnt=0;
				}
			}else break;
		}

		System.out.println(time);
	}
}
