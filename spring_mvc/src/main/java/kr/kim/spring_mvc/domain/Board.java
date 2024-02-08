package kr.kim.spring_mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor //모든 필드를 다 입력해야만 자동으로 생성
public class Board {
    //한 줄 게시판에 필요한 정보들(글번호, 글쓴이, 날짜, 본문)
    private int boardNum;
    private String writer;
    private LocalDateTime createdAt;
    private String content;

}
