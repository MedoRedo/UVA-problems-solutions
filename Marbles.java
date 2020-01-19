import java.io.*;
import java.util.*;

public class Marbles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int k=0;
		while(true) {
			k++;
			int N=sc.nextInt();
			int Q=sc.nextInt();
			if(N==0 && Q==0) break;
			int a[]=new int[N];
			for(int i=0;i<N;i++) {
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			out.println("CASE# "+k+":");
			for(int i=0;i<Q;i++) {
				int q=sc.nextInt();
				int min=0;int max=N-1;int mid;
				int res = -1;
				while(min<=max) {
					mid=(max+min)/2;
					if(a[mid]>=q) {
						max = mid-1;
						if(a[mid]==q)
							res = mid;
					}else {
						min = mid+1;
					}
				}
				if(res != -1) {
					out.println(q+" found at "+(res+1));
				}else {
					out.println(q+" not found");					
				}
		
			}
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
