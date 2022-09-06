package etc.learn0727.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest02 {

		public static void main(String[] args) {
			
			String[][] str = {{"a", "b", "f"}, {"a", "e", "f"}};
			
			// 해당 배열을 1차원 배열로 
			Stream<String[]> stream = Arrays.stream(str);
			
//			 List<String> list = stream
//			.flatMap(arr -> Arrays.stream(arr))//각각을 stream으로 쪼개기
//			.distinct() // 중복된 값 제거하고 싶을 떄, equals로 비교해서 같은 객체로 판단
//			.peek(System.out::println)
////			.forEach(System.out::println);
//			.collect(Collectors.toList());
//			 System.out.println(list);
			
			 Optional<String> opt = stream
						.flatMap(arr -> Arrays.stream(arr))
						.max((a,b)->a.compareTo(b));
			 
			 // 값이 존재하는지 체크
			 if(opt.isPresent()) {
				 // 값 추출
				 String maxStr = opt.get();
				 System.out.println(maxStr);
			 }
			

		}
}
