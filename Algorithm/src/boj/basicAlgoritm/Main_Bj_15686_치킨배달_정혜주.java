package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Bj_15686_치킨배달_정혜주 {
	
	static int M;
	static int[][] chicken;
	static int[][] home;
	static int[][] chick_result;
	static int result = Integer.MAX_VALUE;
	
	// 1. 치킨 집 중 M개 뽑기 -> 조합
	public static void com(int cnt, int start, int[][] chick_result) {
		
		if(cnt == M) {
			// 경우의 수들 중 한 개의 조합이 나왔을 떄 
			
			// 2. 그 M개의 치킨집의 치킨 거리를 구함
			int total = 0;
			for(int i=0; i<home.length; i++) {
				int answer = Integer.MAX_VALUE; 
				for(int j=0; j<chick_result.length; j++) {
					int sum = Math.abs(home[i][0]-chick_result[j][0])
						+ Math.abs(home[i][1]-chick_result[j][1]);
					answer = Math.min(sum, answer);
				}
				total += answer;
			}
			
			result = Math.min(result, total);
			
			return;
		}
		
		for(int i=start; i<chicken.length ;i++) {
			chick_result[cnt][0] = chicken[i][0];
			chick_result[cnt][1] = chicken[i][1];
			com(cnt+1, start+1, chick_result);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		// N*N
		// 치킨 거리  : 집과 가장 가까운 치킨집 사이 거리
			// (r1,c1)~(r2,c2) = |r1-r2| + |c1-c2|
		// 도시의 치킨 거리 : 모든 집의 치킨 거리 합
		
		// 폐업 시키지 않을 치킨집 최대 M개를 고르고, 도시의 치킨 거리가 가장 작은 경우 구하기
		// M : 가장 수익 을 많이 낼 수 있는 치킨집 개수 -> 최대한 집과의 거리가 가까워야함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int homeCnt=0, chickenCnt=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				// 1이 있는 곳을 찾으면 int[][] home에 좌표값 담기위해 카운트
				if(input==1) {
					homeCnt++;
				}
				// 2가 있는 곳을 찾으면 int[][] chicken에 좌표값 담기위해 카운트
				else if(input ==2){
					chickenCnt++;
				}
			}
		}
		
//		 우 좌
		int[] delRow = {0,0};	// 행
		int[] delCol = {1,-1};	// 열

		int row=0, col=0, dir=0;
		
		home = new int[homeCnt][2];
		chicken = new int[chickenCnt][2];
		
		int homeIdx=0, chickIndex=0, visit=0;
		while(true) {
			
			if(visit>=N*N) break;
			
			if(0<=row && row<N && 0<=col && col<N) {
				visit++;
				if(map[row][col] == 1) {
					home[homeIdx][0] = row;
					home[homeIdx][1] = col;
					homeIdx++;
				}else if(map[row][col] == 2){
					chicken[chickIndex][0] = row;
					chicken[chickIndex][1] = col;
					chickIndex++;
				}
				
			}
			
			if(0<=row+delRow[dir] && row+delRow[dir]<N 
					&& 0<=col+delCol[dir] && col+delCol[dir]<N) {
				
				row+=delRow[dir];
				col+=delCol[dir];
			}else {
				row++;
				dir = (dir+1)%2;
			}
		}
		// home 배열과 chicken배열에 좌표들 넣음...
		
		// 1. 치킨집 중 M개를 뽑음
		chick_result = new int[M][2];
		com(0, 0, chick_result);
		
		System.out.println(result);
		
	
	}
	

}
