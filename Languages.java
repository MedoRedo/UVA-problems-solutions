import java.util.*;
import java.io.*;
public class Languages {
	static PrintWriter out;
	static boolean vis[];
	static ArrayList<Integer>adj[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		out =  new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n,m;
		n = sc.nextInt();m = sc.nextInt();
		int l;
		ArrayList<Integer> lang[] =  new ArrayList[m];
		for(int i=0;i<m;i++) {
			lang[i] = new ArrayList<>();
		}
		int zero = 0;
		for(int i=0;i<n;i++) {
			l = sc.nextInt();
			if(l == 0)
				zero++;
			while(l-->0) {
				lang[sc.nextInt()-1].add(i);
			}
		}
		adj= new ArrayList[n];
		vis = new boolean[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();
		}
		ArrayList<Integer>tmp;
		for(int i=0;i<m;i++) {
			tmp = lang[i];
			for(int j=0;j<tmp.size();j++) {
				for(int k=j+1;k<tmp.size();k++) {
					adj[tmp.get(j)].add(tmp.get(k));
					adj[tmp.get(k)].add(tmp.get(j));
				}				
			}
		}
		int cnt = 0;
		vis = new boolean[n];
		for(int i=0;i<n;i++) {
			if(!vis[i]) {
				dfs(i);
				cnt++;	
			}
		}
		if(zero == cnt)
			out.println(zero);
		else
			out.println(cnt-1);
		out.flush();
	}
	static void dfs(int node) {
		vis[node]  = true;		
		//out.print((node+1)+" ---> ");
		for(int v:adj[node]) {
			if(!vis[v]) {
				dfs(v);
			}
		}
	}

}
