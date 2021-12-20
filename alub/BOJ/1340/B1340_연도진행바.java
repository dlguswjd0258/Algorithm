/**
* 메모리: 11612 KB, 시간: 80 ms
* 2021.12.20
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final String[] MONTH = { "", "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	static final int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int yy, MM, dd, hh, mm;
	static boolean leapYear;

	public static void main(String[] args) throws Exception {
		input();

		double total = (isLeapYear() ? 366 : 365) * 24 * 60;
		double pass = getPassedMinute();

		System.out.println(pass / total * 100);

	}

	private static int getPassedMinute() {
		int minute = mm;
		// 월 -> 분 환산
		for (int i = 1; i < MM; i++) {
			if (i != 2 || !isLeapYear()) {
				minute += day[i] * 24 * 60;
			} else {
				minute += (day[i] + 1) * 24 * 60;
			}
		}

		// 남은 일수 -> 분 환산
		if (MM != 2 || !isLeapYear()) {
			minute += (dd - 1) * 24 * 60;
		} else {
			minute += (dd - 1) * 24 * 60;
		}

		// 남은 시간 -> 분 환산
		minute += hh * 60;

		return minute;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ,:");
		// 월을 숫자로
		String month = st.nextToken();
		MM = getMonth(month);
		dd = Integer.parseInt(st.nextToken());
		yy = Integer.parseInt(st.nextToken());
		hh = Integer.parseInt(st.nextToken());
		mm = Integer.parseInt(st.nextToken());
	}

	private static boolean isLeapYear() {
		if (yy % 400 == 0 || (yy % 4 == 0 && yy % 100 != 0))
			return true;
		return false;
	}

	private static int getMonth(String month) {
		int m = 0;
		for (int i = 1; i <= 12; i++) {
			if (!MONTH[i].equals(month)) {
				continue;
			}

			m = i;
		}
		return m;
	}
}