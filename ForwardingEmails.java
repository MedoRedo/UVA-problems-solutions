import java.io.*;
import java.util.*;
public class ForwardingEmails {
	static PrintWriter out;
	static int vis[],reach[];
	static int adj[];
	static int cycle;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int cn = 0;
		while(t-->0) {
			cn++;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			adj = new int[n];
			vis = new int[n];
			reach = new int[n];
			int from,to;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken())-1;
				to = Integer.parseInt(st.nextToken())-1;
				adj[from]=to;
			}
			int max = 0;int ans = 0;
			for(int i=0;i<n;i++) {
				if(vis[i] == 0) {
					dfs(i);
				}
			}
			for(int i=0;i<n;i++) {
				if(max < reach[i]) {
					max = reach[i];
					ans = i;
				}
			}
			out.println(Arrays.toString(adj));
			out.println(Arrays.toString(reach));
			out.println("Case "+cn+": "+(ans+1)+" "+max);
		}
		out.flush();
	}
	static void dfscycle(int node) {
		vis[node] = 1;
		cycle++;
		int next = adj[node]; 
		if(vis[next] == -1) {
			dfscycle(next);
		}else {
			reach[node] = cycle;
		}
	}
	static void dfs(int node) {
		vis[node] = -1;
		int next = adj[node]; 
		if(vis[next] == 0) {
			dfs(next);
			if(vis[next] > 1)
				reach[node] = reach[next];
			else {
				reach[node] = reach[next]+1;				
			}
		}else if(vis[next] == -1) {	
			cycle = -1;
			dfscycle(next);
		}else
			reach[node] = reach[next]+1;
		vis[node]+=2;		
	}
}
