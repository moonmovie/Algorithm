package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {

	static char[] pw;
	static int N, M;
	static char[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pw= new char[M];
		st = new StringTokenizer(br.readLine());
		result = new char[N];
		for(int i=0;i<M;i++) {
			pw[i]= st.nextToken().charAt(0);
		}
		
		Arrays.sort(pw);
		combi(0,0);
		System.out.println(sb.toString());
		
	}
	public static void combi(int start,int n) {
		if(n==N) {
			boolean flag= false;
			int cnt=0;
			String s="";
			for(int i=0;i<N;i++) {
				if(result[i]=='a'||result[i]=='e'||result[i]=='i'||result[i]=='o'||result[i]=='u') {
					flag=true;
				}else {
					cnt++;
				}
				s+=result[i];
			}
			if(flag&&cnt>=2) {
				sb.append(s+"\n");
			}
			return;
		}
		
		for(int i=start; i<M; i++) {
			result[n]=pw[i];
			combi(i+1,n+1);
		}
		
	}

}
