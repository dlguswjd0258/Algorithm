/**
* 메모리: 100440 KB, 시간: 1296 ms
* 2022.01.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Process implements Comparable<Process> {
		int id, time, prior;

		public Process(int id, int time, int prior) {
			this.id = id;
			this.time = time;
			this.prior = prior;
		}

		@Override
		public int compareTo(Process o) {
			// 우선순위 내림차순
			int pDiff = o.prior - this.prior;
			int iDiff = this.id - o.id;
			return pDiff != 0 ? pDiff : iDiff;
		}
	}
	
	static int T, N;
	static PriorityQueue<Process> processes = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(runProcess());
	}

	private static String runProcess() {
		StringBuilder sb = new StringBuilder();
		while(T-- > 0 && !processes.isEmpty()) {
			// 실행할 프로세스 선택
			Process process = processes.poll();
			
			// 실행
			sb.append(process.id).append("\n");
			
			// 시간 감소, 우선순위 감소
			process.time--;
			process.prior--;
			
			//시간이 남아있으면 다시 que에 담기
			if(process.time > 0) {
				processes.offer(process);
			}
		}
		
		return sb.toString();
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		T = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		while(N-- > 0) {
			st = new StringTokenizer(in.readLine());
			int id = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int prior = Integer.parseInt(st.nextToken());
			processes.offer(new Process(id, time, prior));
		}
	}
}