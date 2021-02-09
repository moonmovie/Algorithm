import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2563 {

	static boolean[][] arr =new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			for(int j=Y;j<Y+10;j++) {
				for(int k=X;k<X+10;k++) {
					if(!arr[j][k]) {
						arr[j][k]=true;
						cnt++;
					}
				}
			}
			
		}
		System.out.println(cnt);

	}

}
