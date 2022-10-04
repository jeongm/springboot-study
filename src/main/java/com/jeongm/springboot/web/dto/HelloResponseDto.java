package com.jeongm.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 선언된 모든 final필드가 포함도니 생성자를 생성해줌, final이 없는 필드는 생성자에 포함되지 않음

public class HelloResponseDto {
    private final String name;
    private final int amount;
}
