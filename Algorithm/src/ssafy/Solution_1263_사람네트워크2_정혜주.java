package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_정혜주 {
	static final int INF = 9999999;
	static int N,distance[][];
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			distance = new int[N][N];

			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && distance[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						distance[i][j]=INF;
					}
				}
			}

			// 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
			// 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j=0; j<N; ++j) {
						if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(distance[i][j] > distance[i][k]+distance[k][j]) {
							distance[i][j] = distance[i][k]+distance[k][j];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int sum=0;
				for (int j = 0; j < N; j++) {
					sum += distance[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb);
	}
}
