package com.ssafy0201.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1289_원재의메모리복구하기 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/d3/1289_원재의메모리복구하기.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt;
		char pre, bit[];
		for (int t = 1; t <= T; t++) {
			bit = in.readLine().toCharArray();
			cnt = 0;
			pre = '0'; // 초기화 된 값
			for (char next : bit) {
				if (pre != next) {
					cnt++;
					pre = next;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

}
