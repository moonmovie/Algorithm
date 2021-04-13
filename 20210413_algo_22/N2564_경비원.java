import java.io.*;
import java.util.*;

public class N2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[R+1][C+1];
		for(int i=1;i<R;i++) {
			for(int j=1;j<C;j++) {
				map[i][j]=true;
			}
		}
		int l = Integer.parseInt(br.readLine());
		int[][] shop= new int[l+1][2];
		for(int i=0;i<l+1;i++) {
			st= new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
//			 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점
			
			if(d==1) {
				shop[i][0] = 0;
				shop[i][1] = x;
			}else if(d==2) {
				shop[i][0] = R;
				shop[i][1] = x;
			}else if(d==3) {
				shop[i][0] = x;
				shop[i][1] = 0;
			}else if(d==4) {
				shop[i][0] = x;
				shop[i][1] = C;
			}
		}
		
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int result=0;
		for(int i=0;i<l;i++) {
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] v = new boolean[R+1][C+1];
			q.offer(new int[] {shop[l][0],shop[l][1],0});
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				if(temp[0]==shop[i][0]&&temp[1]==shop[i][1]) {
					result+=temp[2];
					break;
				}
				for(int k=0;k<4;k++) {
					int nx = temp[0]+dx[k];
					int ny = temp[1]+dy[k];
					if(nx<0||ny<0||nx>R||ny>C||map[nx][ny]||v[nx][ny]) continue;
					q.offer(new int[] {nx,ny,temp[2]+1});
					v[nx][ny]=true;
				}
			}
			
		}
		
		System.out.println(result);
	}

}
