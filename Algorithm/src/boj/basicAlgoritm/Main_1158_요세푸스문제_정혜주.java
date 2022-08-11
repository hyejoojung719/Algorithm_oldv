package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제_정혜주 {
	public static void main(String[] args) throws IOException {

		// 1번 ~ N번, N명의 사람이 원을 그리면 앉아있음
		// 순서대로 K번째 사람 제거
		// 남은 사람들로 이루어진 원을 따라 반복 ~ N명의 사람이 제거될때까지 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for(int i=1; i<=N; i++) {
			q.offer(i);
		}

		int[] result = new int[N];
		int index = 0;
		int cnt = 0;
		while(q.size()>0) {
			cnt++;
			if(cnt == K) {
				result[index++] = q.poll();
				cnt = 0;
			}else {
				q.offer(q.poll());
			}
		}
		
		sb.append("<"+result[0]);
		for(int i=1; i<N; i++) {
			sb.append(", ").append(result[i]);
		}
		sb.append(">");
		System.out.println(sb);
		
		
	}
}
