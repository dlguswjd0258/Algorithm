/**
* 메모리: 41788 KB, 시간: 544 ms
* 2021.12.17
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
오름차순인 우선순위 큐랑
내림차순인 우선순위 큐에
반반 숫자를 넣으면서
내림차순에는 작은 숫자들을 넣어 놓는다.
 */
public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> asc = new PriorityQueue<>(); // 오름차순
		PriorityQueue<Integer> desc = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(asc.size() == desc.size()) {
				desc.offer(num);
			}else {
				asc.offer(num);
			}
			
            // 더 작은 숫자를 desc에 담기 위한 while
			while(!asc.isEmpty() && asc.peek() < desc.peek()) {
				int temp = asc.poll();
				asc.offer(desc.poll());
				desc.offer(temp);
			}
			
			sb.append(desc.peek()).append("\n");
		}

		System.out.println(sb.toString());
	}
}