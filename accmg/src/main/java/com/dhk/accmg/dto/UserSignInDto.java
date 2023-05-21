package com.dhk.accmg.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.dhk.accmg.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserSignInDto {

    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private LocalDate birthday;
    private long companycode;
    
    public User toEntity() {
        
        User user = User.builder().id(id).password(password).name(name).phone(phone).email(email).birthday(LocalDateTime.of(birthday, LocalTime.of(0, 0)
                )).companycode(companycode).build();
        
        return user;
        
    }
    
}
