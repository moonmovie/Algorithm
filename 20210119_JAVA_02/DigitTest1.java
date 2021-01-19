package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []num = new int[10];
		
		while(true) {
			int x = sc.nextInt();
			if(x==0) {break;}
			num[x/10]+=1;
		}
		
		for(int i=0;i<num.length;i++) {
			if(num[i]!=0) {
				System.out.println(i + ":" + num[i]+"개");
			}
		}

	}

}
