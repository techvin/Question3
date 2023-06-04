/*
 * Program to to produce a count of all the different "words" in a text file
 */
package question3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {

	public static void main(String[] args) throws Exception {
		File f = new File(WordCount.class.getResource("data.txt").getFile());
		// Get path to the file
		Path filePath = Paths.get(f.getAbsolutePath());
		List<String> wordsList = new ArrayList<String>();
		HashMap<String, Integer> wordCountMap = new HashMap<>();

		try {
			// Read all lines of the file
			List<String> lines = Files.readAllLines(filePath);
			// Add all the words to the wordsList arraylist
			for (String line : lines) {
				wordsList.addAll(Arrays.asList(line.split(" ")));
			}
		} catch (IOException ex) {
			// Catch any exceptions ie. in this case NoSucFileException
			System.out.format("I/O error: %s%n", ex);
		}

		// wordCountMap will have word against it's count
		for (String word : wordsList) {
			if (!wordCountMap.containsKey(word)) {
				wordCountMap.put(word, 1);
			} else {
				wordCountMap.put(word, wordCountMap.get(word) + 1);
			}
		}

		// print the output in wordCount <space> word format
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}
}
