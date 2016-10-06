package com.vinhuang.main;

import java.util.HashMap;
import java.util.Map;

public class Translator {

	/**
	 * Problem: Given a pattern and a text input 
	 * e.g: [a b a b] and [cat dog cat dog]
	 * 
	 * Find whether they have the same pattern. In the above case,
	 * output should be true
	 */
	public static void main(String[] args) {
		String[] pattern = {"a", "b", "a", "b"};
		String[] input = {"cat", "dog", "cat", "dog"};
		System.out.print("Pattern: ");
		for(int i = 0; i < pattern.length; i++) {
			System.out.print(pattern[i] + " ");
		}
		System.out.print("\nInput: ");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println("\nResult: " + determinePattern(pattern, input));

	}
	
	/**
	 * Main method. Convert the pattern and input to a map.
	 * Use the key from the map to find similarities
	 * 
	 * @param pattern
	 * @param input
	 * @return
	 */
	public static boolean determinePattern(String[] pattern, String[] input) {
		if(pattern.length <= 0 || input.length <= 0) {
			return false;
		}
		if(pattern.length != input.length) {
			return false;
		}
		Integer[] patternCv = convertToKey(pattern);
		Integer[] inputCv = convertToKey(input);
		int count = 0;
		for(int i = 0; i < patternCv.length; i++) {
			if(patternCv[i] == inputCv[i]) {
				count++;
			}
		}
		return count == pattern.length ? true : false;
	}
	
	/**
	 * Convert data to map and retrieve the key. We are using uniqeness of Map properties;
	 * therefore, same-pattern texts will be converted to same-key values, and can be used
	 * as a pattern to text translator
	 * 
	 * @param data
	 * @return
	 */
	public static Integer[] convertToKey(String[] data) {
		Integer[] result = new Integer[data.length];
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for(int i = 0; i < data.length; i++) {
			dictionary.put(data[i], i);
		}
		for(int i = 0; i < data.length; i++) {
			result[i] = dictionary.get(data[i]);
		}
		return result;
	}

}
