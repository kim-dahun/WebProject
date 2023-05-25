package com.dhk.accmg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.dhk.accmg.domain.User;
import com.dhk.accmg.dto.UserLoginDto;
import com.dhk.accmg.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final UserService userService;
    
    @PostMapping("/main")
    public String main(HttpSession session, String id, String password) {
        
        log.info("main(id= {},password= {})",id,password);
        
        User user = User.builder().id(id).password(password).build();
        
        
        
        UserLoginDto loginuser = userService.read(user);
        if(loginuser==null
                ) {
            log.info("로그인 실패. 아이디 비밀번호 확인 필요");
            return "redirect:/";
        }
        session.setAttribute("user", loginuser);
        log.info("user={}",loginuser);
        
        return "main/main";
        
    }
    
    @GetMapping("/chatmain")
    public String chatroom() {
        log.info("chatroom()");
        
        return "main/chatroom";
    }
    
}
