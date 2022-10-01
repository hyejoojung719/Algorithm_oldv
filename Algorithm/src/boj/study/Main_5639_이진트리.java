package boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5639_이진트리 {
	static StringBuilder sb = new StringBuilder();
	
	// 노드 클래스 
	static class Node{
		Node left=null;
		Node right=null;
		int root;
		public Node(int root) {
			this.root = root;
		}
	}

	private static void insert(int node, Node tree) {
		
		if(node < tree.root) {
			// 루트 노드보다 입력 노드가 작으면 왼쪽 서브트리에 추가
			if(tree.left==null) {
				tree.left =  new Node(node);
			}else {
				// 왼쪽 노드가 이미 노드가 존재한다면 재귀 호출
				insert(node, tree.left);
			}
		}else {
			// 루트 노드보다 입력노드가 더 크면 오른쪽 서브트리에 추가
			if(tree.right==null) {
				tree.right =  new Node(node);
			}else {
				insert(node, tree.right);
			}
		}
	}
	
	private static void post(Node tree) {
		if(tree == null) return;
		post(tree.left);
		post(tree.right);
		sb.append(tree.root+"\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int root = Integer.parseInt(br.readLine()); // 최상위 루트 노드 입력 받기
		
		Node parent =  new Node(root);
		String input="";
		while(true) {
			input = br.readLine();
//			if(input.equals("")) break;
			if(input==null) break; // null 체크
			insert(Integer.parseInt(input), parent);
		}
		
		post(parent);
		System.out.println(sb);
	}
}
