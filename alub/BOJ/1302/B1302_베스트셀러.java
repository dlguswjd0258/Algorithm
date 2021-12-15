/**
* 메모리: 11632 KB, 시간: 76 ms
* 2021.12.15
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int N;
	static Map<String, Integer> books = new HashMap<>();

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(getBestSeller());
	}

	private static String getBestSeller() {
		int max = 0;
		String best = "";
		// key에 해당하는 값이 높으면 best에 담기
		for (String title : books.keySet()) {
			if (max < books.get(title)) {
				max = books.get(title);
				best = title;
			} else if (max == books.get(title)) {
				best = getTitle(best, title);
			}
		}
		return best;
	}

	private static String getTitle(String best, String title) {
		int len = best.length() > title.length() ? title.length() : best.length();
		for (int i = 0; i < len; i++) {
			if (best.charAt(i) == title.charAt(i))
				continue;

			return best.charAt(i) > title.charAt(i) ? title : best;
		}

		return best.length() > title.length() ? title : best;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		String title;
		while (N-- > 0) {
			title = in.readLine();
			// key = 책 제목, value = 개수
			books.put(title, books.getOrDefault(title, 0) + 1);
		}
	}
}