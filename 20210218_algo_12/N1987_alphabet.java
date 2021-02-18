import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1987_alphabet {

	static int R, C;
	static char[][] map;
	static int max = 1;
	static boolean[] alphabet = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		alphabet[map[0][0] - 65] = true;
		dfs(0, 0, 1);
		System.out.println(max);

	}
	public static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		int[] dx = { 1, 0, -1, 0};
		int[] dy = { 0, 1, 0, -1};

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C || alphabet[map[nx][ny] - 65]) continue;

			alphabet[map[nx][ny] - 65] = true;
			dfs(nx, ny, cnt+1);
			alphabet[map[nx][ny] - 65] = false;
		}
	}
}