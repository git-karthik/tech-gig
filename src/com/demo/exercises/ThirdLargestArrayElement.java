package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThirdLargestArrayElement {
	
	/**
	 * Displays the Third largest element in an array
	 * @param args
	 */
//	Test Data 
//	"1" - Number of Test Cases
//	+ "7" - Array Count
//	+ "25 67 78 65 67 78 10" - Members

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdLargestArrayElement code = new ThirdLargestArrayElement();
		code._processInputOptimally();
	}
	
	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int _testCases = Integer.parseInt(tokenizer.nextToken());
			int cnt = 0;
			while (cnt < _testCases) {				
				final String[] num_elements = br.readLine().split(" ");
				if(num_elements.length<3) {
					throw new IOException("Incorrect Input size less than 3");
				}
				final List<Integer> sortedValues = Stream.of(num_elements).map(s -> Integer.parseInt(s))
				.sorted()
				.collect(Collectors.toList());
				int third_largest_idx = sortedValues.size()-3;
				System.out.println(sortedValues.get(third_largest_idx));
				
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}


}
