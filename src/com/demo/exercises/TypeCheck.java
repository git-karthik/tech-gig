package com.demo.exercises;

import java.util.Scanner;

public class TypeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try {
			if (scan.hasNextInt())
				System.out.print("This input is of type Integer.");

			else if (scan.hasNextFloat())
				System.out.print("This input is of type Float.");

			else if (scan.hasNextLine())
				System.out.print("This input is of type string.");
		} finally {
			scan.close();
		}

	}

}
