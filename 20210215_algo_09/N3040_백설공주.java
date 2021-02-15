import java.util.Scanner;

public class N3040_백설공주 {
	
	static int[] p;
	static boolean[] v;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p = new int[9];
		result = new int[7];
		v = new boolean[9];
		
		for(int i=0;i<p.length;i++) {
			p[i]=sc.nextInt();
		}
		combi(0,0);

	}
	public static void combi(int n, int start) {
		if(n==7) {
			int total=0;
			for(int a: result) {
				total+=a;
			}
			if(total==100) {
				for(int a: result) {
					System.out.println(a);
				}
			}
			return;
		}
		
		for(int i=start;i<p.length;i++) {
			result[n]=p[i];
			combi(n+1,i+1);
		}
	}

}
