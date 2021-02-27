import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2304 {
	static int maxIndex=0;
	static int max=0;
	static class Node implements Comparable<Node>{
		int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Node o) {
			
			return this.x-o.x;
		}
		
	}
	static Node[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x,y;
		map=new Node[N];
		for(int t=0;t<N;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());

			map[t]=new Node(x,y);
		}
		Arrays.sort(map);
		for(int i=0;i<map.length;i++) {
			Node nn=map[i];
			if(nn.y>max) {
				maxIndex=i;
				max=nn.y;
			}
		}
		Node nd;
		int total=0;
		int L=0,R=0;//2
		int LH=0,RH=0;//4
		for(int i=0;i<N;i++) {
			nd=map[i];
			if(LH<nd.y) {
				total+=(nd.x-L)*LH;
				LH=nd.y;
				L=nd.x;
				if(LH==max) break;
			}
		}
		for(int i=N-1;i>0;i--) {
			nd=map[i];
			if(RH<nd.y) {
				total+=Math.abs(nd.x-R)*RH;
				RH=nd.y;
				R=nd.x;
				if(RH==max) break;
			}
		}
		if(map[0].y==map[N-1].y&&total==0) {
			total+=((map[N-1].x-map[0].x)+1)*map[0].y;
		}else {
			if(L!=R) {
				total+=(Math.abs(L-R)+1)*max;
			}else {
				total+=max;
			}
		}
		System.out.println(total);
		
	}

}
