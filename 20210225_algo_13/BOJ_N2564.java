import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2564 {

	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}
	static boolean[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		v = new boolean[N + 1][M + 1];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				map[i][j] = true;
			}
		}
		int t = Integer.parseInt(br.readLine());
		
		Node[] vi = new Node[t+1];
		for (int i = 0; i < t+1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==1) vi[i] = new Node(0,m,0);
			else if(n==2) vi[i] = new Node(N,m,0);
			else if(n==3) vi[i] = new Node(m,0,0);
			else if(n==4) vi[i] = new Node(m,M,0);
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		int total=0;
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		for(int i=0;i<t;i++) {
			queue.offer(vi[t]);
			int tx = vi[i].x;
			int ty = vi[i].y;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.x==tx&&node.y==ty) {
					total+=node.cnt;
					queue.clear();
					break;
				}
				for(int k=0;k<4;k++) {
					int nx = node.x+dx[k];
					int ny = node.y+dy[k];
					if(nx>=0&&ny>=0&&nx<N+1&&ny<M+1&&!map[nx][ny]&&!v[nx][ny]) {
						v[nx][ny]=true;
						queue.offer(new Node(nx,ny,node.cnt+1));
					}
				}
			}
			for(boolean[] a: v) {
				Arrays.fill(a, false);
			}
		}
		System.out.println(total);
	}

}
