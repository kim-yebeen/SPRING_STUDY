package kr.kim.spring_mvc.controller;


import kr.kim.spring_mvc.domain.Board;
import kr.kim.spring_mvc.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board") //localhost:8080/board/
@AllArgsConstructor //final이 붙은 변수에 객체 주입을 위해 생성자 생성
public class BoardController {

    //컨트롤러는 원래 서비스를 호출해야 하지만, 편의상 먼저 레포지토리를 호출하겠습니다.
    private final BoardRepository boardRepository;

    //게시판 전체 글 목록을 조회할 수 있는 페이지
    //http://localhost:8080/board/list
    @GetMapping("list")
    public String goBoardList(Model model){
        //레포지토리의 데이터를 컨트롤러 내부로 가져오기
        List<Board> boardList = boardRepository.getBoardList();
        System.out.println("컨트롤러가 가져온 전체 글 정보 : "+boardList);
        //가져온 데이터는 화면으로 보내주기
        model.addAttribute("boardList", boardList);
        return "board/board-list";
    }
}
