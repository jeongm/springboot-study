package com.jeongm.springboot.domain.posts;
// domain 패키지는 도메인을 담을 패키지로 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사랑 혹은 문제영역

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 몯느 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 롬복의 어노테이션, 기본 생성자 자동 추가 ex) public Posts() {} 와 같은 효과
@Entity // JPA의 어노테이션, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts { // 실제 DB의 테이블과 매칭될 클래스로 보통 Entity클래스라고도 함
// JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업함
    // Entity 클래스에서는 절대 Setter 메소드를 만들지 않음
    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용함
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
