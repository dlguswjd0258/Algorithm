/**
* 메모리: 11532 KB, 시간: 76 ms
* 2021.12.06
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
	// 이름과 알파벳 개수 저장할 class
	static class Name implements Comparable<Name> {
		String name;
		int percent;
		int[] alphCnt = new int[26];

		public Name(String name) {
			this.name = name;
			getAlphabetCnt();
		}

		public Name(String name, Name yeondu) {
			this(name);
			getPercentage(yeondu);
		}

		// team의 우승 확률 구하기
		private void getPercentage(Name yeondu) {
			percent = 1;

			// 총 L,O,V,E 개수 구하기
			String love = "LOVE";
			int arr[] = new int[love.length()];
			for (int i = 0; i < love.length(); i++) {
				arr[i] = yeondu.alphCnt[love.charAt(i) - 'A'] + alphCnt[love.charAt(i) - 'A'];
				
				if(i == 0) {
					continue;
				}

				// 확률 구하기
				// ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100
				for (int j = 0; j < i; j++) {
					percent = (percent * (arr[i] + arr[j])) % 100;
				}
			}

		}

		// 이름에 포함하는 알파벳 개수 구하기
		private void getAlphabetCnt() {
			for (int i = 0; i < name.length(); i++) {
				alphCnt[name.charAt(i) - 'A']++;
			}
		}

		@Override
		public int compareTo(Name o) {
			int pDiff = o.percent - this.percent;
			int nameDiff = this.name.compareTo(o.name);
			return pDiff != 0 ? pDiff : nameDiff;
		}

		@Override
		public String toString() {
			return "Name [name=" + name + ", percent=" + percent + ", alphCnt=" + Arrays.toString(alphCnt) + "]";
		}
		
	}

	static int N;
	static final String LOVE = "LOVE";
	static Name yeondu, team[];

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(team[0].name);
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		yeondu = new Name(in.readLine());

		N = Integer.parseInt(in.readLine());
		team = new Name[N];
		for (int i = 0; i < team.length; i++) {
			team[i] = new Name(in.readLine(), yeondu);
		}

		// 우승 확률 내림차순 team 이름 사전순으로 정렬
		Arrays.sort(team);

	}
}