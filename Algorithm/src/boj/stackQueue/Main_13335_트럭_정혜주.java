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
		for (int i = 0; i < length_w; i++) {
			time_q.offer(0); // 0 0
		}
		
		int time=0;
		int cur_length = 0;
		int check;
		
		while(!time_q.isEmpty()) {
			while (!truck_q.isEmpty()) {
				check = truck_q.peek();
				cur_length += check - time_q.poll();
				if (cur_length > bridgeWeight_l ) {
					time_q.offer(0);
					cur_length -= check;
				} else {
					time_q.offer(check);
					truck_q.poll();
				}
				time++;
			}
			time++;
			time_q.poll();
			
		}

		System.out.println(time);
	}
}
