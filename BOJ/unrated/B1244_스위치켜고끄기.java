package unrated;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 1244 스위치 켜고 끄기 
public class B1244_스위치켜고끄기 {

	static int N, M; // 스위치 개수, 학생 개수
	static boolean[] isOn; // 스위치 켜졌는지
	static int num; // 학생이 받은 수

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 1.스위치 데이터 입력 받기
		N = Integer.parseInt(in.readLine());
		isOn = new boolean[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			if (st.nextToken().charAt(0) == '1') {
				isOn[i] = true;
			}
		}

		// 2. 학생 데이터 입력 받으면서 처리하기
		M = Integer.parseInt(in.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			// 2-1. 성별은 1이면 남자, 2면 여자
			if (st.nextToken().charAt(0) == '1') {
				// 나머지 비교해야 하므로 -1하지 않음
				man(Integer.parseInt(st.nextToken()));
			} else {
				// 배열 index보다 1 크게 나오므로 -1해서 넘겨주기
				woman(Integer.parseInt(st.nextToken()) - 1);
			}

		}

		// 3. 결과 출력하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (isOn[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}

			// 20개만 한줄에 넣기
			if (i % 20 == 19)
				sb.append("\n");
		}

		System.out.println(sb);

	}

	/**
	 * 받은 수의 배수인 위치에 있는 스위치들 상태 바꾸기
	 * 
	 * @param num 받은 수 (index보다 1 큰 수)
	 */
	private static void man(int num) {
		for (int i = num; i <= N; i++) {
			if (i % num == 0) {
				isOn[i - 1] = !isOn[i - 1];
			}
		}
	}

	/**
	 * 받은 수와 동일한 위치의 스위치를 중심으로 대칭인 곳까지 상태 바꾸기
	 * 
	 * @param num 받은수
	 */
	private static void woman(int num) {
		// 1. 대칭 찾아서 범위 구하기
		int start = num, end = num; // 대칭 범위
		while (start - 1 >= 0 && end + 1 < N) {
			if (isOn[start - 1] == isOn[end + 1]) {
				start--;
				end++;
			} else {
				break;
			}
		}

		// 2. 범위 내에 있는 스위치 상태 바꾸기
		for (int i = start; i <= end; i++) {
			isOn[i] = !isOn[i];
		}
	}
}
