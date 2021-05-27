package practice.array;

import java.io.IOException;
import java.util.Scanner;

public class Numerology {

	public static void main(String[] args) throws IOException {
		Scanner scr = new Scanner(System.in);
		String s = scr.nextLine();
		if (!s.toUpperCase().equals(s) || s.contains(" "))
			System.out.println("Invalid name");
		else {
			int[] val = { 1, 2, 3, 4, 5, 8, 3, 5, 1, 1, 2, 3, 4, 5, 7, 8, 1, 2, 3, 4, 6, 6, 6, 5, 1, 7 };
			String[][] a = new String[26][2];
			for (int i = 0; i < a.length; i++) {
				String[] temp = new String[2];
				temp[0] = String.valueOf((char) (i + 65));
				temp[1] = String.valueOf(val[i]);
				a[i] = temp;
			}
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				int indexToLook = (int) (ch - 'A');
				sum += Integer.parseInt(a[indexToLook][1]);
			}
			System.out.println(sum);
		}
		scr.close();

	}

}
