package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14395_4연산 {
	static long s, t;
	static List<Long> visited = new ArrayList<>(); 

	static class Proc{
		long num;
		String rec="";
		public Proc(long num, String rec) {
			super();
			this.num = num;
			this.rec = rec;
		}

	}

	private static void bfs() {
		Queue<Proc> q = new LinkedList<>();
		q.offer(new Proc(s, ""));
		visited.add(s);

		while(!q.isEmpty()) {
			long num = q.peek().num;
			String record = q.poll().rec;


			if(num==t) {
				System.out.println(record);
				System.exit(0);
			}

			for(int x=0; x<4; x++) {
				long result=0;
				if(x==0) {
					// 곱셈
					result = num * num;
				}else if(x==1) {
					// 덧셈
					result = num + num;
				}else if(x==2) {
					// 뺄셈
					result = num - num;
				}else {
					// 나눗셉
					if(num>0) {
						result = num / num;
					}
				}

				
				if(result<=0) continue;
				
				if(!visited.contains(result)) {
					if(x==0) q.offer(new Proc(result, record + "*"));
					else if(x==1) q.offer(new Proc(result, record + "+"));
					else if(x==2) q.offer(new Proc(result, record + "-"));
					else q.offer(new Proc(result, record + "/"));

					visited.add(result);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		// 정수 s의 값을 t로 바꾸는 최소 연산 횟수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		// s와 t가 같으면 0, 바꿀 수 없으면 -1
		if(s==t) System.out.println(0);
		else {
			bfs();
			System.out.println(-1);
		}

	}
}
