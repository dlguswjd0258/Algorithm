/**
* 메모리: 36608 KB, 시간: 328 ms
* 2021.12.30
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int num;
		Node parents, left, right;

		public Node(int num, Node parents) {
			this.num = num;
			this.parents = parents;
		}
	}

	static int N, preorder[], inorder[];
	static Node[] nodes;
	static StringBuilder sb;
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringBuilder res = new StringBuilder();
		while (T-- > 0) {
			init();
			// 노드 연결하기
			linkNodes(0, 0, N - 1, null);

			// 후위 순회하기
			for (int i = 1; i <= N; i++) {
				if (nodes[i].parents != null) {
					continue;
				}

				postorder(nodes[i]);
				break;
			}

			res.append(sb.toString()).append("\n");
		}

		System.out.println(res.toString());
	}

	private static void postorder(Node node) {
		if (node == null) {
			return;
		}

		// 왼쪽 자식 순회하기
		postorder(node.left);

		// 오른쪽 자식 순회하기
		postorder(node.right);

		sb.append(node.num).append(" ");
	}

	private static Node linkNodes(int preIdx, int start, int end, Node parents) {
		if (start > end) {
			return null;
		}

		int num = preorder[preIdx];
		nodes[num] = new Node(num, parents);

		// inorder에서 num 위치 찾기
		int idx = end;
		for (int i = start; i <= end; i++) {
			if (inorder[i] != num) {
				continue;
			}

			idx = i;
			break;
		}

		// 왼쪽으로 가기
		nodes[num].left = linkNodes(preIdx + 1, start, idx - 1, nodes[num]);

		// 왼쪽 개수
		int cntLeft = idx - start + 1;
		// 오른쪽으로 가기
		nodes[num].right = linkNodes(preIdx + cntLeft, idx + 1, end, nodes[num]);

		return nodes[num];
	}

	private static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		nodes = new Node[N + 1];

		// 전위
		preorder = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			preorder[i] = Integer.parseInt(st.nextToken());
		}

		// 중위
		inorder = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		sb = new StringBuilder();
	}
}