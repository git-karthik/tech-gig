package com.demo.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OptimalTransfer {
	private static final String CARTONS_KEY = "CARTONS_COUNT";
	private static final String PERSONS_KEY = "PERSONS_COUNT";
	private Map<String, Integer> cartons_persons_map;
	private List<Integer> carton_wi_list;
	private List<Integer> person_wi_list;
	private int steps_taken = 0;

	public static void main(String args[]) throws Exception {

		// Write code here
		OptimalTransfer tr = new OptimalTransfer();
		tr.readInputs();
		tr.findApplicableCartons();
		boolean consumed = false;
		while (!consumed) {
			consumed = tr.consume();
			if(consumed) {
			final int totalSteps = Math.addExact(tr.getSteps_taken(), tr.getSteps_taken() - 1);
			System.out.println(totalSteps);
			break;
			}
		}
	}

	private boolean consume() {
		if (carton_wi_list.isEmpty()) {
			return true;
		}
		for (int i = 0; i < person_wi_list.size(); i++) {
			for (int j = 0; j < carton_wi_list.size(); j++) {
				if (person_wi_list.get(i) >= carton_wi_list.get(j)) {
					carton_wi_list.remove(j);
					break;
				}
			}
		}
		setSteps_taken(getSteps_taken() + 1);
		return false;
	}

	private boolean findApplicableCartons() {
		final boolean isRemoved = carton_wi_list.removeIf(carton -> carton > person_wi_list.get(0));
		return isRemoved;
	}

	private void readInputs() {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			final String cartons_persons = scan.nextLine();
			final String[] splits = cartons_persons.split(" ");
			if (splits.length != 2) {
				System.err.println("Incorrect input. Enter cartons and persons. eg., 10 3");

			}
			cartons_persons_map = new HashMap<>(2);
			cartons_persons_map.put(CARTONS_KEY, Integer.parseInt(splits[0]));
			cartons_persons_map.put(PERSONS_KEY, Integer.parseInt(splits[1]));

			final String carton_weights = scan.nextLine();
			final String[] carton_wi_splits = carton_weights.split(" ");
			if (carton_wi_splits.length != cartons_persons_map.get(CARTONS_KEY)) {
				System.err.println("Incorrect number of carton weights provided.");
			}
			carton_wi_list = new ArrayList<>(cartons_persons_map.get(CARTONS_KEY));
			for (String wi : carton_wi_splits) {
				carton_wi_list.add(Integer.parseInt(wi));
			}
			carton_wi_list.sort(Comparator.reverseOrder());

			final String person_weights = scan.nextLine();
			final String[] person_wi_splits = person_weights.split(" ");
			if (person_wi_splits.length != cartons_persons_map.get(PERSONS_KEY)) {
				System.err.println("Incorrect number of person weights provided.");
			}
			person_wi_list = new ArrayList<>(cartons_persons_map.get(PERSONS_KEY));
			for (String wi : person_wi_splits) {
				person_wi_list.add(Integer.parseInt(wi));
			}
			person_wi_list.sort(Comparator.reverseOrder());

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}

	public int getSteps_taken() {
		return steps_taken;
	}

	public void setSteps_taken(int steps_taken) {
		this.steps_taken = steps_taken;
	}
}
