/**
* 메모리: 506836 KB, 시간: 1892 ms
* 2021.12.23
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		str = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken()) - 1;
		arr = new int[N];
		int k = 0;

		str = new StringTokenizer(br.readLine(), " ");
		while (N-- > 0) {
			int next = Integer.parseInt(str.nextToken());
			arr[N] = next;
		}
		Arrays.sort(arr);
		System.out.println(arr[K]);

	}
}