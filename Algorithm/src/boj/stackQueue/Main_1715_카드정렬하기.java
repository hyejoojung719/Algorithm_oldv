package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 Integer타입은 는 기본적으로 오름차순
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		
		int sum =0;
		while(q.size()>1) {
			int card1 = q.poll();
			int card2 = q.poll();
			
			sum+=card1 + card2;
			q.add(card1 + card2);
		}
		
		System.out.println(sum);
	}
}
