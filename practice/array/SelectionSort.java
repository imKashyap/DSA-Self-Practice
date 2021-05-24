package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
	// time complexity: O(n^2).
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] temp = line.trim().split("\\s+");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		sort(arr);
		StringBuffer sb = new StringBuffer();
		for (int m = 0; m < n; m++)
			sb.append(arr[m] + " ");
		System.out.println(sb);
		br.close();
	}

	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int ind = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[ind] > arr[j])
					ind = j;
			}
			if (ind != i) {
				int t = arr[i];
				arr[i] = arr[ind];
				arr[ind] = t;
			}
		}
	}
}
