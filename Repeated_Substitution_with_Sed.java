import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Repeated_Substitution_with_Sed {
	static String alfa[];
	static String gama[];
	static String s2;
	static int min;
	static int n;
	static void rec(String s,int cnt) {
		if(s.equals(s2)) {
			min =Math.min(cnt,min);
			return;
		}
		if(s.length()>s2.length()) return;
		for(int i=0;i<n;i++) {
			String t=gen(s,i);
			if(!s.equals(t))
				rec(t,cnt+1);
		}
	}
	static String gen(String s,int j) {
		String res="";
		int l=s.length();int l2=alfa[j].length();
		for(int i=0;i<l;i++) {
			if(i<=l-l2 && s.substring(i,i+l2).equals(alfa[j])) {
				res+=gama[j];
				i+=l2-1;
			}else {
				res+=s.charAt(i);
			}
		}
		return res;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner("input");
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
		    n =sc.nextInt();
			if(n==0) break;
			alfa=new String[n];gama=new String[n];
			for(int i=0;i<n;i++) {
				alfa[i] = sc.next();
				gama[i] = sc.next();
			}
			min=(int)10e9;
			String s1=sc.next();
			s2=sc.next();
			rec(s1,0);
			if(min==(int)10e9)
				out.println(-1);
			else
				out.println(min);
		}
		out.flush();
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}

}
