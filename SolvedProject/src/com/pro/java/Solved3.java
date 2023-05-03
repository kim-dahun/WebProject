package com.pro.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solved3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] node = new int[Integer.parseInt(br.readLine())];
		String[] nodeindex = br.readLine().split(" ");
		int del = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<node.length ; i++) {
			
			node[i]= Integer.parseInt(nodeindex[i]); 
			
		}
		
		
		
	}

}
