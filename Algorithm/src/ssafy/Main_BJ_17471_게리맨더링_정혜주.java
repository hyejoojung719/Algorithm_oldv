package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17471_게리맨더링_정혜주 {
	static int N;
	static Point[] arr;
	static int ans=Integer.MAX_VALUE;
	static boolean[] selected;
	static boolean[] visited;
	static List<Integer> area1;
	static List<Integer> area2;
	static boolean flag;
	static int flag2=0;
	
	
	static class Point{
		int idx;
		int people;
		List<Integer> linked = null;
		public Point(int idx, int people, List<Integer> linked) {
			super();
			this.idx = idx;
			this.people = people;
			this.linked = linked;
		}
	}
	
	// 구역 나누기 - 부분집합
	static void sub(int index) {
		if(index==N) {
			area1 = new ArrayList<>();
			area2 = new ArrayList<>();
			flag = true;
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					area1.add(arr[i+1].idx);
				}else {
					area2.add(arr[i+1].idx);
				}
			}
			
			
			int cnt1=0, cnt2=0;
			if(area1.size()!=0 && area2.size()!=0) {
				
				int idx1 = area1.get(0);
				int idx2 = area2.get(0);
				visited = new boolean[N+1];
				visited[0] = true;
				cnt1 = bfs(idx1,area1);
				cnt2 = bfs(idx2,area2);
				
				for (boolean x : visited) {
					if(!x) {
						flag=false;
					}
				}
				
				if(flag) {
					
					flag2++;
					ans = Math.min(ans, Math.abs(cnt1-cnt2));
				}
			}
			
			return;
		}
		
		selected[index]=true;
		sub(index+1);
		selected[index]=false;
		sub(index+1);
	}
	
	static int bfs(int idx, List<Integer> area) {
		int cnt=arr[idx].people;
		Queue<Point> q = new LinkedList<>();
		q.offer(arr[idx]);
		visited[idx] = true;
		
		int size = area.size();
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int i=1; i<=N; i++) {
				for(int j=0; j<temp.linked.size(); j++) {
					if(!visited[i]&& area.contains(i) && temp.linked.get(j)==i) {
						cnt += arr[i].people;
						visited[i] = true;
						q.offer(arr[i]);
					}
				}
			}
		}
		
		return cnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// op :두 선거구의 인구 차이 최소
		
		// ip
		// N : 구역 개수
		// 1~N 까지 인구수
		// N개의 줄에서 인접한 구역 수 + 인접한 구역 번호
		
		// 구역 나눌 때 체크할 것
		
		// 1. 최소 1~(N-1)의 부분집합
		// 2. 서로 연결  되어 있는지(bfs)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new Point[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = new Point(i, input, new ArrayList<>());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int idx = Integer.parseInt(st.nextToken());
				arr[i].linked.add(idx);
			}
		}
		
		selected = new boolean[N];
		sub(0);
		
		if(flag2==0) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
	}
	
}
