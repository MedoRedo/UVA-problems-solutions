import java.util.*;
import java.io.*;
public class KingsPath {
	static PrintWriter out;
	static TreeSet<Pair> hs;
	static TreeSet<Pair> vis;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		hs = new TreeSet<>();
		vis = new TreeSet<>();
		Pair start = new Pair(sc.nextInt(),sc.nextInt());
		Pair end = new Pair(sc.nextInt(),sc.nextInt());
		int seg = sc.nextInt();
		int r,a,b;
		for(int i=0;i<seg;i++) {
			r = sc.nextInt();a = sc.nextInt();b = sc.nextInt();
			for(int j=a;j<=b;j++)
				hs.add(new Pair(r,j));
		}
		vis.add(start);
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		int cnt = 0;
		boolean f = false;
		while(!q.isEmpty() && !f) {
			Queue<Pair> q2 = new LinkedList<>();
			Pair t,p;
			while(!q.isEmpty() && !f) {
				t = q.poll();
				p = new Pair(t.x+1,t.y);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x-1,t.y);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x,t.y+1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x,t.y-1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x+1,t.y+1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x-1,t.y-1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x+1,t.y-1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}
				p = new Pair(t.x-1,t.y+1);
				if(hs.contains(p) && !vis.contains(p)) {
					if(p.equals(end))
						f = true;
					q2.add(p);
					vis.add(p);
				}

			}
			cnt++;
			q = q2;
		}
		if(f)
			out.println(cnt);
		else
			out.println(-1);		
		out.flush();

	}
	static boolean check(int r,int c) {
		return (r>-1 && r<8 && c>-1 && c<8);
	}
	static class Pair implements Comparable {
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Pair ob = (Pair) o;
			if(x > ob.x) {
				return 1;
			}else if(x < ob.x) {
				return -1;
			}else {
				if(y > ob.y) {
					return 1;
				}else if(y < ob.y){
					return -1;
				}
				return 0;
			}
		}
		public String toString() {
			return x+" , "+y;
		}
		public boolean equals(Object o) {
			Pair p = (Pair) o;
			return p.x == x && p.y == y;
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
