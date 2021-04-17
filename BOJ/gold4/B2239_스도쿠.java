package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2239_스도쿠 {

	static int needCnt;
	static int[] rFlag = new int[9], cFlag = new int[9], bFlag = new int[9], sudoku[] = new int[9][9];
	static boolean success;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 데이터 받기
		String s;
		for (int i = 0; i < 9; i++) {
			s = in.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
				
				// 비어있는 숫자 세기
				if (sudoku[i][j] == 0) {
					needCnt++;
					continue;
				}
				
				// 숫자가 있는 위치라면 flag 설정하기
				rFlag[i] |= 1 << sudoku[i][j];
				cFlag[j] |= 1 << sudoku[i][j];
				bFlag[(i / 3) + (j / 3) * 3] |= 1 << sudoku[i][j];
			}
		}

		// 재귀로 숫자 채워넣기
		fillSudoku(0, 0, 0);

		// 완성된 스도쿠 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void fillSudoku(int r, int c, int cnt) {
		if (cnt == needCnt) {
			// 다 채웠으면 완전 끝내기 위해 성공했다고 표시
			success = true;
			return;
		}

		// 다음 열이 없으면 다음 행으로 가기
		if (c == 9) {
			if (r != 8)
				fillSudoku(r + 1, 0, cnt);
			return;
		}

		// 이미 숫자가 채워져 있는 곳이라면 다음 열 보기
		if (sudoku[r][c] != 0) {
			fillSudoku(r, c + 1, cnt);
			return;
		}

		// 넣을 수 있는 숫자 넣기
		for (int i = 1; i <= 9; i++) {
			if (!checkNum(r, c, i))
				continue;
			
			// 현재 위치에 i 값 넣고 flag 설정하기
			setNum(r, c, i);
			fillSudoku(r, c + 1, cnt + 1);
			
			// 이미 스도쿠가 완성된 적이 있다면 return
			if (success)
				return;

			// 현재 위치 값과 flag 돌려놓기
			resetNum(r, c, i);
		}

	}

	private static void resetNum(int r, int c, int num) {
		sudoku[r][c] = 0;
		
		//flag에 num 삭제
		rFlag[r] &= ~(1 << num);
		cFlag[c] &= ~(1 << num);
		bFlag[(r / 3) + (c / 3)*3] &= ~(1 << num);
	}

	private static void setNum(int r, int c, int num) {
		sudoku[r][c] = num;
		
		// flag에 num 추가
		rFlag[r] |= 1 << num;
		cFlag[c] |= 1 << num;
		bFlag[(r / 3) + (c / 3)*3] += 1 << num;
	}

	// 각 행, 열, 3x3 box에 해당 숫자가 있는지 확인
	private static boolean checkNum(int r, int c, int num) {
		return (rFlag[r] & (1 << num)) == 0 && (cFlag[c] & (1 << num)) == 0
				&& (bFlag[(r / 3) + (c / 3) * 3] & (1 << num)) == 0;
	}

}
