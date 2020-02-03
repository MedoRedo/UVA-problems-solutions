import java.util.*;
import java.io.*;
public class MinimalRatioTree {
	static PrintWriter out;
	static class Edge implements Comparable<Edge>{
		int from,to;
		int weight;
		public Edge(int u,int v,int w) {
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
	static ArrayList<Edge>edges;
	static int[] nodes;
	static int[] parents;
	static int[]size;
	static int v,e,cost;
	static int nweights[];
	static int adj[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = v = Integer.parseInt(st.nextToken());
		adj = new int[n][n];
		while(n>0) {
			st = new StringTokenizer(br.readLine());
			nweights = new int[n];
			for(int i=0;i<n;i++) {
				nweights[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ansN=0;int ansE=0;
			int ans = 0;
			boolean f = true;
			ArrayList<Integer> perm = gen(n, m);
			for(int e:perm) {
				edges = new ArrayList<>();
				nodes = new int[m];
				int cn = 0;
				for(int j=0;j<16 && cn<m;j++) {
					if((e & 1<<j) == 1<<j) {
						nodes[cn++] = j;						
					}
				}
				int x,y;
				for(int i=0;i<m;i++) {
					x = nodes[i];
					for(int j=i+1;j<m;j++) {
						y = nodes[j];
						edges.add(new Edge(i,j,adj[x][y]));
					}
				}
				int sumN = 0;
				for(int node:nodes) {
					sumN+=nweights[node];
				}
				kruskals();
				int sumE = cost;
				if(ansE*sumN > ansN*sumE || f) {
					ansE = sumE;
					ansN = sumN;
					ans = e;
				}
				f = false;
			}
			f = true;
			for(int k=0;k<n;k++) {
				if((ans & (1<<k)) == 1<<k) {
					if(f)
						out.print(k+1);
					else
						out.print(" "+(k+1));
					f = false;
				}
			}
			out.println();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = v = Integer.parseInt(st.nextToken());
			adj = new int[n][n];			
		}
		out.flush();
	}
	static ArrayList<Integer> gen(int n,int m) {
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=(1<<m)-1;i<1<<n;i++) {
			if(Integer.bitCount(i) == m)
				ans.add((int) i);
		}
		return ans;
	}
	static void kruskals() {
		Collections.sort(edges);
		parents = new int[v];
		size = new int[v];
		for(int i=0;i<v;i++) {
			parents[i] = i;
			size[i] = 1;
		}
		int i,e;
		i = 0;e = 0;
		cost = 0;
		while(e < v-1 && i<edges.size()) {
			Edge edge = edges.get(i++);
			if(isCycle(edge.from, edge.to))
				continue;
			union(find(edge.from),find(edge.to));
			cost+= edge.weight; 
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
