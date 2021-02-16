package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ silver5 1158 요세푸스 문제
public class B1158_요세푸스문제 {

	static int N, K;
	static Queue<Integer> que = new LinkedList<>();
//	static LinkedList<Integer> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// que에 1번부터 N번까지 넣기
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		// 큐가 빌때까지 K번째 사람 뽑아내기
		while (!que.isEmpty()) {
			// K-1번까지 큐에서 뽑았다가 다시 넣기
			for (int i = 0; i < K - 1; i++) {
				que.add(que.poll());
			}
			
			//K번째 뽑아내기
			sb.append(que.poll()).append(", ");
		}
		
		// 마지막 , 지우기
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
	
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		sb.append("<");
//
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//
//		// que에 1번부터 N번까지 넣기
//		for (int i = 1; i <= N; i++) {
//			list.add(i);
//		}
//
//		// 큐가 빌때까지 K번째 사람 뽑아내기
//		int idx = 0;
//		while (!list.isEmpty()) {
//			idx = (idx+K-1)%list.size();
//			
//			sb.append(list.remove(idx)).append(", ");
//		}
//		
//		// 마지막 , 지우기
//		sb.setLength(sb.length()-2);
//		sb.append(">");
//		System.out.println(sb.toString());
//	}
}