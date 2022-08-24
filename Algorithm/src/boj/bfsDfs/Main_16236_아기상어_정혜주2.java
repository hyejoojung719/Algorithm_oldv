package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_정혜주2 {
	static int[][] deltas = {{-1,0}, {0,-1}, {1,0}, {0,1}};	// 상 좌 하 우
	static int N;
	static int[][] map;
	static int shark_size;
	static boolean[][] visited;
	static List<int[]> edible_fish;

	public static void findFish(int row, int col) {
		Queue<int[] > q = new LinkedList<>();
		edible_fish = new ArrayList<int[]>();
		q.offer(new int[] {row, col});
		visited[row][col]=true;
		
		while(!q.isEmpty()) {
			int trow = q.peek()[0];
			int tcol = q.poll()[1];
			
			for(int dir=0; dir<4; dir++) {
				int mrow = trow + deltas[dir][0];
				int mcol = tcol + deltas[dir][1];
				
				if(0<=mrow && mrow<N && 0<=mcol && mcol<N) {
					if(!visited[mrow][mcol] && map[mrow][mcol]==0) {
						q.offer(new int[] {mrow, mcol});
					}
					
					if(map[mrow][mcol] < shark_size) {
						// 먹을 수 있는 물고기 발견하면
						int dis = Math.abs(row-mrow) + Math.abs(col-mcol);
						edible_fish.add(new int[] {mrow, mcol, dis});
					}
				}
			}
		}
	}
	
	public static void disCompare(int row, int col) {
		
		// 오름차순 정렬
		Comparator<int[]> com = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		};
		
		int idx=0;
		for(int i=0, size = edible_fish.size()-1; i<size; i++) {		
			if(edible_fish.get(i)[2] != edible_fish.get(i)[2]) {
				idx = i;
				break;
			}
		}
		
		
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
		
		// 1. 먹을 수 있는 물고기들 좌표찾기
				// bfs로 0인 애들 주변에 상어 사이즈보다 작은 애들 찾기(찾으면 리스트에 넣기)
		// 2. 리스트에 담긴 물고기들과 거리 비교 
				// 가장 가까운 애 먹으러 가기
				// 같은 애들이 여러 개 라면 row가 상어 보다 작은 값 -> 그래도 같으면 col 비교
		// 3. 먹은 물고기 개수 카운트 => 상어 사이즈와 같아지면 +1, 개수 카운트 값은 = 0
		
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
					row = i; col = j;
				}
			}
		}
		
		shark_size = 2;
		visited = new boolean[N][N];
		findFish(row, col);
		
	}
}
