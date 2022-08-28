package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_이모티콘_정혜주2 {
	static boolean[][] isVisited = new boolean[1001][1001];
	static int S;

	public static class Emozi{
		int clipboard;
		int screen;

		public Emozi(int clipboard, int screen) {
			super();
			this.clipboard = clipboard;
			this.screen = screen;
		}

	}

	public static void bfs(int s) {
		Queue<Emozi> q = new LinkedList<>();
		q.offer(new Emozi(0,1));
		isVisited[0][1] = true;

		int time=0;
		
		while(!q.isEmpty()) {

			int depth = q.size();

			for(int i=0; i<depth; i++) {
				Emozi temp = q.poll();

				if(temp.screen == S) {
					System.out.println(time); 
					System.exit(0);
				}
				
				//1. 클립보드에 복사
				if(temp.screen != temp.clipboard) {
					q.offer(new Emozi(temp.screen, temp.screen));
				}

				//2. 붙여 넣기
				//조건 : 클립보드 비어있으면 안 됨 + S를 넘으면 안 됨 + 방문 한 적 없는 곳
				if(temp.clipboard!=0 &&  temp.screen + temp.clipboard <= S 
						&& !isVisited[temp.clipboard][temp.screen+temp.clipboard] ) {
					q.offer(new Emozi(temp.clipboard, temp.screen + temp.clipboard));
					isVisited[temp.clipboard][temp.screen+temp.clipboard] = true;
				}

				//3. 화면에서 한 개 삭제
				// 삭제 했을 때 0개 이상일 것 + 방문 한 적 없는 곳
				if(temp.screen-1>=0 && !isVisited[temp.clipboard][temp.screen-1] ) {
					q.offer(new Emozi(temp.clipboard, temp.screen-1));
					isVisited[temp.clipboard][temp.screen-1] = true;
				}
			}
			time++;
		}
		
	}


	// 2차원 배열 -> [화면 이모티콘 수][클립보드 이모티콘 수] -> 얘네를 각각 노드로하고 
	// bfs로 연산만다 구현하고 갱신해서 큐에 넣고 돌린다. -> S 가 될 때까지 (BFS -> 최단 거리)
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 화면에 있는 이모티콘 모두 복사해서 클립보드 저장
		// 2. 클립보드에 있는 모든 이모티콘 붙여넣기
		// 3. 이모티콘 하나 삭제

		// 기본적으로 화면에 1개 입력 되어 있음
		// 최소 시간 출력 = 연산 개수 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());

		bfs(S);

	}
}
