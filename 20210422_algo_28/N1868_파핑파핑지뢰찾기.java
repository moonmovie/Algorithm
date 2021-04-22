package swea;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N1868_파핑파핑지뢰찾기 {

	static char[][] map, checkmap;
	static int N;
	static boolean[][] v;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			checkmap = new char[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				System.arraycopy(map[i], 0, checkmap[i], 0, map[i].length);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '*') {
						
						checkmap[i][j]=(char) (star(i, j)+'0');
						
					}
				}
			}
			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (checkmap[i][j] =='0'&&!v[i][j]) {
						cnt++;
						bfs(i,j);
						
					}
				}
			}
			

			int res=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						res++;
					}
				}
			}
			System.out.println("#"+t+" "+(cnt+res));
		}
	}
	private static void bfs(int i,int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		v[i][j]=true;
		map[i][j]='0';
		int[] n;
		while(!q.isEmpty()) {
			n=q.poll();
			
			for (int k = 0; k < 8; k++) {
				int nx = n[0] + dx[k];
				int ny = n[1] + dy[k];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '*'||v[nx][ny])
					continue;
				
				map[nx][ny]= checkmap[nx][ny];
				v[nx][ny]=true;
				if(map[nx][ny]=='0') {
					q.offer(new int[] {nx,ny});
				}

			}
		}
	}
	private static int star(int i, int j) {
		
		int cnt=0;
		for (int k = 0; k < 8; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != '*')
				continue;
			cnt++;

		}
		return cnt;
	}

}
