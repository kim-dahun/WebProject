package com.pro.java;

import java.io.*;

public class Solved4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split(" ");
		int a = Integer.parseInt(s1[0]);
		int b = Integer.parseInt(s1[1]);
		int v = Integer.parseInt(s1[2]);
		int day = 0;
		if((v-b)%(a-b)==0) {
			
			day = (v-b-1)/(a-b)+1;
		} else {
			day = (v-b)/(a-b)+1;
		}
		
		
		
		System.out.println(day);
		
		
		
	}

}
