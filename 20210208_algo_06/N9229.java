import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9229 {
	static int N, G;
	static int R=2;
	static int[] number;
	static int[] temp;
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			G=Integer.parseInt(st.nextToken());
			number = new int[N];
			temp = new int[R];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				number[i]=Integer.parseInt(st.nextToken());
			}
			Combi(0,0);
			if(max==0) {
				sb.append("#"+t+" "+"-1"+"\n");
			}else {
				sb.append("#"+t+" "+max+"\n");
			}
			max=0;
		}
		System.out.println(sb.toString());

	}
	public static void Combi(int n, int start) {
		if(n==R) {
			int sum=0;
			for(int i=0;i<temp.length;i++) {
				sum+=temp[i];
			}
			if(sum<=G) {
				max= max<sum?sum:max;
			}
			return;
		}
		for(int i=start;i<N;i++) {
			temp[n]=number[i];
			Combi(n+1,i+1);
		}	

	}

}
