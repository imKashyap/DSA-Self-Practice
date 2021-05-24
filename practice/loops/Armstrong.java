package practice.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armstrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int low = Integer.parseInt(br.readLine());
        int high = Integer.parseInt(br.readLine());
        for (int i = low; i <= high; i++) {
            if (isArmstrong(i)) System.out.print(i + " ");
        }
        br.close();
    }

    public static boolean isArmstrong(int n) {
        int input = String.valueOf(n).length();
        int sum = 0, cpy = n;
        while (n != 0) {
            int dig = n % 10;
            sum += (int) Math.pow(dig, input);
            n /= 10;
        }
        return sum == cpy;
    }
}
