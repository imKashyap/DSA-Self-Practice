package practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	// time complexity: O(logn).
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
	}

	private static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] arr1 = new int[mid - l + 1];
		int[] arr2 = new int[r - mid];
		for (int i = 0; i < arr1.length; i++)
			arr1[i] = arr[l + i];
		for (int i = 0; i < arr2.length; i++)
			arr2[i] = arr[mid + i + 1];
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				arr[l] = arr1[i];
				i++;
			} else {
				arr[l] = arr2[j];
				j++;
			}
			l++;
		}
		for (; i < arr1.length; i++, l++)
			arr[l] = arr1[i];
		for (; j < arr2.length; j++, l++)
			arr[l] = arr2[j];
	}

}
