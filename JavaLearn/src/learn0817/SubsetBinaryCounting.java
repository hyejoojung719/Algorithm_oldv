package learn0817;


/*	1이쓴 곳에 보고싶은 수 넣으면 비트로 볼 수 있음
 *    String s = "", s2 = "";
        for (int i = 0; i < Integer.numberOfLeadingZeros(1); i++) s += "0"; // 0을 빈자리 개수만큼 만들어 전진 배치
        s += Integer.toBinaryString(1);
         for (int i = 0; i < 32; i+= 8) s2 += s.substring(i, i + 8) + " ";
        System.out.println(s2);
 * */

/* 비트 쉬프트
 *  for (int num = 1; num <= 5; num++) 
        {
            String s = "", s2 = "";
            for (int i = 0; i < Integer.numberOfLeadingZeros(1<<num); i++) s += "0"; // 0을 빈자리 개수만큼 만들어 전진 배치
            s += Integer.toBinaryString(1<<num);
             for (int i = 0; i < 32; i+= 8) s2 += s.substring(i, i + 8) + " ";
            System.out.println(s2);
        }
 * */
public class SubsetBinaryCounting {
	static int[] arr = {10,11,12,13,14};
	static int N = 5;
	
	public static void main(String[] args) {
		subSet();
	}
	
	private static void subSet() {
		
//		flag - arr 요소의 선택 / 비선택 정보 담고 있음
		for(int flag=0; flag < (1<<N); flag++) {
			// 1<<N -> 100000
//			System.out.printf("%5s%n", Integer.toBinaryString(flag));
			
			for(int j=0; j<N; j++) {
				if((flag & 1<<j) != 0) System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
}
