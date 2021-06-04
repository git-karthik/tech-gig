package com.demo.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompositionFinder {
    
    public static void main(String[] args) {
        CompositionFinder finder = new CompositionFinder();
        finder.readInputsAndResolve();
    }

    private void readInputsAndResolve(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            String _virusComposition = tokenizer.nextToken();
            int _peopleCount = Integer.parseInt(br.readLine());            
			int cnt = 0;
            while(cnt< _peopleCount){
                String _bloodComposition = br.readLine();
                if(!validateComposition(_bloodComposition, _virusComposition)){
                    System.out.println("NEGATIVE");
                } else{
                    System.out.println("POSITIVE");
                } 
                cnt++;               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean validateComposition(String bloodComposition, String virusComposition){
        char[] _bloodCompChars = bloodComposition.toCharArray();
        if(_bloodCompChars.length<1){
            return true;
        }
        String validationString = virusComposition;        
        for(int i=0; i<_bloodCompChars.length; i++){
            if(validationString.indexOf(_bloodCompChars[i])==-1){
                return false;
            }
            validationString = buildNxtString(_bloodCompChars[i], validationString);
        }

        return true;
    }

    private static String buildNxtString(char val, String input){
        int i=input.indexOf(val);
        if(i!=-1){
            return i<input.length() ?input.substring(i+1) :input.substring(i);
        }
        return "";
    }
}
