import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Dis{
	int x,y;

	public Dis(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class N9205_맥주마시면서걸어가기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Dis> location;
		int[][] adj;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int INF = Integer.MAX_VALUE;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int T=0;T<tc;T++) {
			
			int cv = Integer.parseInt(br.readLine());
			location= new ArrayList<>();
			adj = new int[cv+2][cv+2];
			
			for(int i=0;i<cv+2;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				location.add(new Dis(a, b));
			}
			
			for (int i = 0; i < cv+2; i++) {
				Dis tg1=location.get(i);
				for (int j = 0; j < cv+2; j++) {
					if(i==j) {
						 adj[i][j]=0;
						 continue;
					}
					Dis tg2 = location.get(j);
					int distance = Math.abs(tg1.x-tg2.x)+Math.abs(tg1.y-tg2.y);
					if(distance<=1000) {
						adj[i][j]=1;
					}else {
						adj[i][j]=INF;
					}
					
				}
			}
			
			for (int k = 0; k < adj.length; k++) {
				for (int i = 0; i < adj.length; i++) {
					for (int j = 0; j < adj.length; j++) {
//						adj[i][j]=Math.min(adj[i][k]+adj[k][j],adj[i][j]);
						if(adj[i][k]==1&&adj[k][j]==1)
							adj[i][j]=1;
					}
				}
			}
			
			sb.append(adj[0][adj.length-1]==1?"happy":"sad").append("\n");
			
		}
		
		System.out.println(sb.toString());
	}

}
