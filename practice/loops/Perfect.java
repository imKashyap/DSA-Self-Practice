package practice.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Perfect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int low = Integer.parseInt(br.readLine());
        int high = Integer.parseInt(br.readLine());
        for (int i = low; i <= high; i++) {
            if (isPerfect(i)) System.out.print(i + " ");
        }
        br.close();
    }

    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sum = sum + i;
        }
        return sum == n;
    }

}
