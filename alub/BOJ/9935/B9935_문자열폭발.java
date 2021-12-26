/**
* 메모리: 38852 KB, 시간: 452 ms
* 2021.12.26
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static String str, bomb;
	static Stack<Character> alph = new Stack<>();

	public static void main(String[] args) throws Exception {
		input();

		// 폭발 문자열 제거
		removeBombString();

		if (alph.isEmpty()) {
			System.out.println("FRULA");
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : alph) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

	private static void removeBombString() {
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			alph.push(temp);
			if (temp == bomb.charAt(bomb.length() - 1)) {
				checkString();
			}
		}
	}

	private static void checkString() {
		// bomb의 뒤에서부터 확인하면서 전체가 다맞을 때까지 stack에서 빼기
		int idx = bomb.length() - 1;
		while (idx >= 0 && !alph.isEmpty()) {
			// 두 알파벳이 같으면 stack에서 빼고
			if (alph.peek() != bomb.charAt(idx)) {
				break;
			}
			alph.pop();
			idx--;
		}

		// 전체가 다 맞았을면 return
		if (idx < 0) {
			return;
		}

		// 중간에 틀렸다면 확인 한 다음 인덱스부터 다시 넣기
		idx++;
		for (; idx < bomb.length(); idx++) {
			alph.push(bomb.charAt(idx));
		}
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		str = in.readLine();
		bomb = in.readLine();
	}
}