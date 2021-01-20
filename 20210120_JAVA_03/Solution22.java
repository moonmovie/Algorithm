package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		int alive =0;
		
		for(int in=0;in<line;in++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());
			boolean[][] check = new boolean[N][N];
			for(int i=0;i<P;i++) {
				StringTokenizer run = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(run.nextToken());
				int y = Integer.parseInt(run.nextToken());
				int d = Integer.parseInt(run.nextToken());
				if(d==1) {
					if(x-6>=0 && check[x-6][y]==false) {
						alive+=1;
						check[x-6][y]=true;
					}
				}else if(d==2) {
					if(x+6<N && check[x+6][y]==false) {
						alive+=1;
						check[x+6][y]=true;
					}
				}else if(d==3) {
					if(y-6>=0 && check[x][y-6]==false) {
						alive+=1;
						check[x][y-6]=true;
					}
				}else if(d==4) {
					if(y+6<N && check[x][y+6]==false) {
						alive+=1;
						check[x][y+6]=true;
					}
				}
			}
			System.out.println("#"+(in+1)+" "+alive);
			alive=0;
			
			
		}

	}

}
