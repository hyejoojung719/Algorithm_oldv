package algoConcept;

public class DisJointSet_서로소집합 {
	static int[] parent;
	static int[] rank;
	public static void main(String[] args) {
		// 교집합이 없기 때문에 대표자를 통해 각 집합 구분..
		parent = new int[10];
		rank = new int[parent.length];
		
		// Make-Set
		for(int i=0; i<6; i++) {
			makeSet(i);
		}
		// Find-Set
		// Union
	}
	
	//Make_Set(x) : 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산
	public static void makeSet(int x) {
		parent[x] = x; 
	}
	
	//Find_Set(x) : x를 포함하는 집합을 찾는 연산(해당 노드의 부모 정보 갱신)
	public static int findSet(int x) {
		if(x == parent[x]) return x; 
		else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	
	//Union(x,y) : x와 y를 포함하는 두 집합을 통합하는 연산
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px != py) parent[py] = px;
	}
}
