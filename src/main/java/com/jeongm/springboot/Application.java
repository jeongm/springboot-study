package com.jeongm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정됨, 항상 최상단에 위치해야 함
public class Application { // 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS(Web Application Server)를 실행 -> 항상 서버에 톰캣을 설치할 필요가 없게 됨
        // 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문에 스프링부트에서는 내장 WAS를 사용하는 것을 권장하고 있음
    }
}
