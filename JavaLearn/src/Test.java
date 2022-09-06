
public class Test {

	static int[] numbers = new int[6];
	static boolean[] isVisited = new boolean[7];
	
	// 중복 순열
	public static void perm1(int cnt) {
		
		if(cnt==3) {
			return;
		}
		
		for(int i=1; i<=6; i++) {
			numbers[cnt] = i;
			perm1(cnt+1);
		}
	}
	
	// 순열
	public static void perm2(int cnt) {
		
		if(cnt==3) return;
		
		for(int i=1; i<=6; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			numbers[cnt] = i;
			perm2(cnt+1);
			isVisited[i] = false;
		}
	}
	
	// 중복 조합
	public static void comb1(int cnt, int start) {
		
		if(cnt==3) return; 
		
		for(int i=start; i<=6; i++) {
			numbers[cnt] = i;
			comb1(cnt+1, i);
		}
	}
	
	// 조합
	public static void comb(int cnt, int start) {
		
		if(cnt==3) return;
		
		for(int i=start; i<=6; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	// 부분집합
	public static void subSet(int index) {
		if(index==6) return;
		
		isVisited[index]=true;
		subSet(index+1);
		isVisited[index]=false;
		subSet(index+1);
		
	}
	
	// 비트마스킹 순열
	public static void perm3(int cnt, int flag) {
		
		if(cnt==3) return;
		
		for(int i=1; i<=6; i++) {
			
			if((flag & (1<<i)) != 0) continue;
			numbers[cnt] = i;
			perm3(cnt+1, flag | (1<<i));
		}
	}
	
	static int[] arr = {1,2,3,4,5};
	static int N = 5;
	
	static void swap (int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	// NP 순열 = nPn -> do while문 사용
	public static boolean perm4() {
		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(i-1, j);
		
		int k=N-1;
		while(i<k) swap(i++, k--);
		
		return true;
	}
	
	//NP 조합
	public static boolean com3(int[] arr) {
		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(i-1, j);
		
		int k=N-1;
		while(i<k) swap(i++, k--);
		
		return true;
	}
	
//	public static void main(String[] args) {
//		int[] isSelected = new int[N];
//		for(int i=0; i<3; i++) {
//			isSelected[N-i-1] = 1;
//		}
//		
//		do {
//			for(int i=0; i<N; i++) {
//				if(isSelected[i]==1) System.out.print(arr[i]);
//			}
//			System.out.println();
//		}while(com3(isSelected));
//	}
	
	//부분집합 바이너리 카운팅
	public static void subSet2() {
		
		for(int flag=0; flag<(1<<N); flag++) {
			for(int i=0; i<N; i++) {
				if((flag & (1<<i))!=0) System.out.print(arr[i]);
			}
		}
	}
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) return this.start-o.start;
			else return this.end-o.end;
		}
	}
	
	public static void main(String[] args) {
		int targetMoney = 800;
		int[] units = {500,100,50,10,5,1};
		int[] coints = {10,8,15,30,20,5};
		
		int totalMoney=0;
		for(int i=0; i<units.length; i++) {
			totalMoney += units[i]*coints[i];
		}
		
		int remainMoney = totalMoney - targetMoney;
		
		int sum=0, maxCnt, availCnt;
		for(int i=0; i<units.length; i++) {
			// 최대 동전 수
			maxCnt = remainMoney/units[i];
			
			// 최대 동전 수가 현재 갖고있는 동전수보다 작거나 같으면 이용할 동전수는 최대 동전수
			// 크다면 이용할 동전수는 현재 갖고있는 동전수
			if(maxCnt <= coints[i]) {
				availCnt = maxCnt;
			}else availCnt = coints[i];
			
			// 현재 갖고 있는 동전수 - 이용한 동전수
			coints[i] -= availCnt;
			
			// 남은 돈 = 이용한 동전수 * 단위
			remainMoney -= units[i]*availCnt;
			
			// 사용한 동전 합계
			sum += coints[i];
		}
	}
}
