package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class EnglishVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnglishVowels code = new EnglishVowels();
		code._processInputOptimally();
	}
	
	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int _testCases = Integer.parseInt(tokenizer.nextToken());
			int cnt = 0;
			while (cnt < _testCases) {
				final String inputStr = br.readLine();
				int vowels = countVowels(inputStr);
				int consonants = inputStr.length() - vowels;
				System.out.println(vowels+" "+consonants+" "+vowels*consonants);
				
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	static int countVowels(String s) {		
		return (int)s.chars().mapToObj(ch -> (char)ch).filter(ch -> isVowel(ch)).count();
	}
	
	static boolean isVowel(char c) {
		return Stream.of('A','E','I','O','U').anyMatch(vo -> vo.equals(Character.toUpperCase(c)));
	}
}
