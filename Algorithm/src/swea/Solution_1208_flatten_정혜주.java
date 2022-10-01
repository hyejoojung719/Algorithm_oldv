package swea;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_flatten_정혜주 {
	
	static private final int X = 100;
	static private int[] arr = new int[X];
//	static private int cnt;
	
	public static void recursion(int num) {
		
		if(num==0) {
			return;
		}else {
			arr[0]++;
			arr[X-1]--;
			Arrays.sort(arr);
			recursion(num-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int cnt = sc.nextInt();
			
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			recursion(cnt);
			/*
			for(int i=0; i<cnt; i++) {
				arr[0]++;
				arr[X-1]--;
				Arrays.sort(arr);
			}*/
			
			System.out.println("#" + tc + " " + (arr[X-1]-arr[0]));
			
		}
		
	}
}
