package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5643_키순서 {

	static int res,cnt;
	static int N;
	static boolean[] v;
	static ArrayList<Integer>[] in;
	static ArrayList<Integer>[] out;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=TC;t++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			res=0;
			in = new ArrayList[N+1];
			out = new ArrayList[N+1];
			for(int i=0;i<=N;i++) {
				in[i] = new ArrayList<>();
				out[i] = new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				in[a].add(b);
				out[b].add(a);
			}
			
			for(int i=1;i<=N;i++) {
				check(i);
				
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	public static void check(int idx) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(idx);
		boolean visited[] = new boolean[N+1];
		visited[idx] = true;
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : in[now]) {
				if(visited[i])
					continue;
				visited[i] = true;
				cnt++;
				que.offer(i);
			}
		}
		
		que.offer(idx);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : out[now]) {
				if(visited[i])
					continue;
				visited[i] = true;
				cnt++;
				que.offer(i);
			}
		}
		
		if(cnt==N-1) 
			res++;
	}
	

}
