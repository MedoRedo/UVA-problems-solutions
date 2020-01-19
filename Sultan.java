import java.util.*;
import java.io.*;
public class Sultan {
	static int a[]={0,1,2,3,4,5,6,7};
	static boolean vis[];
	static int[] curr;
	static PrintWriter out;
	static int max;static int c[][];
	static void permute(int idx) {
		if (idx == 8) {
			boolean f=true;
			for(int i=0;i<8;i++) {
				for(int j=i+1;j<8;j++) {
					if(Math.abs(i-j)==Math.abs(curr[i]-curr[j]))
						f=false;
				}
			}
			int cnt=0;
			if(f) {
				for(int i=0;i<8;i++) {
					cnt+=c[i][curr[i]];
				}
				max = Math.max(max, cnt);
			}
			return;
		}
		for (int i = 0; i <8; i++) {
			if (!vis[i]) {
				vis[i] = true;
				curr[idx] = a[i];
				permute(idx + 1);
				vis[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
		out = new PrintWriter("output");
		int b=sc.nextInt();
		while(b-->0) {
			c=new int[8][8];
			max=-1;
			vis=new boolean[8];
			curr=new int[8];
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
					c[i][j]=sc.nextInt();
			permute(0);
			String s =""+max;
			for(int i=0;i<5-s.length();i++)
				out.print(" ");
			out.println(max);
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
