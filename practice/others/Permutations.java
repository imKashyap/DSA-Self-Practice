package practice.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutations {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] temp = line.trim().split("\\s+");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		int result;
		result = minimumChanges(arr);
		System.out.println(result);
		return;
	}

	public static int minimumChanges(int[] arr) {
		int ans = 0;
		Arrays.sort(arr);
		String s = "";
		for (int i = 0; i < arr.length; i++)
			s += arr[i];
		for (int i = 0; i < s.length(); i++) {
			int e = Integer.parseInt(s.substring(i, i + 1));
			if (e > i + 1)
				return -1;
			else if (e < i + 1) {
				char ch = Character.forDigit(i + 1, 10);
				int pos = s.indexOf(ch);
				if (pos > i) {
					StringBuffer sb = new StringBuffer(s);
					sb.setCharAt(i, ch);
					sb.setCharAt(pos, Character.forDigit(e, 10));
					s = sb.toString();
				} else
					ans++;
			}
		}
		return ans;
	}
}
