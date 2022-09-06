package learn0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {
	static int N; 	// 정점의 개수 0~N-1

	static int[][] adjMatrix; // 인접 행렬

	static boolean[] visited;	//트리에 포함된 정점 true

	static int[] minEdge; 	// 현재까지의 트리에서 해당 정점까지의 최소 비용

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		// 인접 행렬 정보 입력
		adjMatrix = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		minEdge = new int[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);	// minEdge 제일 큰 값으로 초기화
		
		int result = getMST();
		
		System.out.println(result);
	}
	
	// 최소 신장 트리 비용 반환 메소드
	private static int getMST() {
		int result = 0; // 최소 신장 트리 비용
		int cnt = 0 ;	// 선택한 정점 수 
		
		// 임의의 정점 하나를 선택하기(시작 정점)
		minEdge[0] = 0;
		
		while(cnt < N) {
			// step 01. 현재 트리에 포함되지 않은 정점 중 최소 비용인 정점을 선택 
			int min = Integer.MAX_VALUE;
			int minV = -1; 	// 최소 비용을 가진 정점의 번호
			for(int i=0; i<N; i++) {
				if(!visited[i] && minEdge[i] < min)// 방문한 적 없고 최소 비용을 가진다면
				{
					min = minEdge[i];	// 최소값 갱신
					minV = i;	// 최소값을 가진 정점 번호 저장
				}
			}
			
			// 선택한 정점 방문 체크, 간선 비용 누적
			visited[minV] = true;
			result += min;
			cnt++; 	// 선택한 정점 개수 카운트
			
			// step 02. 선택한 정점 정보를 통해  minEdge 갱신
			for (int to = 0; to < N; to++) {
				if(!visited[to] && adjMatrix[minV][to]!=0 &&minEdge[to] > adjMatrix[minV][to]) {
					// 가중치가 0이 아닌 경우는 제외해야함
					minEdge[to] = adjMatrix[minV][to];
				}
			}
		}
		
		return result;
	}
}
