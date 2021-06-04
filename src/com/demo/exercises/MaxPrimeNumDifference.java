package com.demo.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPrimeNumDifference {
    
    public static void main(String[] args) {
        MaxPrimeNumDifference code = new MaxPrimeNumDifference();
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
                primes[0] = findMinPrimeNumberInRange(Integer.parseInt(numRange[0]), Integer.parseInt(numRange[1]));
                primes[1] = findMaxPrimeNumberInRange(Integer.parseInt(numRange[0]), Integer.parseInt(numRange[1]));
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

    private int findMinPrimeNumberInRange(int start, int end){
       for(int i=start; i<=end; i++){
            if(isPrime(i)){
               return i;
            }
        }
        return 0;
    }

    private int findMaxPrimeNumberInRange(int start, int end){
        for(int i=end; i>=start; i--){
             if(isPrime(i)){
                return i;
             }
         }
         return 0;
     }

    private static boolean isPrime(int num){
        int count = 0;
        int i=1;
        while(i<=num){
            if(num%i == 0){
                count++;
            }
            i++;
        }

        if(count == 2){return true;}
        return false;
    }
}
