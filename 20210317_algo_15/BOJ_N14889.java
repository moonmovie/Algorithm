import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14889 {

	static int[][] map;
	static int[] select;
	static boolean[] ck;
	static int N;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		select = new int[N/2];
		ck = new boolean[N+1];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		combi(1,0);
		System.out.println(min);
	}
	public static void combi(int start, int n) {
		if(n==N/2) {
			boolean[] g = new boolean[N+1];
			int[] startT=new int[N/2];
			int[] linkT = new int[N/2];
			for(int i=0;i<N/2;i++) {
					g[select[i]]=true;
					startT[i]=select[i];
			}
			int idx=0;
			for(int i=1;i<N+1;i++) {
				if(!g[i]) {
					linkT[idx++]=i;
				}
			}
			int sumstart =0;
			int sumlink = 0;
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					sumstart+=map[startT[i]-1][startT[j]-1];
					sumlink+=map[linkT[i]-1][linkT[j]-1];
				}
			}
			min=Math.min(min, Math.abs(sumstart-sumlink));
			return;
		}
		for(int i=start;i<N+1;i++) {
			select[n]=i;
			combi(i+1,n+1);
			
		}
	}

}
