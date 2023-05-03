package com.coin;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LottoController {

	
	@GetMapping("/add")
    public String add(@RequestParam int num1) {
        int[] lotto = new int[6];
        int[] lottoVs = new int[6];
		Random rand = new Random();
		String answer = "";
		for(int i = 0; i<7 ; i++) {
			
			lotto[i]=rand.nextInt(1,45);
			
			for(int j = 0; j<lottoVs.length;j++) {
				
				if(lotto[i]==lottoVs[j]) {
					
					i--;
					break;
					
				}
				
			}
			System.out.println(lotto[i]);
			answer += lotto[i];
		}
		
		return answer;
    }
	
}
