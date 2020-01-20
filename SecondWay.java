import java.util.*;
import java.io.*;
public class SecondWay {
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
	static ArrayList<Edge>edges,mst,second;
	static int[] parents;
	static int[]size;
	static int v,e,cost;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int cn = 0;
		while(t-->0) {
			cn++;
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e =Integer.parseInt(st.nextToken());
			int x,y,w;
			edges = new ArrayList<Edge>();
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken())-1;
				y = Integer.parseInt(st.nextToken())-1;
				w = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x,y,w));
			}
			if(e<v-1)
				out.format("Case #%d : No way\n", cn);
			else {
				kruskals();
				if(mst.size()<v-1)
					out.format("Case #%d : No way\n", cn);
				else {
					second = (ArrayList<Edge>) mst.clone();
					boolean f = false;
					Edge tmp;
					int ans = (int)1e9;
					for(int i=0;i<v-1;i++) {
						tmp = second.get(i);
						edges.remove(tmp);
						kruskals();
						if(mst.size() == v-1) {
							f = true;
							ans  = Math.min(ans, cost);
						}
						edges.add(tmp);
					}
					if(f) {
						out.format("Case #%d : %d\n", cn, ans);
					}else {
						out.format("Case #%d : No second way\n", cn);						
					}
				}
				
			}
		}
		
		
		out.flush();

	}
	static void kruskals() {
		mst = new ArrayList<Edge>();
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
			mst.add(edge);
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
