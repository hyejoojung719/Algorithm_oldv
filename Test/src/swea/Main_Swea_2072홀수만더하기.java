package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Swea_2072홀수만더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int tmp = 0;
			int sum = 0;
			for(int i=0; i<10; i++) {
				tmp =  Integer.parseInt(st.nextToken());
				if(tmp%2!=0) sum+=tmp;
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
