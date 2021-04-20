package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5607_조합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
//		int p=1234567891;
		int p=11;
		for(int t=1;t<=TC;t++) {
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(t).append(" ").
			append(nCr(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),p)).append("\n");
		}
		System.out.println(sb.toString());
	}
	static long nCr(int n, int r, int p) {
		if(r==0)
			return 1L;
		
		long[] fac = new long[n+1];
		fac[0]=1;
		
		for(int i=1;i<=n;i++)
			fac[i]=fac[i-1]*i % p;
		
		return (fac[n]* power(fac[r],p-2,p)%p
		 *power(fac[n-r],p-2,p)%p) %p;
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
	
	int pow1(int a,int b,int m) {
		   int ret = 1;
		   while (b>0) {
		      if (b % 2 == 1) {
		         ret *= a;
		         ret %= m;
		      }
		      b >>= 1;
		      a *= a;
		      a %= m;
		   }
		   return ret;
		}
	
	int pow2(int a,int b) {
		   int ret = 1;
		   while (b>0) {
		      if (b % 2 == 1) {
		         ret *= a;
		      }
		      b >>= 1;
		      a *= a;
		   }
		   return ret;
		}
}
