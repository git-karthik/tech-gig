package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModalNumber {
	
	/**
	 * Finds the Modal Number in an array
	 * Sample Input
	   8
	   6 3 9 6 6 3 9 3
	   
	   Output
	   6
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModalNumber code = new ModalNumber();
		code._processInputOptimally();
	}
	
	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int arraySize = Integer.parseInt(br.readLine());
			final String[] arrayElem = br.readLine().split(" ");
			if(arrayElem.length!= arraySize) {
				throw new IOException("Incorrect Inputs");
			}
			
			Map<String, Long> groupedElem = Stream.of(arrayElem).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			Optional<Entry<String, Long>> modalElem = groupedElem.entrySet().stream().filter(e -> e.getValue().equals(Collections.max(groupedElem.values()))).findFirst();
			
			modalElem.ifPresent(entry -> {
				System.out.print(entry.getKey());
			});
			

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
