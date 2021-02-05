import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N0205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			String s= br.readLine();
			Stack<Character> stack = new Stack<>();
			String sik = new String();
			
			for(int i=0;i<s.length();i++) {
				char ch=s.charAt(i);
				if(ch!='+'&&ch!='*') {
					sik+=s.charAt(i);
					continue;
				}
				if(ch=='+') {
					if(!stack.isEmpty()) {
						if(stack.peek()=='+') {
							sik+=ch;
						}else {
							sik+=stack.pop();
							while(!stack.isEmpty()&&stack.peek()=='*') {
								sik+=stack.pop();
								if(!stack.isEmpty()&&stack.peek()=='+')break;
							}
							stack.push(ch);
						}
						continue;
					}
					stack.push(ch);
				}else {
					stack.push(ch);
				}	
			}
			while(!stack.isEmpty()) {
				sik+=stack.pop();
			}
			
			Stack<Integer> num = new Stack<>();
			//후위연산자 연산 시작
			for(int i=0;i<sik.length();i++) {
				char cal=sik.charAt(i);
				if(cal=='+') {
					num.push((int)(num.pop())+(int)(num.pop()));
				}else if(cal=='*') {
					num.push((int)(num.pop())*(int)(num.pop()));
				}else {
					num.push(cal-'0');
				}
			}
			sb.append("#"+t+" "+num.pop()+"\n");
		}
		System.out.println(sb.toString());
	}
}