package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class N1828_냉장고 {
	static class Refi implements Comparable<Refi>{
		int low,high;

		public Refi(int low, int high) {
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Refi o) {
			
			return this.high-o.high;
		}

		@Override
		public String toString() {
			return "Refi [low=" + low + ", high=" + high + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Refi[] arr = new Refi[t];
		int cnt=1;
		boolean[] check = new boolean[t];
		for(int i=0;i<t;i++) {
			arr[i]=new Refi(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(arr);
		Refi temp =arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i].low>temp.high) {
				cnt++;
				temp=arr[i];
			}
		}
		
		System.out.println(cnt);
	}

}
