package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_정혜주 {
	static int N, com_row, com_col, home_row, home_col;
	static int[][] visit_points;
	static boolean[] isSelected;
	static int[] index;
	static List<int []> list;
	static int answer;
	
	public static void perm(int cnt) {
		
		if(cnt==N) {
			list = new ArrayList<>();
			
			list.add(new int[] {com_row, com_col});
			for(int i=0; i<N; i++) {
				list.add(new int[] {visit_points[index[i]][0], visit_points[index[i]][1]});
			}
			list.add(new int[] { home_row, home_col});
			
			answer = Math.min(answer, disCal());
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			index[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static int disCal() {
		int size = list.size();
		int dis = 0;
		for(int i=1, point=0; i<size; i++, point++) {
			dis += Math.abs(list.get(point)[0]-list.get(i)[0]) + Math.abs(list.get(point)[1]-list.get(i)[1]);
		}
		return dis;
	}
	
	public static void main(String[] args) throws Exception{
		// N명의 고객을 모두 방문하고 집으로 돌아가는 경로 중 가장 짧은 것 -> 거리 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			com_row = Integer.parseInt(st.nextToken());
			com_col = Integer.parseInt(st.nextToken());
			
			home_row = Integer.parseInt(st.nextToken());
			home_col = Integer.parseInt(st.nextToken());
			
			visit_points = new int[N][2];
			for(int i=0; i<N; i++) {
				visit_points[i][0] = Integer.parseInt(st.nextToken());
				visit_points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			isSelected = new boolean[N];
			index  = new int[N];
			perm(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
