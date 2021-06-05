package com.demo.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class MaxPrimeNumDifferenceV8 {
    
    public static void main(String[] args) {
        MaxPrimeNumDifferenceV8 code = new MaxPrimeNumDifferenceV8();
        code.readInputsAndProcess();
    }

    private void readInputsAndProcess(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int _testCases = Integer.parseInt(tokenizer.nextToken());           
			int cnt = 0;
            while(cnt< _testCases){
                final long startTime = System.nanoTime()/1000000;
                String[] numRange = br.readLine().split(" ");
                final int[] primes = new int[2];
                
                primes[0] = findMinPrimeNumberInRange.apply(Integer.parseInt(numRange[0]), Integer.parseInt(numRange[1]));
                primes[1] = findMaxPrimeNumberInRange.apply(Integer.parseInt(numRange[0]), Integer.parseInt(numRange[1]));

                if(primes[0] == 0 && primes[1]==0){
                    System.out.println(-1);
                } else if(primes[1] == 0){
                    System.out.println(0);
                } else{
                    System.out.println(primes[1]-primes[0]);
                }
                final long endTime = System.nanoTime()/1000000;
                System.out.println("Time Taken for input(ms)"+(cnt+1)+"==>"+(endTime-startTime));
                cnt++;               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    final IntPredicate isPrime = (num) -> {
        int count = 0;
        int i=1;
        while(i<=num){
            if(num%i == 0){
                count++;
            }
            i++;
        }
        
        if(count == 2){
            return true;
        }
        return false;
     };

    final BiFunction<Integer, Integer, Integer> findMinPrimeNumberInRange = (start, end) -> {
        return IntStream.rangeClosed(start, end)
        .filter(isPrime)
        .findFirst()
        .orElse(0);        
    };
    
    final IntUnaryOperator postiveValue = (num) -> -1 * num;

    final BiFunction<Integer, Integer, Integer> findMaxPrimeNumberInRange = (start, end) -> {
        return IntStream.rangeClosed(-end, -start)
        .map(postiveValue)
        .filter(isPrime)
        .findFirst()
        .orElse(0);
    };
}
