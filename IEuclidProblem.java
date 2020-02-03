import java.io.*;
import java.util.*;
public class IEuclidProblem {
	static long arr[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		arr = new long[2];
		while(true) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			arr[0] = 0;
			arr[1] = 1;
			long gcd = gcd(n, m);
			if(n == m)
				Arrays.sort(arr);
			out.println(arr[0]+" "+arr[1]+" "+gcd);
			if(!br.ready()) break;
		}
		out.flush();
	}
	static long gcd(long a,long b) {
		if(a == 0) {
			return b;			
		}
		long ans =  gcd(b % a,a);
		arr[1] = arr[0];
		arr[0] = (ans -arr[1]*b)/a;			
		return ans;
	}

}
