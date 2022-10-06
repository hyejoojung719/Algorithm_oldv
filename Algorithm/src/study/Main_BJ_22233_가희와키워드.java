package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_22233_가희와키워드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
        
        for (int i = 0; i < M; i++) {
        	 st = new StringTokenizer(br.readLine(), ",");
        	 while(st.hasMoreTokens()) {
        		 String str = st.nextToken();
        		 if(set.contains(str)) {
        			 set.remove(str);
        			 N--;
        		 }
        	 }
        	 System.out.println(N);
		}
	}
}
