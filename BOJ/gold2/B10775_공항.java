package gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10775_공항 {

	static int G, P, gate[];
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(in.readLine());
		P = Integer.parseInt(in.readLine());
		// 게이트번호에 도킹된 비행기가 있는지 체크
		check = new boolean[G + 1]; 
		
		// 각 번호가 도킹 시켜야 할 게이트 번호
		gate = new int[G + 1];
		// 각 비행기의 번호와 도킹해야하는 번호 초기화
		for (int i = 1; i <= G; i++) {
			gate[i] = i;
		}

		int plan, cnt = 0, i;
		while (P-- > 0) {
			plan = Integer.parseInt(in.readLine());
			for (i = gate[plan]; i > 0; i--) {
				if (check[i])
					continue;

				check[i] = true;
				gate[plan] = i-1; // 같은 번호가 들어왔을 때 다음 도킹할 번호 저장
				cnt++;
				break;
			}

			// 도킹시키지 못했다면 끝내기
			if (i == 0)
				break;
		}

		System.out.println(cnt);
	}
}
