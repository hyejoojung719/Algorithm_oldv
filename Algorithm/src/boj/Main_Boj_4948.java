package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_Boj_4948 {
	public static ArrayList<Integer> cnt = new ArrayList<>();
	public static boolean[] prime;
	public static void get_prime(int num) {
		prime = new boolean[2*num+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i*i <= 2*num; i++) {
			for(int j=2*i ; j<=2*num; j+=i) prime[j] = true;
		}
		
		int count=0;
		for(int i=num+1; i<=2*num; i++) {
			if(!prime[i]) {
				count++;
			}
		}
		cnt.add(count);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int num = sc.nextInt();
			if(num==0) {
				break;
			}
			get_prime(num);
		}
		
		for(int i=0; i<cnt.size(); i++) {
			System.out.println(cnt.get(i));
		}
	}
}
