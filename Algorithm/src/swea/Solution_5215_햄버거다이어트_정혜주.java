package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분집합 -> 시간복잡도 : 2^N -> 2^20 따라서 부분집합 가능하다
// 1. 햄버거 재료 모든 부분집합 구하기
// 2. 총 칼로리, 총 점수 구하기
// 3. 제한 칼로리 L이하이고, 총 점수 최대값이면 갱신 
public class Solution_5215_햄버거다이어트_정혜주 {

	// 민기의 햄버거 재료 점수
	// 재료 칼로리

	// 민기가 칼로리 이하에 좋아하는 햄버거를 조합
	// 같은 재료 X

	// 2차원 배열 [0] : 점수, [1] : 칼로리
	// 조합할 때마다 칼로리를 합하고 -> 칼로리가 1000이하인 애들만 따로 뺴기
	// 거기서 선호도 합하고, 그 중 가장 큰 선호도 구하기

	static int max_kcal, n;
	static int[] kcal;
	static int[] score;
	static int answer = 0;

	// r값이 한가지로 고정이 아님... 
	public static void com(int[][] food, int r , int cnt, int start, int[] kcal, int[] score) {

		if(cnt == r) {
			int kcal_sum=0;
			for(int i=0; i<kcal.length; i++) {
				kcal_sum += kcal[i];
			}
			
			if(kcal_sum<= max_kcal) {
				
				int score_sum=0;
				for(int i=0; i<score.length; i++) {
					score_sum += score[i];
				}
				
				answer = Math.max(score_sum, answer);
			}

			return;
		}

		for(int i=start; i<n; i++) {
			kcal[cnt] = food[i][1];
			score[cnt] = food[i][0];
			com(food, r, cnt+1, i+1, kcal, score);
		}
	}



	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			max_kcal = Integer.parseInt(st.nextToken());
			answer = 0;
			
			int[][] food = new int[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}

			
			for(int r=0; r<=n; r++) {
				kcal = new int[r];
				score = new int[r];
				com(food, r, 0, 0, kcal, score);
			}
			
			System.out.println("#" + tc +  " " + answer);
		}
	}
}
