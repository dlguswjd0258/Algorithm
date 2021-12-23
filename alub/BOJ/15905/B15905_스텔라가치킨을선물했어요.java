/**
* 메모리: 11644 KB, 시간: 80 ms
* 2021.12.23
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Student implements Comparable<Student> {
		int solvedCnt, penalty;

		public Student(int solvedCnt, int penalty) {
			this.solvedCnt = solvedCnt;
			this.penalty = penalty;
		}

		@Override
		public int compareTo(Student o) {
			// 해결한 문제 수 내림차순
			int cntDiff = o.solvedCnt - this.solvedCnt;
			// 패널치 오름차순
			int penDiff = this.penalty - o.penalty;
			return cntDiff != 0 ? cntDiff : penDiff;
		}
	}

	static int N;
	static List<Student> students;

	public static void main(String[] args) throws Exception {
		input();

		if (N <= 5) {
			System.out.println(0);
		} else {
			System.out.println(countGivedGiftCard());
		}
	}

	private static int countGivedGiftCard() {
		int cnt = 0;
		// 학생들 정렬
		Collections.sort(students);
		
		// 5번째 학생을 꺼내기
		Student five = students.get(4);
		
		// 6번째 부터 cnt가 같으면 count하고 다르면 break;
		for (int i = 5; i < N; i++) {
			if(students.get(i).solvedCnt != five.solvedCnt) {
				break;
			}
			cnt++;
		}
		
		return cnt;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		students = new ArrayList<>(N);

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			students.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

	}
}