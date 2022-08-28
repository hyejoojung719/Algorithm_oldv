package AlgoConcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프림연습 {
	static int V; // 정점 개수
	
	static int[][] adjMatrix;	// 인접행렬
	
	static boolean[] visited; 	// 트리에 포함된 정점 true
	
	static int[] minEdge;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		V = Integer.parseInt(br.readLine());
		
		// 인접 행렬 정보 입력
		adjMatrix = new int[V][V];
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[V];
		minEdge = new int[V];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int result = getMST();
		
		System.out.println(result);
	}
	
	private static int getMST() {
		int result = 0;	// MST 비용
		int cnt = 0;	// 선택된 정점 수
		
		// 시작 정점 성택하기
		minEdge[0] = 0;
		
		while(cnt < V) {
			// 1. 현재 트리에 포함되지 않은 정점 중 최소 비용인 정점 선택
			int min = Integer.MAX_VALUE;
			int minV = -1;	// 최소 비용 가진 정점 번호
			
			for(int i=0; i<V; i++) {
				if(!visited[i] && minEdge[i] < min)// 방문한 적 없고 최소 비용 가진다면
				{
					min = minEdge[i];	// 최소값 갱신
					minV = i;	// 최소값 가진 정점 번호 저장
				}
			}
			
			// 선택된 정점 방문 체크, 간선 비용 누적
			visited[minV] = true;
			result += min;
			cnt++;
			
			// 2. 선택한 정점 정보를 통해 minEdge 갱신
			for(int to=0; to<V; to++) {
				if(!visited[to] && adjMatrix[minV][to] != 0
						&& minEdge[to] > adjMatrix[minV][to]) {
					minEdge[to] = adjMatrix[minV][to];
				}
			}
		}
		
		return result;
	}
}
