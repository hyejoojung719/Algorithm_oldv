package etc;

import java.util.Scanner;

public class DailyHomework2029 {
	public static void main(String[] args) {
		// 델타 이용
		
		// 지을 수 있는 가장 긴 다리의 길이
		// n*n 
		// 1 : 섬
		// 0 : 바다
		// 다리는 섬 두개만 연결 가능 (다리 중간에 섬 X)
		// 가로, 세로만 연결
		// 첫 째줄 : n 
		// 둘 째줄 : 지형 정보
		// 섬끼리 붙어있어도 다리 건설 가능
		
		// 길이 = 인덱스 차이
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 조건 1 : 원소가 1일 때 -> 좌우상하 거리 측정 
		// 조건 2 : 경게선 벗어나지 않도록 탐색
		
		
		// 가로, 세로 각각 for문으로해도 좋당!
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					int cnt = 1;
					int tmp = j;
					int tmp2 = i;
					
					
					// 좌
					while(tmp>0 && map[i][tmp-1]==0) {
						tmp--;
						cnt++;
					}
					if(max < cnt) max = cnt;
					cnt = 1;
					
					// 우
					while(tmp<n-1 && map[i][tmp+1]==0) {
						tmp++;
						cnt++; 
					}
					if(max < cnt) max = cnt;
					cnt = 1;
					
					// 상
					while(tmp2>0 && map[tmp2-1][j]==0) {
						tmp2--;
						cnt++; 
					}
					if(max < cnt) max = cnt;
					cnt = 1;
					
					// 하
					while(tmp2<n-1 && map[tmp2+1][j]==0) {
						tmp2++;
						cnt++; 
					}
					if(max < cnt) max = cnt;
				}
			}
		}
		
		System.out.println(max);
	}
}
