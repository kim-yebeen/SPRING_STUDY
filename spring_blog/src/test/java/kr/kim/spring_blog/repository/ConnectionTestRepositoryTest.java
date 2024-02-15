package kr.kim.spring_blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //@Mapper로 적재된 마이바티스 인터페이스 인식을 위해 애너테이션 작성

public class ConnectionTestRepositoryTest {

    @Autowired //테스트코드 작성시에는 자동 주입이안되기 때문에 해당 애너테이션을 필드 위에 붙여줌
    ConnectionTestRepository connectionTestRepository;

    @Test
    public void getNowTest(){
        System.out.println("얻어온 현재 시간 : "+connectionTestRepository.getNow());
    }
}
