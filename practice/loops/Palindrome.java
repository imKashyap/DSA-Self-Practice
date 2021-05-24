package practice.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int low = Integer.parseInt(br.readLine());
        int high = Integer.parseInt(br.readLine());
        for (int i = low; i <= high; i++) {
            if (isPalindrome(i)) System.out.print(i + " ");
        }
        br.close();
    }

    public static boolean isPalindrome(int n) {
        String input = String.valueOf(n);
        for (int i = 0, j = input.length() - 1; i != j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) return false;
        }
        return true;
    }
}
