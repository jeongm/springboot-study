package com.jeongm.springboot.domain.posts;
// Posts 클래스로 DB를 접근하게 해줄 JpaRepository 생성
// 단순히 인터페이스 생성 후, JarRepository<Entity 클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
// 주의: Entity 클래스와 기본 Entity Repository는 함께 위치해야 함

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
