import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1992_쿼드트리 {

	static int[][] area;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		area = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				area[i][j]=s.charAt(j)-'0';
			}
		}
		int a = area[0][0];
		boolean flag= false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a!=area[i][j]) {
					flag=true;
				}
			}
		}
		if(!flag) {
			System.out.println(a);
		}else {
			tree(N,area);
			System.out.println(sb.toString());
		}
	}
	
	public static void tree(int n,int[][] arr) {
		int t = n/2;
		sb.append("(");
		int a=arr[0][0],b=arr[0][t],c=arr[t][0],d=arr[t][t];
		boolean a1=false,b1=false,c1=false,d1=false;
		int[][] temp=new int[t][t];
		for(int i=0,x=0;i<t;i++,x++) {
			for(int j=0,y=0;j<t;j++,y++) {
				temp[x][y]=arr[i][j];
				if(arr[i][j]!=a) {
					a1=true;
				}
			}
		}
		if(!a1) {
			sb.append(a);
		}else {
			tree(t,temp);
		}
		
		for(int i=0,x=0;i<t;i++,x++) {
			for(int j=t,y=0;j<n;j++,y++) {
				temp[x][y]=arr[i][j];
				if(arr[i][j]!=b) {
					b1=true;
				}
			}
		}
		if(!b1) {
			sb.append(b);
		}else {
			tree(t,temp);
		}
		
		
		for(int i=t,x=0;i<n;i++,x++) {
			for(int j=0,y=0;j<t;j++,y++) {
				temp[x][y]=arr[i][j];
				if(arr[i][j]!=c) {
					c1=true;
				}
			}
		}
		
		if(!c1) {
			sb.append(c);
		}else {
			tree(t,temp);
		}
		
		for(int i=t,x=0;i<n;i++,x++) {
			for(int j=t,y=0;j<n;j++,y++) {
				temp[x][y]=arr[i][j];
				if(arr[i][j]!=d) {
					d1=true;
				}
			}
		}
		if(!d1) {
			sb.append(d);
		}else {
			tree(t,temp);
		}
		sb.append(")");

	}

}
