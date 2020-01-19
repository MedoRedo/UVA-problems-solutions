import java.io.*;
import java.util.*;

public class Forest {
	static PrintWriter out;
	static ArrayList<Integer>adj [] = new ArrayList[26];
	static int vis[] = new int[26];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-->0) {
			for(int i=0;i<26;i++) {
				vis[i] = -1;
				adj[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine(),"(,)");
			String s = st.nextToken();
			int from,to;
			while(s.charAt(0) != '*') {
				from = s.charAt(0)-'A';
				to = st.nextToken().charAt(0)-'A';
				adj[from].add(to);
				adj[to].add(from);
				st = new StringTokenizer(br.readLine(),"(,)");
				s = st.nextToken(); 
			}
			st = new StringTokenizer(br.readLine(),"(,)");
			while(st.hasMoreTokens()) {
				int i = st.nextToken().charAt(0)-'A';
				vis[i]++;
			}
			int tree = 0;int acorn = 0;
			for(int i = 0;i<26;i++) {
				if(vis[i] == 0 ) {
					if(adj[i].isEmpty()) {
						vis[i] = 1;
						acorn++;						
					}else {
						tree++;
						dfs(i);
					}
				}
			}			
			out.println("There are "+tree+" tree(s) and "+acorn+" acorn(s).");
		}
		out.flush();
	}
	static void dfs(int node) {
		vis[node]  = 1;		
		for(int v:adj[node]) {
			if(vis[v] == 0) {
				dfs(v);
			}
		}
	}
}
