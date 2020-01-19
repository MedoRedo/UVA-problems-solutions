import java.util.*;
import java.io.*;
import java.awt.Point;
public class EternalVictory {
	static PrintWriter out;
	static boolean vis[];
	static ArrayList<Point>adj[];
	static long distance,maxdis;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out =  new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		adj = new ArrayList[n];
		vis = new boolean[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();
		}
		int to,from,w;
		Point p;
		for(int i=0;i<n-1;i++) {
			from = sc.nextInt()-1;
			to = sc.nextInt()-1;
			w = sc.nextInt();
			p = new Point(to,w);
			adj[from].add(p);
			p = new Point(from,w);
			adj[to].add(p);
		}
		distance = 0l;
		dfs(0,0l);
		out.println(distance-maxdis);
		out.flush();
	}
	static void dfs(int node,long s) {
		//out.print((node+1)+" ---> ");
		vis[node]  = true;
		for(Point v:adj[node]) {
			distance+=v.y;
			if(!vis[v.x]) {
				dfs(v.x,s+v.y);
			}else {
				maxdis = Math.max(s, maxdis);
			}
		}
	}

}
