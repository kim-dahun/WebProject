package com.itwill.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostDetailDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// application-context.xml 에서 <context:component-scan> 설정에서
// com.itwill.spring2.service 패키지와 그 하위 패키지를 스캔(검색)

@Service //-> Spring Container 에서 Service Component 객체를 생성하고 관리(필요한 곳에 주입).
@RequiredArgsConstructor // 2. (2) final로 선언된 필드를 초기화하는 생성자.
@Slf4j
public class PostService {

    // 의존성 주입(DI: Dependency Injection) :
    // 1. 필드에 의한 의존성 주입 - @Autowired 애너테이션 사용
    // 2. 생성자에 의한 의존성 주입
    //  (1) Field를 Final로 선언
    //  (2) Final 변수를 초기화 할 수 있는 생성자를 작성
    
//    @Autowired private PostRepository postRepository // 1. 필드에 의한 의존성 주입
    
    private final PostRepository postRepository; // 2. (1) 생성자에 의한 의존성 주입
    
    // 포스트 목록 페이지
    public List<PostListDto> read(){
        log.info("read()");
        
        List<Post> list= postRepository.selectOrderByIdDesc();
        /*
         * List<PostListDto> result = new ArrayList<>();
         * for(Post p : list){
         *  PostListDto dto = PostListDto.fromEntity(p);
         *  result.add(dto);
         * }
         * 
         * return result;
         */
        return list.stream().map(PostListDto::fromEntity).toList();
    }
    
    // 포스트 상세보기 페이지
    public PostDetailDto read(long id) {
        log.info("read({})",id);
        
        Post post =  postRepository.selectById(id);
        
        return PostDetailDto.fromEntity(post);
    }
    
    // 새 포스트 작성 페이지
    public int write(PostCreateDto dto) {
        log.info("write({})",dto);
        
        // PostCreateDto 타입을 Post 타입으로 변환해서
        // Repository 계층의 메서드를 호출 - DB Insert.
        return postRepository.insert(dto.toEntity());
    }
    
    // 포스트 업데이트
    public int update(PostUpdateDto dto) {
        
        log.info("update({})",dto);
        
        return postRepository.updateTitleAndContent(dto.toEntity());
    }
    
    // 포스트 삭제
    public int delete(long id) {
        
        log.info("delete({})",id);
        
        return postRepository.deleteById(id);
        
    }
    
}
