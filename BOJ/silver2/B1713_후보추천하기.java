package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
일정 기간동안 전체 학생의 추천에 의해 학생회장 후보가 정해짐
후보 수 만큼 사진틀을 만듦
추천받은 횟수를 표시하는 규칙
1. 시작전 모든 사진틀은 비어있음
2. 특정 학생 추천 시, 추천받은 학생의 사진이 사진틀에 게시
3. 사진틀이 다 차있을 때 추천 받은 횟수가 가장 적은 학생의 사진 삭제, 새롭게 추천받은 학생의 사진 게시
4. 동일한 최저 추천수라면 게시된지 오래된 학생 사진 삭제
5. 사진 삭제되면 해당 학생이 추천받은 횟수는 0으로 초기화

우선순위 추천 수(많은 수), 게시된 시기(최신순)

최종 후보 찾기 (오른차순으로)
 */
public class B1713_후보추천하기 {

	static class Student implements Comparable<Student> {
		int num, voted, date;

		public Student(int num, int voted, int date) {
			this.num = num;
			this.voted = voted;
			this.date = date;
		}

		@Override
		public int compareTo(Student o) {
			int dVote = this.voted - o.voted; // 추천 적은 순
			int dDate = this.date - o.date; // 게시 오래된 순
			return dVote != 0 ? dVote : dDate;
		}
	}

	static int N, K;
	static Student[] students;
	static List<Student> photos = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());

		// 학생 초기화
		students = new Student[K + 1];
		for (int i = 1; i <= K; i++) {
			students[i] = new Student(i, 0, 0);
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		int date = 0;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			date++;

			// 투표하기
			students[num].voted++;

			// 게시되어 있지 않은 학생일 때
			if (!photos.contains(students[num])) {
				// 이미 게시되어 있는 학생은 날짜(투표받은 순서) 갱신하지 않음
				students[num].date = date;
				// 게시하기
				displayPhoto(num);
			}
		}

		// 오른차순으로 출력
		Collections.sort(photos, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.num - o2.num;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Student student : photos) {
			sb.append(student.num).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void displayPhoto(int num) {
		if (photos.size() == N) {
			Collections.sort(photos);

			// 삭제되면 추천수 초기화
			Student student = photos.remove(0);
			student.voted = 0;
			student.date = 0;
		}

		photos.add(students[num]);
	}
}
