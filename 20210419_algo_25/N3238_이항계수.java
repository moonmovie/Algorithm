package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3238_이항계수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			sb.append("#").append(t).append(" ").
			append(nCr(n,r,p)).append("\n");
//			
		}
		System.out.println(sb.toString());
	}

	static long nCr(long N, long K, int P) {
		long[] fac = new long[P];
		long res = 1;
		
		fac[0] = 1;
		for (int i=1; i<P; i++) {
			fac[i] = (fac[i-1] * i) % P;
		}
		
		while (N != 0 || K != 0) {
			int n = (int)(N % P);
			int k = (int)(K % P);
			
			if (n < k) {
				res = 0;
				break;
			}
			
			long a = (res * fac[n]) % P;
			long b = power((fac[n-k] * fac[k]) % P, P-2, P) % P;
			
			res = (a * b) % P;
			
			N /= P;
			K /= P;
		}
		
		return res;
	}
	private static long power(long x, int y, int p) {
		long res =1L;
		x = x%p;
		
		while(y>0) {
			if(y%2==1)
				res =(res*x)%p;
			y=y>>1;
			x=(x*x)%p;
		}
		return res;
	}
	
}
