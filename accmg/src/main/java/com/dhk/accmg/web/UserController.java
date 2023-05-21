package com.dhk.accmg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhk.accmg.dto.UserSignInDto;
import com.dhk.accmg.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    
    @GetMapping("/signin")
    public void signin() {
        
        log.info("sign()");
        
    }
    
    @PostMapping("/signin")
    public String signintohome(UserSignInDto dto, Model model) {
        log.info("signInComplete({})",dto);
        
        int result = userService.write(dto);
        
        if(result == -1) {
            
            model.addAttribute("signInFail", 1);
            return "redirect:/user/signin";
        }
        
        
        return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("logout()");
        
        session.invalidate();
        
        return "redirect:/";
        
    }
    
}
