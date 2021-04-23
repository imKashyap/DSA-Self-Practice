package practice.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParanthesisChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine().trim();
		if (x.isEmpty())
			System.out.println(true);
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{')
				s.push(ch);
			else {
				if (s.empty())
					System.out.println(false);
				else {
					char top = s.peek();
					if (ch == ')' && top == '(' || ch == '}' && top == '{' || ch == ']' && top == '[')
						s.pop();
					else
						System.out.println(false);
				}
			}
		}
		if (s.empty())
			System.out.println(true);
		else
			System.out.println(false);

		br.close();
	}
}
