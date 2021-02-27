import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2116 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T;
	static int cnt=0,total=0;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		
		T= Integer.parseInt(br.readLine());
		map =new int[T][6];
		
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		
		for(int i=0;i<6;i++) {
			int max=0;
			int target=map[0][i];
			if(i==0||i==5) {
				for(int j=0;j<6;j++) {
					if(j==0||j==5) continue;
					max=Math.max(max, map[0][j]);
				}
			}
			if(i==1||i==3) {
				for(int j=0;j<6;j++) {
					if(j==1||j==3) continue;
					max=Math.max(max, map[0][j]);
				}
			}
			if(i==2||i==4) {
				for(int j=0;j<6;j++) {
					if(j==2||j==4) continue;
					max=Math.max(max, map[0][j]);
				}
			}
			compareD(target,1);
			cnt=Math.max(total+max, cnt);
			total=0;
		}
		
		System.out.println(cnt);
	}
	
	public static void compareD(int t, int n) throws IOException {
		if(n==T) {
			return;
		}
		
		int temp = 0;
		for(int j=0;j<6;j++) {
			if(t==map[n][j]) temp = j;
		}
		int nextT=0;
		if(temp==0){
			nextT=5;
		}else if(temp==1) {
			nextT=3;
		}else if(temp==2) {
			nextT=4;
		}else if(temp==3) {
			nextT=1;
		}else if(temp==4) {
			nextT=2;
		}else{
			nextT=0;
		}
		int max=0;
		for(int i=0;i<6;i++) {
			if(i==temp||i==nextT) continue;
			max=Math.max(map[n][i], max);
		}
		
		total+=max;
		compareD(map[n][nextT], n+1);
		
		
	}
	
	
}
