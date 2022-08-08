package swea.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1_정혜주 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=1; i++) {
			int code_length = Integer.parseInt(br.readLine()); 	// 암호문 길이
			
			LinkedList<Integer> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<code_length; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int com_cnt = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<10; j++) {
				System.out.print(list.get(i)+" ");
			}
			
			for(int j=0; j<com_cnt; j++) {
				String insert = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				System.out.println(x + " " + y);
				for(int k=0; k<y; k++) {
					list.add(x++, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#"+i+" ");
			for(int j=0; j<10; j++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}
