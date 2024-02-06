package kr.kim.spring_mvc.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

    //게시판 전체 글 목록을 조회할 수 있는 페이지
    public String goBoardlist(Model model){
        return "board/list";
    }
}
