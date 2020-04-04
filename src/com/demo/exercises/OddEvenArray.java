package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class OddEvenArray {
	private int oddSum = 0, evenSum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenArray code = new OddEvenArray();
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
			
			Stream.of(arrayElem).map(s -> Integer.parseInt(s))
					.forEach(val -> {
						if(val%2 == 0) {
							evenSum += val;
						}else {
							oddSum += val;
						}
					});
			
			if(oddSum == evenSum) {
				System.out.print("Tied");
			}else if (oddSum > evenSum) {
				System.out.print("Odd");
			}else {
				System.out.print("Even");
			}
			

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}


}
