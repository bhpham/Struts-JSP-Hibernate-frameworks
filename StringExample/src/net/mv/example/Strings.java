package net.mv.example;

import java.util.HashSet;
import java.util.Set;

public class Strings {
	
	/*
	 * Concat String and remove duplicates
	 */
	public String concatString(String s1, String s2) {
		
		if (s1 == null || s2 == null)
			return null;
		
		String s = "";
		Set<Character> set = new HashSet<Character>();
		for (int i = 0 ; i < s1.length(); i++){
			set.add(s1.charAt(i));
		}
		for (int j = 0; j < s2.length(); j++){
			set.add(s2.charAt(j));
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : set)
			stringBuilder.append(c);
		return stringBuilder.toString();
	}
}
