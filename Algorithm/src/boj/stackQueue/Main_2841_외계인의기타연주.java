package boj.stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main_2841_외계인의기타연주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Stack<Integer>[] stack_arr = new Stack[N+1];
		for(int i=0; i<N+1; i++) stack_arr[i] = new Stack<>();

		int cnt = 0;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int sound = Integer.parseInt(st.nextToken());
			int flat = Integer.parseInt(st.nextToken());

			while(!stack_arr[sound].isEmpty() 
					&& stack_arr[sound].peek() > flat) {
				stack_arr[sound].pop();
				cnt++;
			}
			
			if(!stack_arr[sound].isEmpty() 
					&& stack_arr[sound].peek() == flat) continue; //플랫을 이미 누른 상태
			
			cnt++;
			stack_arr[sound].push(flat);

			
		}

		System.out.println(cnt);
	}
}
