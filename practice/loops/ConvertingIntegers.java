package practice.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertingIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int givenBase = Integer.parseInt(br.readLine());
        long num = Long.parseLong(br.readLine());
        int toBase = Integer.parseInt(br.readLine());
        long res = 0;
        int i = 0;
        while (num != 0) {
            long rem = num % toBase;
            res += (long) (rem * Math.pow(givenBase, i++));
            num /= toBase;
        }
        System.out.println(res);
        br.close();
    }
}
