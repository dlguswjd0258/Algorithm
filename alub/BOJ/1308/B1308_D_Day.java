/**
* 메모리: 11532 KB, 시간: 76 ms
* 2022.01.13
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] now, dDay;
	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		input();
		int res = getDifDay(dDay);
		int limit = getDifDay(new int[] { now[0] + 1000, now[1], now[2] });

		if (limit <= res) {
			System.out.println("gg");
		} else {
			System.out.println("D-" + res);
		}
	}

	private static int getDifDay(int[] day) {
		int d = 0;
		// 년단위로 남은 날짜 계산
		d += yearToDay(now[0], day[0]);

		// 남은 달 계산하기
		if (now[0] != day[0]) {
			// 현재 년도의 남은 달 계산
			d += monthToDay(now[0], now[1] + 1, 13);

			// 마지막 년도의 남은 달 계산
			d += monthToDay(day[0], 1, day[1]);

			// 현재 년도의 남은 일수 더하기
			d += getLeftDay(day[2]);

			return d;
		}

		// 같은 년도일 때
		// 주어진 달 - 1까지만 계산
		d += monthToDay(day[0], now[1] + 1, day[1]);

		// 일 수 계산
		if (now[1] == day[1]) {
			// 년도도 같고 달도 같을 때 주어진 일 - 현재 일
			d += day[2] - now[2];
		} else {
			d += getLeftDay(day[2]);
		}

		return d;
	}

	private static int getLeftDay(int day) {
		int d = 0;
		// 현재 년도의 남은 일수 더하기
		d += days[now[1]] - now[2];
		if (now[1] == 2 && isLeapYear(now[0])) {
			d++;
		}

		// 주어진 년도의 남은 일수 더하기
		d += day;
		return d;
	}

	private static int monthToDay(int year, int start, int end) {
		int d = 0;
		for (int m = start; m < end; m++) {
			d += days[m];
			if (isLeapYear(year) && m == 2) {
				d++;
			}
		}
		return d;
	}

	private static int yearToDay(int n, int d) {
		int total = 0;
		for (int year = n + 1; year < d; year++) {
			if (isLeapYear(year)) {
				total += 366;
			} else {
				total += 365;
			}
		}
		return total;
	}

	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		now = new int[3];
		dDay = new int[3];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 3; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 3; i++) {
			dDay[i] = Integer.parseInt(st.nextToken());
		}
	}
}