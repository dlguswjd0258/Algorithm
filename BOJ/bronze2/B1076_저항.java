package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
저항은 색 3개 이용 몇옴인지 구한다
처음 색 2개는 저항의 값, 마지막 색은 곱해야하는 값
map 사용하자
곱은 10^값
색,값
 */

public class B1076_저항 {

	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		setMap();

		long res = map.get(in.readLine()) * 10 + map.get(in.readLine());
		
		// 마지막 저항값
		res *= Math.pow(10, map.get(in.readLine()));

		System.out.println(res);

	}

	private static void setMap() {
		map.put("black", 0);
		map.put("brown", 1);
		map.put("red", 2);
		map.put("orange", 3);
		map.put("yellow", 4);
		map.put("green", 5);
		map.put("blue", 6);
		map.put("violet", 7);
		map.put("grey", 8);
		map.put("white", 9);
	}
}
