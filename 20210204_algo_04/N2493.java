import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2493 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int token = Integer.parseInt(st.nextToken());
			int b[];
			if(!stack.isEmpty()) {
				b=stack.peek();
				if(b[1]<token) {
					stack.pop();
					while(true) {
						if(stack.isEmpty()) {
							sb.append(0+" ");
							stack.push(new int[]{i+1,token});
							break;
						}
						b=stack.peek();
						if(b[1]<token) {
							stack.pop();
						}else {
							sb.append(b[0]+" ");
							stack.push(new int[]{i+1,token});
							break;
						}
					}
				}else {
					sb.append(b[0]+" ");
					stack.push(new int[]{i+1,token});
				}
			}else {
				stack.push(new int[]{i+1,token});
				sb.append(0+" ");
			}
		}
		System.out.println(sb.toString()+"\n");
	}

}
