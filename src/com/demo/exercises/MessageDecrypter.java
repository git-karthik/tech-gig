package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MessageDecrypter {
	private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		MessageDecrypter code = new MessageDecrypter();
		code._processInputOptimally();	

	}
	
	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int _testCases = Integer.parseInt(tokenizer.nextToken());
			int cnt = 0;
			while (cnt < _testCases) {
				final String encryptedMsg = br.readLine();
				final String decryptCode = br.readLine();
				final StringBuffer sb = new StringBuffer(encryptedMsg.length());
				for(int i=0; i<encryptedMsg.length();i++) {
					
					final int targetIdx = rotateIndex(alphabets.indexOf(encryptedMsg.charAt(i)), Integer.parseInt(String.valueOf(decryptCode.charAt(i))));
					sb.append(alphabets.charAt(targetIdx));
				}
				System.out.println(sb.toString());
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	static int rotateIndex(int startIndex, int offset) {
		final int MIN_INDEX = 0;
		final int MAX_INDEX = 25;		
		
		if(offset%2 != 0) {
			offset = -offset;
		}
				
		final int changeIndex = startIndex+offset;
		if(changeIndex>MAX_INDEX) {
			return (changeIndex-MAX_INDEX)-1;
		} else if (changeIndex<MIN_INDEX) {
			return (changeIndex+MAX_INDEX)-1;
		}
		
		return changeIndex;
	}

}
