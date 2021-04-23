package practice.oops;

public class Test {

	static int x;

	public static void main(String[] ags) {
		String s1 = "Hello";
		String s2 = new String(s1);
		System.out.println((s1 == s2) + " " + s1.equals(s2));

	}

	void increment() {
		x++;
	}

	public static void m1(int i, float f) {
		System.out.println("int float");
	}

	public static void m1(float f, int i) {
		System.out.println(" float int");
	}

}
