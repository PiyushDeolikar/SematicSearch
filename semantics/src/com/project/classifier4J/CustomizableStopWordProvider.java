package com.project.classifier4J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.project.classifier4J.util.*;

public class CustomizableStopWordProvider implements IStopWordProvider {

	private Resource resource;
	private String[] words;

	public static final String DEFAULT_STOPWORD_PROVIDER_RESOURCENAME = "defaultStopWords.txt";

	/**
	 * 
	 * @param filename
	 *            Identifies the name of a textfile on the classpath that
	 *            contains a list of stop words, one on each line
	 */
	public CustomizableStopWordProvider(String resourcename) throws IOException {
		resource = new Resource(resourcename);

		init();
	}

	public CustomizableStopWordProvider() throws IOException {
		this(DEFAULT_STOPWORD_PROVIDER_RESOURCENAME);
	}

	protected void init() throws IOException {
		ArrayList wordsLst = new ArrayList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resource.getInputStream()));

		String word;
		while ((word = reader.readLine()) != null) {
			wordsLst.add(word.trim());
		}

		words = (String[]) wordsLst.toArray(new String[wordsLst.size()]);

		Arrays.sort(words);
	}

	/**
	 * @see com.project.classifier4J.IStopWordProvider#isStopWord(java.lang.String)
	 */
	public boolean isStopWord(String word) {
		return (Arrays.binarySearch(words, word) >= 0);
	}

}