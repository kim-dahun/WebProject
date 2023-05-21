package com.dhk.accmg.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class User {
    
    private long userid;
    private String id;
    private String password;
    private String name;
    private LocalDateTime birthday;
    private String email;
    private String phone;
    private long companycode;
    
}
