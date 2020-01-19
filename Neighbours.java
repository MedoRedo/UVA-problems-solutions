import java.io.*;
import java.util.*;
import java.awt.Point;
public class Neighbours {
	static PrintWriter out;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;int cnt;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());            	
            int v = Integer.parseInt(st.nextToken());
            TreeSet<Point2> t = new TreeSet<>();
    		Point2 p;int min = v;
            for(int i=0;i<v;i++) {
    			cnt = 0;
    	        st = new StringTokenizer(br.readLine());
    	        while(st.hasMoreTokens()) {
    	        	st.nextToken();
    	        	cnt++;
    	        }
    	        min = Math.min(min, cnt);
    	        p = new Point2(cnt,i+1);
    	        t.add(p);
    		}
            cnt = 0;
            for(Point2 o:t) {
            	if(o.x>min)
            		break;
            	else if(o.x == min) {
            		if(cnt == 0)
                		out.print(o.y);
            		else
            			out.print(" "+o.y);
            		cnt++;
            	}
            }
            out.println();          	
      }
        out.flush();
	}
	static class Point2 extends Point implements Comparable{
		public Point2(int x,int y){
			super(x,y);
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Point p = (Point) o;
			if(x == p.x)
				return y-p.y;
			return x-p.x;
		}
		
	}
}
