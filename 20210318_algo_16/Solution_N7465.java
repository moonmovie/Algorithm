package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_N7465 {

	static int[] p;
	public static int find(int a) {
	        if(p[a] == a) {
	            return a;
	        }
	        return p[a] = find(p[a]); 
	}
	
	public static void union(int a, int b) {
		 a = find(a);
	        b = find(b);
	        if(a == b) {
	            return;
	        }
	        p[b] = a;
			
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p= new int[N+1];
			for(int i=1;i<N+1;i++) {
				p[i]=i;
			}
			ArrayList<Integer> list;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				list = new ArrayList<>();
				while(st.hasMoreTokens()) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				if(list.size()==2) {
					union(list.get(0),list.get(1));
					
				}
				
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<N+1; i++) {
				if(find(i)==i) {
					set.add(i);
				}
//				set.add(find(i));
			}
			sb.append("#"+t+" "+set.size()+"\n");
		}
		System.out.println(sb.toString());
	}

}
