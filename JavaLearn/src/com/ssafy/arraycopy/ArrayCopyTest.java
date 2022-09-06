package com.ssafy.arraycopy;

import java.util.Arrays;

public class ArrayCopyTest {
	public static void main(String[] args) {
		
		int[] arr1 = {0, 1, 2, 3, 4, 5};
		int[] arr2 = {5, 10, 15, 20, 25, 30};
		
		// 얕은 복사 (shallowCopy) -> 참조 변수만 복사한 것!!!
		int[] shallowCopy = arr1;
		System.out.println(Arrays.toString(shallowCopy));
		
		arr1[0] = 200;
		System.out.println(Arrays.toString(shallowCopy));
		
		// 깊은 복사 (deepCopy)
		int[] deepCopy = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(deepCopy));
		
		arr1[1] = 100;
		System.out.println(Arrays.toString(deepCopy));
		
		int[] deepCopy2 = arr1.clone(); // 결국에는 똑같은 객체 참조
		
		// 2, 3, 4를 복사하고싶으면
		int[] deepCopy3 = Arrays.copyOfRange(arr1, 2, 5);
		System.out.println(Arrays.toString(deepCopy3));
		
		// 2, 3, 4를 10, 15, 20 위치에 복사하려면
		System.arraycopy(arr1, 2, arr2, 1, 3 );
		System.out.println(Arrays.toString(arr2));
		
	}
}
