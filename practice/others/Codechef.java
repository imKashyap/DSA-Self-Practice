package practice.others;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Codechef {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					} else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	private static int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		PrintWriter writer = new PrintWriter(System.out);
		int t = s.nextInt();
		while (t-- != 0) {
			int n = s.nextInt();
			for (int i = 0; i < n - 1; i++) {
				String to = s.readLine();
				String[] toi = to.trim().split("\\s+");
				long l = Long.parseLong(toi[0]);
				long r = Long.parseLong(toi[1]);
				ArrayList<Long> l1 = new ArrayList<Long>();
				l1.add(r);
				ArrayList<Long> l2 = new ArrayList<Long>();
				l2.add(l);
				v.add((int) l, l1);
				v.add((int) r, l2);
			}
			dfs(1, 1);
			long ans = tot.get(1) % mod;
			writer.println(ans);
			dp.clear();
			v.clear();
			tot.clear();
		}
		writer.flush();
		s.close();
	}

	private static ArrayList<ArrayList<Long>> v = new ArrayList<>();
	private static ArrayList<Long> dp = new ArrayList<>();
	private static ArrayList<Long> tot = new ArrayList<>();

	private static void dfs(int cur, int par) {
		dp.add(cur, 1l);
		tot.add(cur, 1l);
		long sum = 0;
		for (int i = 0; i < v.get(cur).size(); i++) {
			long node = v.get(cur).get(i);
			if (node != par) {
				dfs((int) node, cur);
				long temp = dp.get(cur);
				temp += ((2 * dp.get((int) node)) % mod);
				dp.set(cur, temp);
				temp = dp.get(cur);
				temp %= mod;
				dp.set(cur, temp);
				temp = tot.get(cur);
				temp += tot.get((int) node);
				temp = temp % mod;
				temp += dp.get((int) node);
				temp = temp % mod;
				tot.set(cur, temp);
				sum += dp.get((int) node);
			}
		}
		for (int i = 0; i < v.get(cur).size(); i++) {
			long node = v.get(cur).get(i);
			if (node != par) {
				long val = (dp.get((int) node) * ((sum - dp.get((int) node) + mod) % mod)) % mod;
				long temp = tot.get(cur);
				temp += val;
				temp %= mod;
				tot.set(cur, temp);
			}
		}
	}

}
