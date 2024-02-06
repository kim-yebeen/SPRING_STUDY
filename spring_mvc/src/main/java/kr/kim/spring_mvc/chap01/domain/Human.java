package kr.kim.spring_mvc.chap01.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //lombok 설치시 사용 가능, getter, setter을 자동생성해줌
@Setter
@ToString //toString을 레퍼런스가 아닌 내부 멤버값으로 바꿔줍니다.
public class Human {

    private String name;
    private int age;
    private String address;


}
