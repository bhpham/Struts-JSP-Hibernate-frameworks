package net.mv.test;

import net.mv.example.Strings;

public class driver {
	
	
	public static void main(String[] args) {
		
		String s1 = "horse";
		String s2 = "rarebeef";
		
		Strings string = new Strings();
		System.out.println(string.concatString(s1, s2));
	}
}
