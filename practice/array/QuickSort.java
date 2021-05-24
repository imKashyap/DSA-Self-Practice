package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] temp = line.trim().split("\\s+");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		sort(arr, 0, n - 1);
		StringBuffer sb = new StringBuffer();
		for (int m = 0; m < n; m++)
			sb.append(arr[m] + " ");
		System.out.println(sb);
		br.close();

	}

	private static void sort(int[] arr, int l, int h) {
		if (l < h) {
			int pivot = partition(l, h, arr);
			sort(arr, l, pivot - 1);
			sort(arr, pivot + 1, h);
		}
	}

	private static int partition(int l, int h, int[] arr) {
		int pivot = (l + h) / 2;
		int i = l;
		int j = h;
		while (i < j) {
			while (i <= h && arr[i] <= arr[pivot])
				i++;
			while (j >= l && arr[j] > arr[pivot])
				j--;
			if (i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[j];
		arr[j] = arr[pivot];
		arr[pivot] = t;
		return j;
	}
}
