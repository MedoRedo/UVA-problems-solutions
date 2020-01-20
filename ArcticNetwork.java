import java.util.*;
import java.io.*;
import java.awt.Point;
public class ArcticNetwork {
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
	static int[] parents;
	static int[]size;
	static Point[] outposts;
	static Edge[] edges,mst;
	static int p,v;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int s;
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			p = v =Integer.parseInt(st.nextToken());
			int x,y;
			outposts = new Point[p];
			for(int i=0;i<p;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				outposts[i] = new Point(x,y);
			}
			int length = p*(p+1)/2-p;
			edges = new Edge[length];
			Point outpost,outpost2;
			int k = 0;
			for(int i=0;i<p;i++) {
				outpost = outposts[i];
				for(int j=i+1;j<p;j++) {
					outpost2 = outposts[j];
					edges[k++] = new Edge(i,j,calDistance(outpost, outpost2));
				}
			}
			kruskals();
			out.format("%.2f\n",mst[p-s-1].weight);
		}
		
		
		out.flush();
	}
	static double calDistance(Point p1, Point p2) {
		int dx = p1.x-p2.x;
		int dy = p1.y-p2.y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	static void kruskals() {
		mst = new Edge[v-1];
		Arrays.sort(edges);
		parents = new int[v];
		size = new int[v];
		for(int i=0;i<v;i++) {
			parents[i] = i;
			size[i] = 1;
		}
		int i,e;
		i = 0;e = 0;
		while(e < v-1) {
			Edge edge = edges[i++];
			if(isCycle(edge.from, edge.to))
				continue;
			union(find(edge.from),find(edge.to));
			mst[e] = edge;
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
