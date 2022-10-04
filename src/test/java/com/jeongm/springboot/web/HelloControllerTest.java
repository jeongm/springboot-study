package com.jeongm.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)  // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
@WebMvcTest // 여러 스프링 어노테이션 중, Web에 집중할 수 있는 어노테이션, controller만 선언했기 때문에 @Controller, @ControllerAdvice사용가능
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, 스프링 MVC테스트의 시작점, 이클래스를 통해 HTTP GET, POST 등에 대한 API테스트를 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name",name) // param: API 테스트할 떄 사용될 요청 파라미터를 설정, 단 값은 String만 허용됨
                        .param("amount", String.valueOf(amount))) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증, HTTP Header의 Status를 검증, 200, 404, 500 등의 상태를 검증, 여기선 OK 즉, 200인지 아닌지를 검증
                .andExpect(jsonPath("$.name", is(name))) // jsonPath: JSON응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount))); // 여기서는 name과 amount를 검증
    }
}
