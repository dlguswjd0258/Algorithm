/**
* 메모리: 11528 KB, 시간: 76 ms
* 2021.12.03
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(N * M - 1);
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
}