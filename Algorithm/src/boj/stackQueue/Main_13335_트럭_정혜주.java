package boj.stackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭_정혜주 {
	public static void main(String[] args) throws IOException {

		// n 개의 트럭
		// 트럭 순서 바꿀 수 없음
		// 트럭의 무게 서로 다를수도 같을수도
		// 다리 위에는 W대까지만 동시에 올라갈 수 있음
		// 무게는 L(다리무게)보다 작거나 같을 것
		// 다리 길이 = w단위 길이
		// 하나의 단위 시간에 하나의 단위 길이만큼 이동 가능

		// 최단 시간??

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int truck_n = Integer.parseInt(st.nextToken());
		int length_w = Integer.parseInt(st.nextToken());
		int bridgeWeight_l = Integer.parseInt(st.nextToken());

		Queue<Integer> truck_q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<truck_n; i++) {
			truck_q.offer(Integer.parseInt(st.nextToken()));
		}

		// q.poll() 하나 하고 q.peek() 하고 둘이 합 한게 다리 하중 넘기는지 체크
		// 넘기면 하나만 빼고 아니면 안 넘길 때까지 빼기

		// 트럭이 나가면서 빈 무게가 다음 트럭이들어올 수 있는 경우도 생각해야함 
		Queue<Integer> time_q = new LinkedList<>();

		int time=2;
		int weight=0;
		int check = 1;
		weight = truck_q.peek();
		time_q.add(truck_q.poll());
		while(!time_q.isEmpty()) {
			if(!truck_q.isEmpty() && check < length_w
					&& weight + truck_q.peek() <= bridgeWeight_l) {
				weight += truck_q.peek(); 
				time_q.offer(truck_q.poll());
				check++;
				time++;
			}else if(check < length_w){
				time_q.offer(0);
				check++;
				time++;
			}
			
			// 시간 측정을 위한 큐가 다리길이만큼 트럭이 꽉차면 하나 뺴주고 그 무게를 전체 무게에서 빼줌
			if(check==length_w) {
				weight -= time_q.poll();
				check--;
			}
			
			if(truck_q.size()==0 && time_q.size()<=1 && time_q.peek()==0) {
				time_q.poll();
			}
			
		}

		System.out.println(time);


	}
}
