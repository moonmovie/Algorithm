import java.util.Scanner;

public class N1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int v=0;v<t;v++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int i=0;
			int j=0;
			int w=0;
			int h=N-1;
			int x=N-1;
			int y=0;
			int cnt=N*N;
			int num =1;
			
			while(num<=cnt) {

				for(int r=0+i;r<N-j;r++) {
					arr[i][r]=num;
					num++; 
				}
				i++;
				for(int d=i;d<N-j;d++) {
					arr[d][x]=num;
					num++;
					
				}
				j++;
				x--;
				for(int l=(N-1)-i;l>=0+y;l--) {
					arr[h][l]=num;
					num++;
				}
				y++;
				h--;
				for(int u=N-1-i;u>=i;u--) {
					arr[u][w]=num;
					num++;
				}
				w++;
			}
			
			
			System.out.println("#"+(v+1));
			for(int[] a : arr) {
				for(int r : a) {
					System.out.print(r+" ");
				}
				System.out.println();
			}
			
		}

	}

}
