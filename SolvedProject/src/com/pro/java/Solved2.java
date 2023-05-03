package com.pro.java;

import java.io.*;
import java.util.*;

public class Solved2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] answer = br.readLine().split(" ");
		long sum = Integer.parseInt(answer[0]);
		long minlength = Integer.parseInt(answer[1]);
		long answer2 = 0;
		long start = (sum-((minlength-1)*minlength/2))/minlength;
		String answer3 = "";
		for(long i = 0;i<100 ;i++) {
			
			for(long j = start ; j<start+minlength+i; j++) {
				answer2 += j;
				if(j==start+minlength+i-1) {
					answer3 += j + "";
				} else {
					answer3 += j + " ";
				}
				
				
			}
			if(answer2>sum) {
				
				answer2 = 0;
				answer3 = "";
				continue;
			} else if(answer2 == sum) {
				System.out.println(answer3);
				return;
			}
			
			
			
		}
		System.out.println(-1);

	}

}
