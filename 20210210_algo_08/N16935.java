import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16935 {
	static int[][] map;
	static int[][] after;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int c = Integer.parseInt(st.nextToken());
			switch (c) {
			case 1:
				first();
				break;
			case 2:
				second();
				break;
			case 3:
				third();
				break;
			case 4:
				fourth();
				break;
			case 5:
				fifth();
				break;
			case 6:
				sixth();
				break;
			}
		}
		for(int[] x:map) {
			for(int a:x) {
				System.out.print(a+" ");
			}
			System.out.println();
		}

	}

	public static void first() {
		after= new int[map.length][map[0].length];
		int k=0,f=0;
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				after[k][f]=map[i][j];
				f++;
			}
			f=0;
			k++;
		}
		map=after;

	}

	public static void second() {
		after= new int[map.length][map[0].length];
		int k=0,f=0;
		for (int i = 0; i < map.length; i++) {
			for (int j = map[i].length - 1; j >= 0; j--) {
				after[k][f]=map[i][j];
				f++;
			}
			f=0;
			k++;
		}
		map=after;
	}

	public static void third() {
		after= new int[map[0].length][map.length];
		int k=0,f=0;
		for (int i = 0; i < map[0].length; i++) {
			for (int j = map.length - 1; j >= 0; j--) {
				after[k][f]=map[j][i];
				f++;
			}
			f=0;
			k++;
		}
		map=after;
	}

	public static void fourth() {
		after= new int[map[0].length][map.length];
		int k=0,f=0;
		for (int i = map[0].length - 1; i >= 0; i--) {
			for (int j = 0; j < map.length; j++) {
				after[k][f]=map[j][i];
				f++;
			}
			f=0;
			k++;
		}
		map=after;
	}

	public static void fifth() {
		after= new int[map.length][map[0].length];
		int g=0,f=0;
		int row = (map.length / 2);
		int col = (map[0].length / 2);

		for (int i = row; i < map.length; i++) {
			for (int j = 0; j < col; j++) {
				after[g][f]=map[i][j];
				f++;
			}
			for (int k = 0; k < col; k++) {
				after[g][f]=map[i - row][k];
				f++;
			}
			f=0;
			g++;
		}
		for (int i = row; i < map.length; i++) {
			for (int j = col; j < map[0].length; j++) {
				after[g][f]=map[i][j];
				f++;
			}
			for (int k = col; k < map[0].length; k++) {
				after[g][f]=map[i - row][k];
				f++;
			}
			f=0;
			g++;
		}
		map=after;

	}

	public static void sixth() {
		after= new int[map.length][map[0].length];
		int g=0,f=0;
		int row = (map.length / 2);
		int col = (map[0].length / 2);

		for (int i = 0; i < row; i++) {
			for (int j = col; j < map[0].length; j++) {
				after[g][f]=map[i][j];
				f++;
			}
			for (int k = col; k < map[0].length; k++) {
				after[g][f]=map[i + row][k];
				f++;
			}
			f=0;
			g++;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				after[g][f]=map[i][j];
				f++;
			}
			for (int k = 0; k < col; k++) {
				after[g][f]=map[i + row][k];
				f++;
			}
			f=0;
			g++;
		}
		map=after;
	}
}