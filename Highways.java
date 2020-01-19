import java.util.*;
import java.awt.Point;
import java.io.*;
public class Highways {
	static PrintWriter out;
	static class Edge implements Comparable<Edge>{
		int from,to;
		double weight;
		public Edge(int u,int v,double w) {
			from = u;
			to = v;
			weight = w;
		}
		public String toString() {
			return (from+1)+" "+(to+1)+" "+weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(weight > o.weight)
				return 1;
			else if(weight < o.weight)
				return -1;
			else if(from > o.from)
				return 1;
			else if(from < o.from)
				return -1;
			else if(to > o.to)
				return 1;
			else if(to < o.to)
				return -1;
			return 0;
		}
		public boolean equals(Edge o) {
			return from == o.from && to == o.to && weight == o.weight;
		}
	}
	static Edge[] edges;
	static int[] parents;
	static int[]size;
	static int n,e,nh;
	static ArrayList<Edge> mst;
	static Point cities[];
	static boolean vis[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//long starttime = System.currentTimeMillis();
		//out = new PrintWriter("output");
		//BufferedReader br = new BufferedReader(new FileReader("input"));
		out  = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		while(q-->0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			cities = new Point[n];
			vis = new boolean[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cities[i] = new Point(x,y);
			}
			mst = new ArrayList<>();
			parents = new int[n];
			size = new int[n];
			for(int i=0;i<n;i++) {
				parents[i] = i;
				size[i] = 1;
			}
			st = new StringTokenizer(br.readLine());
			nh = Integer.parseInt(st.nextToken());
			int from,to;
			for(int i=0;i<nh;i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken())-1;
				to = Integer.parseInt(st.nextToken())-1;
				union(from, to);
				vis[from][to] = vis[to][from] = true;
			}
			e = (n*(n+1)/2)-n;
			edges = new Edge[e];
			Point u,v;
			int k = 0;
			for(int i=0;i<n;i++) {
				u = cities[i];
				for(int j=i+1;j<n;j++) {
					v = cities[j];
					edges[k++] = new Edge(i,j,calDistance(u, v));
				}
			}
			kruskals();
			if(mst.isEmpty()) {
				out.println("No new highways need");
			}else {
				for(Edge ed:mst) {
					out.println((ed.from+1)+" "+(ed.to+1));
				}
			}
			if(q>0)
				out.println();
		}
		//long endtime = System.currentTimeMillis();
		//System.out.println(endtime - starttime);
		out.flush();
	}
	static double calDistance(Point p1, Point p2) {
		int dx = p1.x-p2.x;
		int dy = p1.y-p2.y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	static void kruskals() {
		Arrays.sort(edges);
		int i,e;
		i = 0;e = 0;
		while(e < n-1) {
			Edge edge = edges[i];
			i++;
			int x = edge.from;int y = edge.to;
			if(isCycle(x, y)){
				if(vis[x][y])
					e++;
				continue;
			}
			union(find(x),find(y));
			mst.add(edge);
			e++;
		}
	}
	static int find(int u) {
		if(parents[u] == u) {
			return u;
		}else {
			parents[u] = find(parents[u]);
			return parents[u];
		}
	}
	static void union(int u,int v) {
		u = find(u);
		v = find(v);
		if(size[u] > size[v]) {
			parents[v] = u;
			size[u] += size[v];
		}else {
			parents[u] = v;
			size[v] += size[u];
		}
	}
	static boolean isCycle(int u, int v) {
		return find(u) == find(v);
	}

}
