package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A -> B
public class Main_16953_AB_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1; // 1을 더해서 출력해야하니까
		
		while(A<B) {
			if(B%2 == 0) {
				B /= 2; 
			}else if(B%10 == 1) {
				B /= 10;
			}else {
				System.out.println("-1");
				System.exit(0);
			}
			cnt++;
		}
		
		if(A>B) {
			System.out.println(-1);
			System.exit(0);
		}
		
		System.out.println(cnt);
		
		br.close();
		
		
	}
}
