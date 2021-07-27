package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
���� �Ⱓ���� ��ü �л��� ��õ�� ���� �л�ȸ�� �ĺ��� ������
�ĺ� �� ��ŭ ����Ʋ�� ����
��õ���� Ƚ���� ǥ���ϴ� ��Ģ
1. ������ ��� ����Ʋ�� �������
2. Ư�� �л� ��õ ��, ��õ���� �л��� ������ ����Ʋ�� �Խ�
3. ����Ʋ�� �� ������ �� ��õ ���� Ƚ���� ���� ���� �л��� ���� ����, ���Ӱ� ��õ���� �л��� ���� �Խ�
4. ������ ���� ��õ����� �Խõ��� ������ �л� ���� ����
5. ���� �����Ǹ� �ش� �л��� ��õ���� Ƚ���� 0���� �ʱ�ȭ

�켱���� ��õ ��(���� ��), �Խõ� �ñ�(�ֽż�)

���� �ĺ� ã�� (������������)
 */
public class B1713_�ĺ���õ�ϱ� {

	static class Student implements Comparable<Student> {
		int num, voted, date;

		public Student(int num, int voted, int date) {
			this.num = num;
			this.voted = voted;
			this.date = date;
		}

		@Override
		public int compareTo(Student o) {
			int dVote = this.voted - o.voted; // ��õ ���� ��
			int dDate = this.date - o.date; // �Խ� ������ ��
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

		// �л� �ʱ�ȭ
		students = new Student[K + 1];
		for (int i = 1; i <= K; i++) {
			students[i] = new Student(i, 0, 0);
		}

		StringTokenizer st = new StringTokenizer(in.readLine());
		int date = 0;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			date++;

			// ��ǥ�ϱ�
			students[num].voted++;

			// �ԽõǾ� ���� ���� �л��� ��
			if (!photos.contains(students[num])) {
				// �̹� �ԽõǾ� �ִ� �л��� ��¥(��ǥ���� ����) �������� ����
				students[num].date = date;
				// �Խ��ϱ�
				displayPhoto(num);
			}
		}

		// ������������ ���
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

			// �����Ǹ� ��õ�� �ʱ�ȭ
			Student student = photos.remove(0);
			student.voted = 0;
			student.date = 0;
		}

		photos.add(students[num]);
	}
}
