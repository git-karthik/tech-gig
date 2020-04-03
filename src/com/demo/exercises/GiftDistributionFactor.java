package com.demo.exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class GiftDistributionFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiftDistributionFactor f = new GiftDistributionFactor();
		f._scanInputsAndProcess();
	}
	
	private void _scanInputsAndProcess() {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			final String firstLine = scan.nextLine();
			final String[] children_gft_count = firstLine.split(" ");
			if(children_gft_count.length != 2) throw new IllegalArgumentException("Incorrect input received");
			
			final int no_of_children = Integer.parseInt(children_gft_count[0]);
			final int pre_gifted = Integer.parseInt(children_gft_count[1]);
			final String pre_gifted_idex = scan.nextLine();			
			
			if(pre_gifted_idex.split(" ").length != pre_gifted) {
				throw new IllegalArgumentException("Incorrect input data.");
			}
			
			System.out.println(factorial(no_of_children - pre_gifted));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			scan.close();
		}
	}

	private BigInteger factorial( int factor ) {
		
		BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= factor; ++i)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
		
		return factorial;
	}
}
