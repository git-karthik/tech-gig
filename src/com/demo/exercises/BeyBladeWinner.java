package com.demo.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeyBladeWinner {
	private int _testCases;
	private int _teamSize;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instant start = Instant.now();
		BeyBladeWinner code = new BeyBladeWinner();
		code._processInputOptimally();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("TimeElapsed-->" + timeElapsed);
	}

	private void _findMaxWinFights(final long[] grtList, final long[] oppList) {

		int wins = 0;
		Arrays.sort(grtList);
		
		for (int j = 0; j < oppList.length; j++) {			
			for (int k = 0; k < grtList.length; k++) {
				if (grtList[k] > oppList[j]) {	
					wins++;
					grtList[k] = -1;
					break;
				}
			}
		}

		System.out.println(wins);
	}
	
	

	private void _processInputOptimally() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			_testCases = Integer.parseInt(tokenizer.nextToken());
			int cnt = 0;
			while (cnt < _testCases) {
				_teamSize = Integer.parseInt(br.readLine());
				final long[] grArr = new long[_teamSize];
				final long[] oppArr = new long[_teamSize];
				// Reading GR Team Elements
				tokenizer = new StringTokenizer(br.readLine());
				int idx = 0;
				while (tokenizer.hasMoreTokens()) {
					grArr[idx] = Long.parseLong(tokenizer.nextToken());
					idx++;
				}
				tokenizer = new StringTokenizer(br.readLine());
				idx = 0;
				while (tokenizer.hasMoreTokens()) {
					oppArr[idx] = Long.parseLong(tokenizer.nextToken());
					idx++;
				}
				this._findMaxWinFights(grArr, oppArr);
				cnt++;
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
}
