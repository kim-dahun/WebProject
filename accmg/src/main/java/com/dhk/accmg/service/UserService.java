package com.dhk.accmg.service;

import org.springframework.stereotype.Service;

import com.dhk.accmg.domain.User;
import com.dhk.accmg.dto.UserLoginDto;
import com.dhk.accmg.dto.UserSignInDto;
import com.dhk.accmg.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    // id 무결성 체크
    public boolean checkIdLength(String id) {

        return id.length() < 15 && id.matches(".*[a-z].*") ? true : false;

    }

    // 비밀번호 무결성 체크
    public boolean checkPw(String password) {
        boolean answer = false;
        if (password.length() >= 10 && password.length() < 20) {

            if (password.matches(".*[a-z].*") && password.matches(".*[0-9].*")) {

                answer = true;

            }

        }

        return answer;
    }

    // 이메일 무결성 체크
    public boolean checkEmail(String email) {

        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$") ? true : false;

    }

    // 전화번호 무결성 체크
    public boolean checkPhone(String phone) {

        return phone.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$");

    }

    // 회사코드 무결성 체크
    public boolean checkCompanyNum(long companynum) {

        return companynum > 0 && companynum <= 999999 ? true : false;

    }

    // 회원가입 체크
    public boolean checkSignInDto(UserSignInDto dto) {

        return checkIdLength(dto.getId()) ? checkPw(dto.getPassword()) ? checkPhone(dto.getPhone()) ? checkEmail(dto.getEmail()) ? checkCompanyNum(dto.getCompanycode()) :false :false : false : false;
    }

    public int write(UserSignInDto dto) {
        log.info("write({})", dto);

        if(!checkSignInDto(dto)) {
            
            return -1;
            
        }
        
        return userRepository.write(dto.toEntity());
    }
    
    public UserLoginDto read(User user) {
        
        log.info("user={}",user);
        
        User loginuser = userRepository.readIdAndPassword(user);
        
        
        
        return UserLoginDto.fromEntity(loginuser);
        
    }

}
