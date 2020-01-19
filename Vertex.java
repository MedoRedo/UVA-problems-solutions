import java.io.*;
import java.util.*;
public class Vertex {
	static PrintWriter out;
	static ArrayList<Integer> adj[];
	static boolean vis[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		while(v!=0) {
			adj = new ArrayList[v];
			int to,from;
			from = sc.nextInt();
			for(int i=0;i<v;i++) {
				adj[i] = new ArrayList<>();
			}
			while(from!=0) {
				to = sc.nextInt();
				while(to!=0) {
					adj[from-1].add(to-1);
					to = sc.nextInt(); 
				}
				from = sc.nextInt();
			}
			int q = sc.nextInt();int tmp;
			while(q-->0) {
				vis = new boolean[v];
				tmp = sc.nextInt()-1;
				if(tmp<v)
					dfs(tmp);
				int cnt = 0;
				ArrayList<Integer> a = new ArrayList<>();
				for(int i=0;i<v;i++) {
					if(!vis[i]) {
						cnt++;
						a.add(i+1);
					}
				}
				out.print(cnt);
				boolean f = true;
				for(int e:a) {
					out.print(" "+e);
				}
				out.println();
			}
			v = sc.nextInt(); 
		}
		out.flush();
	}
	static void dfs(int node) {
		//out.print((node+1)+" ---> ");
		//System.out.println(node);
		for(int v:adj[node]) {
			if(!vis[v]) {
				vis[v]  = true;		
				dfs(v);
			}
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
		public int [] iarray(int n) throws IOException {
			int [] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}
		public long [] larray(int n) throws IOException {
			long [] a = new long[n];
			for(int i=0;i<n;i++) {
				a[i] = Long.parseLong(next());
			}
			return a;
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
