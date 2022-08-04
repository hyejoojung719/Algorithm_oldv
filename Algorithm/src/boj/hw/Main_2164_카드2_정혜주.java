package boj.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2_정혜주 {
	public static void main(String[] args) throws Exception{
		
		// 먼저 놓은게 먼저 나가는 구조 = 큐
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(true) {
			
			if(q.size()==1) break;
			
			q.poll();
			int last = q.poll();
			q.add(last);
		}
		
		System.out.println(q.peek());
		
	}
}
