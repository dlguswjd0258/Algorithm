package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841_외계인의기타연주 {

	static int N, P, cnt;
	static Stack<Integer> stacks[] = new Stack[7]; // 누르고 있는 상태 넣기

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		// 데이터 받으면서 값 처리
		int jul, fret;
		while (N-- > 0) {
			st = new StringTokenizer(in.readLine());
			jul = Integer.parseInt(st.nextToken()); // 줄 번호
			fret = Integer.parseInt(st.nextToken()); // 프렛 번호

			// 줄 번호가 처음 나왔을 때
			if (stacks[jul] == null) {
				fistStack(jul, fret);
				continue;
			}

			// 줄 번호가 이미 나왔을 떼
			pressFret(jul, fret);
		}

		System.out.println(cnt);

	}

	private static void pressFret(int jul, int fret) {
		// 누르고 있는 번호가 있다면 현재 번호보다 같거나 작은 수가 위에 있을 때까지 손가락 떼기
		while (!stacks[jul].isEmpty() && stacks[jul].peek() > fret) {
			stacks[jul].pop();
			cnt++;
		}

		// 누르고자하는 프렛 번호가 이미 눌려 있다면 return;
		if (!stacks[jul].isEmpty() && stacks[jul].peek() == fret)
			return;

		stacks[jul].push(fret);
		cnt++;

	}

	private static void fistStack(int jul, int fret) {
		stacks[jul] = new Stack<>();
		stacks[jul].push(fret);
		cnt++;
	}
}
