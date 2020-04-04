package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitialIdentifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitialIdentifier code = new InitialIdentifier();
		code._processInputOptimally();
	}
	
	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int _testCases = Integer.parseInt(tokenizer.nextToken());
			int cnt = 0;
			while (cnt < _testCases) {
				final int employeesCnt = Integer.parseInt(br.readLine());
				final String[] employeeNames = br.readLine().split(" ");
				final String employeeInitials = Stream.of(employeeNames).map(s -> String.valueOf(s.charAt(0)))
				.peek(s -> {
					System.out.print(s);
				})
				.collect(Collectors.joining(""));
				
				for(int i=0; i<employeeInitials.length(); i++) {
					char current = employeeInitials.charAt(i);
					if(employeeInitials.indexOf(current) == employeeInitials.lastIndexOf(current)) {
						System.out.println("\nI am Alone "+current);
					}
				}
				
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
