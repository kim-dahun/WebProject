package com.pro.java;

import java.io.*;
import java.util.*;

public class Solved1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] defline = br.readLine().split(" ");
		int Money = Integer.parseInt(defline[1]);
		int maxLength = Integer.parseInt(defline[0]);
		int restMoney = Money;
		int coinCount = 0;
		int[] valueLine = new int[maxLength];
		for(int i = 0 ; i<maxLength ; i++) {
			
			valueLine[i] = Integer.parseInt(br.readLine());
			
		}
		
		for(int i = maxLength-1 ; i>=0;i-- ) {
			
			
			
			if(valueLine[i]<=restMoney) {
				
				
				coinCount += restMoney/valueLine[i];
				
				
				restMoney=restMoney%valueLine[i];
				
				if(restMoney==0) {
					
					break;
					
				}
				
				
			} 
			
		}
		
		System.out.println(coinCount);
		
	}

}
