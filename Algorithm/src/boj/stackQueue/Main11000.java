package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11000 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] clas = new int[N][2];
		for(int i=0; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<2; j++) {
				clas[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번쨰 원소 기준 오름차순 (시작 시간 동일하면 종료 시간 오름차순)
		Arrays.sort(clas, (e1, e2) ->{
			if(e1[0]== e2[0]) return e1[1]-e2[1];
			else return e1[0]-e2[0];
		});
		
		Queue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<clas.length; i++) {
			q.add(clas[i][1]); // 종료시간 큐에 추가
		}
		
		int cnt = 1;
		if(N==1) { // 수업이 1개일 떄는...
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i=1; i<N; i++) {
			if(clas[i][0] < q.peek()) {
				cnt++;
				System.out.println(cnt);
			}else if(clas[i][0] >= q.peek()){
				q.poll();
			}
		}
		
		System.out.println(cnt);
	}
}
