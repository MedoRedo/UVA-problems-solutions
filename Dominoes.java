import java.util.*;
import java.io.*;
public class Dominoes {
	static boolean f;
	static void rec(int a[][],int n,int sy,int ex) {
		if(n==1) {
			if(a[sy][ex]>0)
				f=true;
			return;
		}
		for(int i=0;i<14;i++) {
			if(a[sy][i]>0) {
				a[sy][i]--;a[i][sy]--;
				rec(a,n-1,i,ex);
				a[sy][i]++;a[i][sy]++;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n=sc.nextInt();
			if(n==0) break;
			int m=sc.nextInt();
			f=false;
			int a[][]=new int[14][14];
			int sx=sc.nextInt();int sy=sc.nextInt();
			int ex=sc.nextInt();int ey=sc.nextInt();
			for(int i=0;i<m;i++) {
				int x=sc.nextInt();int y=sc.nextInt();
				a[x][y]++;a[y][x]++;
			}
			rec(a,n,sy,ex);
			if(f) out.println("YES");
			else out.println("NO");
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
