package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SecondLargeEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondLargeEven code = new SecondLargeEven();
		code._processInputOptimally();
	}

	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int arraySize = Integer.parseInt(br.readLine());
			final String[] arrayElem = br.readLine().split(" ");
			if (arrayElem.length != arraySize) {
				throw new IOException("Incorrect Inputs");
			}
			final TreeSet<Integer> sortedSet = Stream.of(arrayElem).mapToInt(s -> Integer.parseInt(s))
					.filter(n -> n % 2 == 0).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
			if (sortedSet.size() < 2) {
				throw new IndexOutOfBoundsException("Less than 2 even numbers in the input");
			}
			sortedSet.remove(sortedSet.last());
			System.out.print(sortedSet.pollLast());

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
