
public class SubsetBinaryCounting {
	static int[] arr = {1,2,3,4,5};
//	static boolean[] isSelected = new boolean[arr.length];
	
//	private static void subSet(int cnt) {
//		
//		if(cnt == arr.length) {
//			for(int i=0; i<arr.length; i++) {
//				if(isSelected[i]) System.out.print(arr[i]+" ");
//			}
//			System.out.println();
//			return;
//		}
//		
//		isSelected[cnt] = true;
//		subSet(cnt+1);
//		
//		isSelected[cnt] = false;
//		subSet(cnt+1);
//	}
	
	public static void main(String[] args) {
		
		int n = arr.length;
		
		for(int i=0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if( (i & (1<<j)) != 0) System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
}
