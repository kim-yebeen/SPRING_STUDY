package kr.kim.spring_blog.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper //빈 컨테이너에 마이바티스 호출 메서드 정의용으로 적재
public interface ConnectionTestRepository {
    //getNow() 실행 시 호출할 SQL 구문은 xml 파일 내부에 작성합니다.

    String getNow();
}
