/**
* 메모리: 11620 KB, 시간: 80 ms
* 2021.12.31
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, del, root;
	static List<Integer>[] nodes;

	public static void main(String[] args) throws Exception {
		init();

		// 루트가 지워지면 아무것도 없음
		if (del == root) {
			System.out.println(0);
			return;
		}

		System.out.println(getLeafNode(nodes[root]));
	}

	private static int getLeafNode(List<Integer> node) {
		// 리프노드라면 1 리턴
		if (node.isEmpty()) {
			return 1;
		}

		int sum = 0;
		for (int son : node) {
			sum += getLeafNode(nodes[son]);
		}

		return sum;

	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// 초기화
		nodes = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		del = Integer.parseInt(in.readLine());
		
		// 트리 연결
		for (int i = 0; i < N; i++) {
			int parents = Integer.parseInt(st.nextToken());
			if (parents < 0) {
				root = i;
				continue;
			}
			
			// 지울 노드는 연결하지 않기
			if(i == del) {
				continue;
			}

			nodes[parents].add(i);
		}

	}

}