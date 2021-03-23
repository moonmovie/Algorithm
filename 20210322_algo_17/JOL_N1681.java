package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_N1681 {
	static int[][] map;
	static int N, sum;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N];
		map= new int[N][N];
		sum=Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		v[0]=true;
		dfs(0,0,0);
		
		if(sum==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(sum);
		}
		
	}
	public static void dfs(int x, int cnt, int total) {
		if(cnt==N-1) {
			if(map[x][0]!=0) {
				sum=Math.min(sum, total+map[x][0]);
				return;
			}else {
				return;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(!v[i]&&map[x][i]!=0) {
				if(total+map[x][i]>sum) continue;
				v[i]=true;
				dfs(i,cnt+1,total+map[x][i]);
				v[i]=false;
			}
		}
	}
}
