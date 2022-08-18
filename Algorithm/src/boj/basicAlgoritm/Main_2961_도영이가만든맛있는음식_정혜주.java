package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식_정혜주 {
	
	static boolean[] check;
	static int[] sArr, bArr;
	static int answer = Integer.MAX_VALUE;
	
	private static void subSet(int cnt) {
		if(cnt == check.length) {
			// 공집합 제외 
			int falseCnt = 0;
			for(int i=0; i<cnt; i++) {
				if(!check[i]) falseCnt++;
			}
			if(falseCnt != cnt) {
				int diff = taste(check);
				answer = Math.min(diff, answer);
			}
			
			return;
		}
		
		check[cnt]=true;
		subSet(cnt+1);
		
		check[cnt]=false;
		subSet(cnt+1);
	}
	
	private static int taste(boolean[] check) {
		
		int size=check.length;
		
		int sTaste=1, bTaste=0;
		for(int i=0; i<size; i++) {
			if(check[i]) {
				sTaste *= sArr[i];
				bTaste += bArr[i];
			}
		}
		int diff = Math.abs(sTaste-bTaste);
		return diff;
	}
	
	// 1. 부분 집합(공집합 제외) 구하기
	// 2. 부분집합 구할 때마다 boolean값에 해당 index -> true로 설정
	// 3. 신맛, 쓴맛 차이 구하는 메소드 구현해서 호출
	// 4. 해당 메소드 결과값으로 max_min 값 갱신
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sArr = new int[N];
		bArr = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sArr[i] = Integer.parseInt(st.nextToken());
			bArr[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new boolean[N];
		subSet(0);
		System.out.println(answer);
	}
}
