package com.dhk.accmg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountSubject {

	private int typeNo;
	private String typeName;
	private long orderNum;
	
	
}
