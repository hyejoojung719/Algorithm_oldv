package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_정혜주2 {
	static int n,m;
	static LinkedList<Node> linked_list;
	
	static class Node{
		int data;
		int link;
		public Node(int data, int link) {
			super();
			this.data = data;
			this.link = link;
		}
	}
	
//	public static int findSet(int set1, int set2) {
//	}
//	
	public static void main(String[] args) throws Exception{
		// 0 : 집합 합치기
		// 1 : 같은 집합인지 확인 -> 결과값 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			linked_list = new LinkedList<>();
			linked_list.add(new Node(0, 0));
			for(int i=1; i<=n; i++) {
				linked_list.add(new Node(i, i));
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cal = Integer.parseInt(st.nextToken());
				int set1 = Integer.parseInt(st.nextToken());
				int set2 = Integer.parseInt(st.nextToken());
				
				if(cal==1) {
//					findSet(set1, set2);
				}else {
					linked_list.set(set2, new Node(set2,set1));
				}
			}
			
			System.out.println("#"+tc+" ");
			
		}
	}
}
