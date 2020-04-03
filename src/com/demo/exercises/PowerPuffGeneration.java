package com.demo.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerPuffGeneration {
	
	private int ingredients = 0;
	private long[] requiredIng;
	private long[] availableIng;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerPuffGeneration demo = new PowerPuffGeneration();
		demo._loadInputData();
		demo._calculateMaxOptions();
	}
	
	private void _calculateMaxOptions() {
		long max_option = 0;
		int var = 1;		
		for (int i = 0; i < ingredients; i++) {
			final long choice = availableIng[i]/requiredIng[i];
			if(i == var) {
				max_option = choice;
				var--;
			}
			
			if(max_option > choice) {
				max_option = choice;
			}
			
		}		
				
		System.out.println(max_option);
	}
	
	private void _loadInputData() {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			ingredients = scan.nextInt();
			requiredIng = new long[ingredients];
			availableIng = new long[ingredients];
			scan.nextLine();
			String required = scan.nextLine();
			String[] requiredIngStr = required.split(" ", ingredients);
			for(int i=0; i<requiredIngStr.length;i++) {
				requiredIng[i] = Long.parseLong(requiredIngStr[i].trim());
			}
			String[] availableIngStr = scan.nextLine().split(" ", ingredients);
			for(int i=0; i<availableIngStr.length;i++) {
				availableIng[i] = Long.parseLong(availableIngStr[i].trim());
			}
			
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println(e);
		}finally {
			scan.close();
		}
		
	}

}
