import java.io.*;
import java.util.*;
public class Party {
	static PrintWriter out;
	static boolean vis[];
	static ArrayList<Integer>adj[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		adj = new ArrayList[n];
		vis = new boolean[n];
		int p;
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();			
		}
		for(int i=0;i<n;i++) {
			p = sc.nextInt();
			if(p != -1) {
				adj[i].add(p-1);
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
				q.add(i);
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			//out.println(q);
			Queue<Integer> q2 = new LinkedList<>();
			int tmp;
			while(!q.isEmpty()) {
				tmp = q.poll();
				for(int i:adj[tmp]) {
						q2.add(i);
						vis[i] = true;					
				}				
			}
			cnt++;
			q = q2;
		}
		out.println(cnt);
		out.flush();
	}

}
