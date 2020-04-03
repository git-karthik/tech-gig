package com.demo.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlphabetsGroup {
	private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	private Map<Character, Integer> alpha_key_map = new HashMap<>();
	final List<InputStruct> inputData = new ArrayList<>();
	
	public static void main(String[] args) {
		
		AlphabetsGroup alphabetsGroup = new AlphabetsGroup();
		alphabetsGroup.buildAlphabetsMap();
		alphabetsGroup._readInputs();
		alphabetsGroup._resolveAlphaGroups();
	}
	
	private void _resolveAlphaGroups() {
		
		for(InputStruct data : inputData) {
			 final int[] seq_val_arr = this.resolveAlphabets(data.getPeopleSeq());
			 final int partyNumber = data.getParty_number();
			 int i = 0;
			 int validCount = 0;
			 while(i<seq_val_arr.length) {
				 int sum = 0;
				 for(int j=i; j<seq_val_arr.length; j++) {
					 if(seq_val_arr[j] > partyNumber) break;
					 if(sum<partyNumber) {
						 sum = sum + seq_val_arr[j];
					 }
					 if(sum > partyNumber) {
						 break;
					 }		 
					 if(sum == partyNumber) {
						 validCount++;
						 break;
					 }					 
				 }
				 i++;
			 }
			 
			 System.out.println(validCount);
			
		}
		
	}
	
	private int[] resolveAlphabets(String inpSeq) {
		char[] seqchars = inpSeq.toCharArray();
		int[] charValues = new int[seqchars.length];
		for(int i=0; i<seqchars.length; i++) {
			charValues[i] = alpha_key_map.get(seqchars[i]).intValue();			
		}
		
		return charValues;
	}
	
	private void buildAlphabetsMap() {
		final List<Character> alphabets_list = alphabets.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
		int i = 1;
		for(Character ch : alphabets_list) {
			alpha_key_map.put(ch, i);
			i++;
		}		
	}
	
	private void _readInputs() {
		Scanner scan = null;
		try {
			scan = new Scanner(System.in);
			final int number_of_tests = scan.nextInt();			
			int i=0; scan.nextLine();
			while(i<number_of_tests) {
				final String ppl_partyNo = scan.nextLine();
				InputStruct in = new InputStruct();
				String[] inp = ppl_partyNo.split(" ");
				if(inp.length != 2) {
					throw new IllegalArgumentException("Incorrect party number input: Expected length: 2, Actual:"+inp.length);
				}
				in.setNo_of_people(Integer.parseInt(inp[0]));
				in.setParty_number(Integer.parseInt(inp[1]));
				final String pepSeq = scan.nextLine();
				in.setPeopleSeq(pepSeq);
				if(in.getNo_of_people() != pepSeq.length()) {
					throw new IllegalArgumentException("People sequence not matching no of people declared.");
				}
				inputData.add(in);
				i++;
			}			
			
		}catch (NoSuchElementException | IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}finally {
			scan.close();
		}
	}
	
	private class InputStruct{
		
		private int no_of_people;
		private int party_number;
		private String peopleSeq;
		/**
		 * @return the no_of_people
		 */
		protected int getNo_of_people() {
			return no_of_people;
		}
		/**
		 * @param no_of_people the no_of_people to set
		 */
		protected void setNo_of_people(int no_of_people) {
			this.no_of_people = no_of_people;
		}
		/**
		 * @return the party_number
		 */
		protected int getParty_number() {
			return party_number;
		}
		/**
		 * @param party_number the party_number to set
		 */
		protected void setParty_number(int party_number) {
			this.party_number = party_number;
		}
		/**
		 * @return the peopleSeq
		 */
		protected String getPeopleSeq() {
			return peopleSeq;
		}
		/**
		 * @param peopleSeq the peopleSeq to set
		 */
		protected void setPeopleSeq(String peopleSeq) {
			this.peopleSeq = peopleSeq;
		}	
		
		
	}

}
