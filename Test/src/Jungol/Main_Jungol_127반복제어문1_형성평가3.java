package Jungol;

import java.util.Scanner;

public class Main_Jungol_127�ݺ����1_������3 {
	// ����.. 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num=0;
		int sum=0;
		int cnt=0;
		while(true) {
			num = sc.nextInt();
			
			if(num>100) break;
			
			sum += num;
			cnt++;
		}
		
		System.out.println("sum : " + sum);
		System.out.println(String.format("avg : %.1f", (double)sum/cnt));
	}
}
