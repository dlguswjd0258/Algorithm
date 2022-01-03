/**
* 메모리: 40440 KB, 시간: 708 ms
* 2022.01.03
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Room {
		char type;
		int money;
		List<Integer> linked = new ArrayList<>();

		public Room(char type, int money) {
			this.type = type;
			this.money = money;
		}
	}

	static int N;
	static Room[] rooms;
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (N > 0) {
			// 방 정보 입력받기
			initRooms();

			if (canGoNRoom(1, 0, new boolean[N + 1][500 + 1])) {
				sb.append("Yes");
			} else {
				sb.append("No");
			}

			sb.append("\n");
			N = Integer.parseInt(in.readLine());
		}

		System.out.println(sb.toString());
	}

	private static boolean canGoNRoom(int idx, int money, boolean[][] visited) {
		Room room = rooms[idx];
		if (room.type == 'T') {
			money -= room.money;
		} else if (room.type == 'L' && room.money > money) {
			money = room.money;
		}

		// 트롤이 있을 때 지불한 돈이 0보다 작게되면 못 들어간다.
		if (money < 0 || visited[idx][money]) {
			return false;
		}

		// 들어왔는데 N번째 방이라면 true
		if (idx == N) {
			return true;
		}
        
		visited[idx][money] = true;

		// 연결된 방으로 들어가기
		for (int num : room.linked) {
			// 이미 방문한 방은 들어가지 않는다.
			if (visited[num][money]) {
				continue;
			}

			// 마지막 방에 갈 수 있다면 바로 true 리턴
			if (canGoNRoom(num, money, visited)) {
				return true;
			}
		}

		return false;
	}

	private static void initRooms() throws Exception {
		rooms = new Room[N + 1];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			// 트롤이면 일정금액에 -1 곱하기
			rooms[i] = new Room(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
			int room = Integer.parseInt(st.nextToken());
			while (room > 0) {
				rooms[i].linked.add(room);
				room = Integer.parseInt(st.nextToken());
			}
		}
	}
}