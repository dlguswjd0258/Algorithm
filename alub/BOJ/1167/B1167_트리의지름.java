/**
* 메모리: 104260 KB, 시간: 740 ms
* 2021.12.17
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
모든 노드를 탐색하는 것은 시간초과가 난다.
어떤 노드에서든 가장 먼 정점을 구해서 그 정점에서 가장 먼 정점과의 거리를 구하는 것이 효율적!
어떤 노드에서든 그 노드에서 가장 먼 정점을 찾으면 해당 정점에서 가장 먼 거리를 구할 수 있다. 

 */
public class Main {

	static ArrayList<int[]>[] adList;
	static int N, max, node;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		input();

		// 어떤 노드에서든 가장 먼 정점 구하기
		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 0);

		// 위에서 구한 정점에서 가장 먼 정점구하기
		visited = new boolean[N];
		visited[node] = true;
		dfs(node, 0);

		System.out.println(max);
	}

	private static void dfs(int idx, int len) {
		if (max < len) {
			max = len;
			node = idx;
		}

        
        visited[idx] = true;
        
		for (int[] temp : adList[idx]) {
			if (visited[temp[0]]) {
				continue;
			}

			dfs(temp[0], len + temp[1]);
			visited[temp[0]] = true;
		}
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		adList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adList[i] = new ArrayList<>();
		}

		StringTokenizer st = null;
		int v, node, len;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			v = Integer.parseInt(st.nextToken()) - 1;
			while (true) {
				node = Integer.parseInt(st.nextToken());
				if (node == -1) {
					break;
				}
				len = Integer.parseInt(st.nextToken());
				adList[v].add(new int[]{node - 1, len});
			}
		}

	}
}