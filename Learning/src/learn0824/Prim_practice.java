package learn0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim_practice {
	// 정점 개수 
	static int N;
	
	// 인접 행렬 
	static int[][] adjMatrix;
	
	// 트리에 포함된 정점 true
	static boolean[] visited; 
	
	// 현재까지의 트리에서 해당 정점까지의 최소 비용
	static int[] minEdge; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		// 인접행렬 정보 입력
		adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		minEdge = new int[N];
		// 최대값으로 채워주기
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int result = getMST();
		System.out.println(result);
		
	}
	
	// 최소 신장 트리 비용 반환 메소드
	private static int getMST() {
		int result = 0; 	// 최소 비용 총합
		int cnt = 0; //선택된 정점  개수 
		
		// 임의  정점 선택(시작)
		minEdge[0] = 0;
		
		while(cnt < N) {
			//1. 현재 트리에 포함되지 않은 정점 선택
			int min = Integer.MAX_VALUE;
			int minV = -1;	// 최소 비용 가진 정점 
			for (int i = 0; i < N; i++) {
				// 방문 X, 최소비용
				if(!visited[i] && min > minEdge[i])
				{
					min = minEdge[i];
					minV = i;
				}
			}
			
			// 방문 체크, 비용누적, 카운트 ++
			visited[minV] = true;
			result += min;
			cnt++;
			
			//2. 선택된 정점 정보 기반으로 minEdge 갱신
			for (int to = 0; to < N; to++) {
				// 방문 X, 0이 아니고, minEdge보다 작은것만
				if(!visited[to] && adjMatrix[minV][to] !=0 && minEdge[to] > adjMatrix[minV][to]) {
					minEdge[to] = adjMatrix[minV][to];
				}
			}
		}
		
		return result;
	}
}
