package boj.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_정혜주 {
	
	static int N, K;
	static boolean[] isVisited = new boolean[100001];
	static int time;
	
	public static void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		isVisited[N] = true;
		q.offer(N);
		
		
		while(true) {
			int size = q.size();
			time++;
			for(int i=0; i<size; i++) {
				int temp = q.poll();
				int t_result=0;
				for(int j=1; j<=3; j++) {
					
					if(j==1) {
						t_result = temp-1;
					}else if(j==2) {
						t_result = temp+1;
					}else if(j==3) {
						t_result = temp*2;
					}
					
					if(t_result == K) {
						return;
					}
					else if(0<=t_result 
							&& t_result<=100000/*계산된 값이 100000을 넘어갈수도 있음,,*/
							&& !isVisited[t_result]) {
						q.offer(t_result);
						isVisited[t_result]=true;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N  = Integer.parseInt(st.nextToken());
		K  = Integer.parseInt(st.nextToken());
		
		if(N==K) System.out.println(0);
		else {
			bfs(N);
			System.out.println(time);
		}
	}
}
