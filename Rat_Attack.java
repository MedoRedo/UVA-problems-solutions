import java.util.*;
import java.io.*;
public class Rat_Attack {

	public static void main(String[] args) throws Exception{
		Scanner sc =new Scanner(System.in);
		PrintWriter out =new PrintWriter(System.out);
		int ns=sc.nextInt();
		while(ns-->0) {
			int d=sc.nextInt();
			int n=sc.nextInt();
			int a[][]=new int[1025][1025];
			int x;int y;int p;
			tri res=new tri(0,0,0);
			for(int i=0;i<n;i++) {
				x=sc.nextInt();y=sc.nextInt();
				p=sc.nextInt();
				for(int j=x-d;j<=x+d;j++) {
					if(j>=0&&j<1025) {
						for(int k=y-d;k<=y+d;k++) {
							if(k>=0&&k<1025) {
								a[j][k]+=p;
								tri tmp =new tri(j,k,a[j][k]);
								if(tmp.compareTo(res)>0)
									res=tmp;
							}
						}
					}
				}
			}
			out.println(res);
		}
		out.flush();
	}
	static class tri implements Comparable{
		int x;
		int y;
		int p;
		public tri(int x,int y,int p) {
			this.x=x;
			this.y=y;
			this.p=p;
		}
		public int compareTo(Object o) {
			tri t=(tri)o;
			if(p>t.p)
				return 1;
			else if(p==t.p){
				if(x<t.x)
					return 1;
			}
				
			return -1;
		}
		public String toString () {
			return x+" "+y+" "+p;
		}
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
