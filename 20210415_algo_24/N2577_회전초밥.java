package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N2577_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		int[] kind = new int[d+1];
		HashMap<Integer, Integer> hash;
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(br.readLine());
		}
		int total=0;
		int max=0;
		for(int i=0;i<k;i++) {
			if(kind[map[i]]==0) total++;
			kind[map[i]]++;
		}
		max=total;
		
		for(int i=1;i<N;i++) {
			if(max<=total) {
				if(kind[c]==0) {
					//쿠폰사용
					max=total+1;
				}else {
					max=total;
				}
			}
			
			kind[map[i-1]]--;
			if(kind[map[i-1]]==0) total--;
			
			if(kind[map[(i+k-1)%N]]==0) total++;
			kind[map[(i+k-1)%N]]++;
		}
		
		System.out.println(max);
	}

}
 