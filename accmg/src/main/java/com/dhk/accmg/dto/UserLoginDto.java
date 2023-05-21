package com.dhk.accmg.dto;

import java.sql.Timestamp;

import com.dhk.accmg.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Timestamp birthday;
    private long companycode;
    
    public static UserLoginDto fromEntity(User user){
        UserLoginDto userlogindto = null;
        
        if(user==null) {
            return null;
        }
        
        return userlogindto = UserLoginDto.builder().id(user.getId())
                .password(user.getPassword()).name(user.getName()).phone(user.getPhone())
                .email(user.getEmail()).birthday(Timestamp.valueOf(user.getBirthday()))
                .companycode(user.getCompanycode()).build();
    }
    
}
