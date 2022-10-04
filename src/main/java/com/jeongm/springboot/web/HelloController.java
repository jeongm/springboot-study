package com.jeongm.springboot.web; // 컨트롤러와 관련된 클래스들을 모두 담음

import com.jeongm.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러고 만들어줌
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줌, 이제 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 됨
    public String hello() {
        return "hello";
    }


}
