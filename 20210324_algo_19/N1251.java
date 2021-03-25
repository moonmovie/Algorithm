package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1251 {
	static long[][] island;
	static int N;
	static int[][] point;
	static long[] minEdge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int T=1;T<=tc;T++) {
			
			N = Integer.parseInt(br.readLine());
			point = new int[N][2];
			island = new long[N][N];
			minEdge = new long[N];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
						
			for(int j=0;j<N;j++) {
				point[j][0]= Integer.parseInt(st1.nextToken());
				point[j][1]= Integer.parseInt(st2.nextToken());
			}	
			
			
			Double en = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					island[i][j]=island[j][i]=
							(long) (Math.pow(point[i][0]-point[j][0], 2)+Math.pow(point[i][1]-point[j][1], 2));
				}
				minEdge[i] = Long.MAX_VALUE;
			}
			double rst = en * Prim();
			sb.append("#"+T+" "+Math.round(rst)+"\n");
		}
		System.out.println(sb.toString());
	}

	public static Long Prim() {
		boolean[] v = new boolean[N];
		minEdge[0]=0;
		int minidx = 0;
		long min,result=0; 
		for (int i = 0; i < N; i++) {
			 min = Long.MAX_VALUE;
	         minidx = 0;
	         
			for (int j = 0; j < N; j++) {
				if(!v[j]&&min>minEdge[j]) {
					min =minEdge[j];
					minidx=j;
				}
			}
			
			result+=min;
			v[minidx]=true;
			
			for (int j = 0; j < N; j++) {
				if(!v[j]&&island[minidx][j]!=0&&minEdge[j]>island[minidx][j]) {
					minEdge[j]=island[minidx][j];
				}
			}
			
		}
		
		return result;
	}
}
