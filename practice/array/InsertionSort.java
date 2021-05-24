package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
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
		for (int i = 1; i < n; i++) {
			int tmp = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > tmp; j--)
				arr[j + 1] = arr[j];
			arr[j + 1] = tmp;
		}

	}
}
