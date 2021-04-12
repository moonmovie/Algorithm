package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1249 {
	static class node implements Comparable<node>{
		int x,y,cnt;

		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
		
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map= new int[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.offer(new node(0,0,0));
			node n;
			while(!pq.isEmpty()) {
				n= pq.poll();
				if(n.x==N-1&&n.y==N-1) {
					sb.append("#"+t+" "+n.cnt+"\n");
					break;
				}
				for(int i=0;i<4;i++) {
					int nx = n.x+dx[i];
					int ny = n.y+dy[i];
					
					if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]==-1) continue;
					
					pq.offer(new node(nx,ny,n.cnt+map[nx][ny]));
					map[nx][ny]=-1;
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
