import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N+1][3];
		int[][] cost = new int[N+1][3];
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				house[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<N+1;i++) {
			cost[i][0]=Math.min(cost[i-1][1],cost[i-1][2])+house[i][0];
			cost[i][1]=Math.min(cost[i-1][0],cost[i-1][2])+house[i][1];
			cost[i][2]=Math.min(cost[i-1][0],cost[i-1][1])+house[i][2];
		}
		
		System.out.println(Math.min(cost[N][0],Math.min(cost[N][1], cost[N][2])));
	}
}
