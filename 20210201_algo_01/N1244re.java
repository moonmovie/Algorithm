package homework_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.event.SwingPropertyChangeSupport;

public class N1244re {
	static int[] switchs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		switchs = new int[N+1]; //dummy 0

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<switchs.length;i++) {
			switchs[i]=Integer.parseInt(st.nextToken());
		}
		int P =Integer.parseInt(br.readLine());
		for(int i=0;i<P;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			
			if(gender == 1) {
				for(int m =num;m<switchs.length;m+=num) {
					if(switchs[m]==1) {
						switchs[m]=0;
					}else {
						switchs[m]=1;
					}
				}
			}else {
				if(switchs[num]==1) {
					switchs[num]=0;
				}else {
					switchs[num]=1;
				}
				int plus =2;
				int n=num-1;
				while(true) {
					if(n+plus>=switchs.length||n==0||switchs[n-1]!=switchs[n+plus]) {
						break;
					}
					if(switchs[n]==1) {
						switchs[n]=0;
						switchs[n+plus]=0;
					}else {
						switchs[n]=1;
						switchs[n+plus]=1;
					}
					plus+=2;
					n-=1;
				}
				
			}
		}
		
		for(int i=1;i<switchs.length;i++) {
			sb.append(switchs[i]+" ");
			if(i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
