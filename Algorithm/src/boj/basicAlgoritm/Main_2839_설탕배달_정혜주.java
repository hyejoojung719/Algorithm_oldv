package boj.basicAlgoritm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_설탕배달_정혜주 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nKg = Integer.parseInt(br.readLine());
		
		int cnt = -1;
		if(nKg%5%3==0) {
			cnt = nKg/5;
			cnt += nKg%5/3;
		}else {
			for(int i=nKg/5; i>=0; i--) {
				// 큰 것부터 차례대로 
				int rm = nKg - 5*i;
				if(rm%3!=0) continue;
				else {
					cnt = i+rm/3;
					break; // break문을 안걸면 틀림
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
