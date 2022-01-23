/**
* 메모리: 133088 KB, 시간: 1772 ms
* 2022.01.23
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static class File implements Comparable<File> {
		String name, extension;
		int os;

		public File(String name, String extension) {
			this.name = name;
			this.extension = extension;
		}

		@Override
		public int compareTo(File o) {
			// 파일 이름 오름차순
			int nameDiff = this.name.compareTo(o.name);
			// 인식 순
			int osDiff = o.os - this.os;
			// 확장자 오름차순
			int extenDiff = this.extension.compareTo(o.extension);

			return nameDiff != 0 ? nameDiff : osDiff != 0 ? osDiff : extenDiff;
		}
	}

	static int N, M;
	static Set<String> extension = new HashSet<>();
	static File[] files;

	public static void main(String[] args) throws Exception {
		input();
		sortFiles();
		printFiles();
	}

	private static void sortFiles() {
		// 인식하는 확장자인지 확인하기 위한 작업
		for (int i = 0; i < N; i++) {
			if (!extension.contains(files[i].extension)) {
				continue;
			}

			files[i].os = 1;
		}

		// 정렬
		Arrays.sort(files);
	}

	private static void printFiles() {
		StringBuilder sb = new StringBuilder();
		for (File file : files) {
			sb.append(file.name).append(".").append(file.extension).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		files = new File[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), ".");
			files[i]= new File(st.nextToken(), st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			extension.add(in.readLine());
		}
	}
}