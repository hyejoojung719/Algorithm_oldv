package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18428_감시피하기 {
	static int N;
	static char[][] map;
	static char[][] copyMap;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};	// 상, 하, 좌, 우
	static List<Point> teachers = new ArrayList<>();	// 선생님 좌표
	static List<Point> objects = new ArrayList<>();
	static boolean[] selected;
	static boolean[][] visited;
	static boolean ans = false;
	
	static class Point {
		int row;
		int col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// N*N 크기 복도
		// 상 하 좌우 감시
		// 장애물 있으면 선생님이 볼 수 없다. 
		// T : 선생님, S : 학생, O : 장애물
		
		// 3개의 장애물 설치 -> 모든 학생들을 감시로부터 피할 수 있는지 계산
		// 가능하면 YES, 불가능하면 No 출력

		// 상하좌우 탐색 -> S만나면 안 됨
		// 빈 공간 -> 조합?? 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				
				if(map[i][j]=='T') {
					teachers.add(new Point(i,j));
				}else if(map[i][j]=='X') {
					objects.add(new Point(i,j));
				}
			}
		}
		
		selected = new boolean[objects.size()];
		comb(0,0);
		if(!ans) System.out.println("NO");
	}
	
	// 조합으로 
	private static void comb(int cnt, int start) {
		if(cnt==3) {
			
			copyMap = new char[N][N];
			for(int i=0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
//			for(char[] x : copyMap) {
//				for(char y : x) {
//					System.out.print(y + " ");
//				}
//				System.out.println();
//			}
			int objectsCnt=0;
			for (int i = 0, size = objects.size(); i < size; i++) {
				if(objectsCnt==3) break;
				if(selected[i]) {
					copyMap[objects.get(i).row][objects.get(i).col]='O';
					objectsCnt++;
				}
			}
			ans = watch(); 
			if(ans) {
				System.out.println("YES");
				System.exit(0);
			}
			
			return;
		}
		
		for(int i=start, size=objects.size(); i<size; i++) {
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}
	
	// 장애물 체크
	private static boolean watch() {
		
		boolean ans=true;
		
		f : for(int i=0,size=teachers.size(); i<size; i++) {
			int row = teachers.get(i).row;
			int col = teachers.get(i).col;
			
			
			for(int dir=0; dir<4; dir++) {
				while(true) {
					int mRow = row + deltas[dir][0];
					int mCol = col + deltas[dir][1];
					
					if(mRow<0 || mCol<0 || mRow>=N || mCol>=N) {
						row = teachers.get(i).row;
						col = teachers.get(i).col;
						break;
					}
					if(copyMap[mRow][mCol]=='S') {
						ans = false;
						break f;
					}
					if(copyMap[mRow][mCol]=='O') {
						row = teachers.get(i).row;
						col = teachers.get(i).col;
						break;
					}
					
					row = mRow;
					col = mCol;
				}
			}
		}
		
		return ans;
	}
	
}
