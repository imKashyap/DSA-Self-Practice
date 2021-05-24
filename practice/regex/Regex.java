package practice.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String args[]) {
		// The regex pattern
		final String REGEX_PATTERN = "fooa*bar";
		final String inputFileName = "regex01.txt";
		// Create a Pattern object
		Pattern r = Pattern.compile(REGEX_PATTERN);

		// Read the input file line by line
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(Regex.class.getClassLoader().getResourceAsStream(inputFileName)))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				// Now create matcher object.
				Matcher m = r.matcher(line);

				// Apply the regex pattern to each line
				// If pattern matches, output the current line.
				if (m.find()) {
					System.out.println(line);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
