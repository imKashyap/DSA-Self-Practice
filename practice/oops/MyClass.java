package practice.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		Account[] t = new Account[4];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int a = sc.nextInt();
			sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			double d = sc.nextDouble();
			t[i] = new Account(a, b, c, d);
		}
		sc.nextLine();
		String x = sc.nextLine();
		double y = sc.nextDouble();
		int ans = countAccountsByName(x, t);
		if (ans == 0)
			System.out.println("No Account found with given account name");
		else
			System.out.println(ans);
		Account[] s = searchAccountsByBalance(y, t);
		if (s == null)
			System.out.println("No such Account exists");
		else {
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i].getAccountName());
			}
		}
		sc.close();
	}

	static int countAccountsByName(String name, Account[] accounts) {
		int count = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (name.equals(accounts[i].getAccountName()))
				count++;
		}
		return count;
	}

	static Account[] searchAccountsByBalance(double bal, Account[] accounts) {
		HashMap<Double, Account> map = new HashMap<>();
		ArrayList<Double> arr = new ArrayList<>();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getAccountBalance() >= bal) {
				arr.add(accounts[i].getAccountBalance());
				map.put(accounts[i].getAccountBalance(), accounts[i]);
			}
		}
		Double[] a = new Double[arr.size()];
		a = arr.toArray(a);
		Arrays.sort(a);
		Account[] accs = new Account[a.length];
		for (int i = 0; i < a.length; i++) {
			Account ac = map.get(a[i]);
			accs[i] = ac;
		}
		return accs.length == 0 ? null : accs;
	}

}
