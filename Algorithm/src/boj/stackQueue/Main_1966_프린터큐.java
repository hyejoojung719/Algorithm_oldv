package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	
	static class Paper{
		int index;
		int priority;
		
		Paper(int index, int priority){
			this.index = index;
			this.priority = priority;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			Queue<Paper> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			int index = 0;
			for(int j=0; j<N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				arr[j] = priority;
				q.offer(new Paper(index++, priority));
			}
			
			Arrays.sort(arr);
			
			
			int idx = N-1, cnt=0;
			while(idx>=0) {
				
				
				if(arr[idx]==q.peek().priority) {
					if(q.peek().index == M) {
						q.poll(); 
						cnt++;
						break;
					}else {
						idx--;
						q.poll();
						cnt++;
					}
				}else q.offer(q.poll());
				
			}
			System.out.println(cnt);
		}
		
	}
}
