package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CharacterEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterEquality code = new CharacterEquality();
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
				_findCharStrength(inputStr);
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	static void _findCharStrength(String s) {
		int[] counts = new int[4];
		s.chars().forEach(ch -> {
			if(Character.isUpperCase(ch)) {
				counts[0]++;
			} else if (Character.isLowerCase(ch)) {
				counts[1]++;
			} else if (Character.isDigit(ch)) {
				counts[2]++;
			} else {
				counts[3]++;
			}
		});
		
		if(isEqual(counts)) {
			System.out.println("Equality For Everyone");
		}else {
			System.out.println("No Equality");
		}
		
		
	}
	
	static boolean isEqual(int... values) {
		for(int i : values) {
			if(values[0] != i) {
				return false;
			}
		}
		
		return true;
	}

}
