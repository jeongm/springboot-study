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

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
        // RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션으로
        // 여기에서는 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하겍 됨
    }
}
