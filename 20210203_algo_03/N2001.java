import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N =Integer.parseInt(st.nextToken());
			int M= Integer.parseInt(st.nextToken());
			int [][] arr = new int[N][N];
			int max=0;
			int sum=0;
			int te=0;
			int ta=0;
			
			for(int i=0;i<N;i++) {
				StringTokenizer sy = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]+=Integer.parseInt(sy.nextToken());
				}
			}
			
			for(int k=0;k<N-M+1;k++) {
				for(int d=0;d<N-M+1;d++) {
					if(te+M<N+1) {
						for(int i=k;i<M+ta;i++) {
							for(int j=d;j<M+te;j++) {
								sum+=arr[i][j];
							}
						}
						max = max<sum?sum:max;
						sum=0;
					}
					
					te++;
				}
				ta++;
				te=0;
			}
				sb.append("#"+t+" "+max);
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}

	}


