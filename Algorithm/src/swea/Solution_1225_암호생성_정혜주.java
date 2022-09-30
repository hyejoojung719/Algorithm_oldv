package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성_정혜주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		
		
		for(int tc=1; tc<=10; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<8; j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int num=1;
			while(true) {
				if(num==6) num=1;
				
				int newNum = q.poll()-num++;
				
				if(newNum<=0) {
					q.offer(0);
					break;
				}else q.offer(newNum);
			}
			
			sb.append("#").append(test_case);
			for(int data : q) {
				sb.append(" ").append(data);
			}
			
			System.out.println(sb);
			
			sb.setLength(0); // sb 초기화
		}
	}

}
