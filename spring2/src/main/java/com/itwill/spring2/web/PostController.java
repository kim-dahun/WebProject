package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostDetailDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller // DispatcherServlet 에게 Controller Component로 등록.
@Slf4j // Log출력
@RequiredArgsConstructor // 생성자에 의한 의존성 주입
@RequestMapping("/post") // PostController 클래스의 메서드들은 요청 주소가 "/post"로 시작.
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입

    @GetMapping("/list") // GET 방식의 /post/list 요청 주소를 처리하는 메서드
    public void list(Model model, @RequestParam("num") int num) {
        log.info("list()");
        // 리턴 값이 없는 경우 View의 이름은 요청주소와 동일
        // /WEB-INF/views/post/list.jsp
        
        // Controller 는 Service 계층의 메서드를 호출해서 서비스 기능 수행.
        List<PostListDto> list = postService.read();
        
        int length = list.size();
        int len = 0;
        if(num<0) {
            num=0;
        } 
        
        int pageCount = 10*num;
        if(pageCount+10>length) {
            
            len = length;
            
        } else {
            
            len = pageCount+10;
            
        }
        
        
        
        model.addAttribute("length2", length);
        model.addAttribute("num",num);
        model.addAttribute("postlist",list);
        model.addAttribute("length", len);
        model.addAttribute("pageCount", pageCount);
    }
    
    @GetMapping("/details")
    public void details(long id, Model model) {
        
        log.info("details(id={})",id);
        
        // 서비스 계층의 메서드를 호출해서 화면에 보여줄 PostDetailDto를 가져옴.
        PostDetailDto dto = postService.read(id);        
        
        // 뷰에 PostDetailDto 전달.
        model.addAttribute("post", dto);
        
    }
    
    @GetMapping("/create")
    public void create() {
        log.info("GET : Create()");
        
        
    }
    
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("POST : create({})", dto);
        
        
        // 서비스 계층의 메서드를 호출 - 새 포스트를 등록
        int result = postService.write(dto);
        log.info("포스트 등록 결과 = {}", result);
        
        // Post - Redirect - Get
        return "redirect:/post/list?num=0";
    }
    
    @GetMapping("/modify")
    public void modify(long id, Model model) {
        
        log.info("modify(id={})",id);
        
        PostDetailDto dto = postService.read(id);
        model.addAttribute("post", dto);
        
    }
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        
        log.info("update(dto={})",dto);
        
        int result = postService.update(dto);
        log.info("Update = {}",result);
        
        
        return "redirect:/post/details?id="+dto.getId();
    }
    
    @PostMapping("/delete")
    public String delete(long id) {
        
        log.info("delete(id={})",id);
        
        int result = postService.delete(id);
        log.info("delete row = {}",result);
        
        return "redirect:/post/list?num=0";
    }
}
