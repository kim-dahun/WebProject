package com.pro.java;

import java.io.*;
import java.util.*;

public class Solved5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int[] n1 = new int[Integer.parseInt(s1[0])];
		for(int i = 0 ; i<s2.length ; i++) {
			
			n1[i]=Integer.parseInt(s2[i]);
			
		}
		Arrays.sort(n1);
		
		int sum = 0;
		int maxsum = Integer.parseInt(s1[1]);
		int maxsum2 = 0;
		for(int i = n1.length-1 ; i>=0 ;i--) {
			
			for(int j = n1.length-1 ; j>=0 ;j--) {
				
				if(i==j) {
					continue;
				}
				
				for(int k = n1.length-1 ; k>=0 ; k--) {
					
					if(i==k || j==k) {
						
						continue;
						
					}
					System.out.printf("i=%d, j=%d, k=%d + %n",i,j,k);
					System.out.println(n1[i]+n1[j]+n1[k]);
					if(n1[i]+n1[j]+n1[k]<=maxsum) {
						
						sum = n1[i]+n1[j]+n1[k];
						if(maxsum2<=sum) {
							maxsum2 = sum;
						}
						
						
					}
					
				}
				
			}
			
		}
		
		System.out.println(maxsum2);
		
	}

}
