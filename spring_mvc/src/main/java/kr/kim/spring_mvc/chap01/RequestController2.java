package kr.kim.spring_mvc.chap01;

import kr.kim.spring_mvc.chap01.domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//클래스 위에 해당 애너테이션을 붙이면, 전체 메서드에 앞서서 붙을 접두주소를 지정
@RequestMapping("reqres")
public class RequestController2 {

    //http://localhost:8080/test 접속시 메서드 실행
    @RequestMapping("login-form")
    public String goLoginForm(){
        //localhost:8080/reqres/login-form
        //WEB-INF/views/reqres/loginform.jsp로 연결
        //폴더를 앞에 reqres로 생성하고 거기에 loginform.jsp를 생성해야함
        return "reqres/loginform";
    }

    @PostMapping(value="login")
    public String checkLoginReq( // id, pw 라는 변수에 담겨오는값 처리
                                 @RequestParam(value="id",defaultValue = "아이디없음") String id,
                                 @RequestParam(value = "pw", defaultValue = "비번없음") String pw,
                                 Model model){
        System.out.println("로그인 요청 아이디 : " + id);
        System.out.println("로그인 요청 비번 : " + pw);
        //자바 내부에 들어온 데이터를 화면으로 보내기 위해서는
        //addAttribute("보낼이름", 자료)가 필요합니다.
        model.addAttribute("uid",id);//id 변수에 든 값을 "uid"라는 이름을
        model.addAttribute("upw",pw);
        return "reqres/loginresult";
    }

    @GetMapping("human")//get방식만 허용하는 컨트롤러
    public String showHuman(Human human, Model model){//화면으로 자료 보내줌
        System.out.println(human);
        //커맨드 객체의 경우는 객체째로 보냅니다.
        model.addAttribute("human", human);
        return "human-result";
    }

    //human-form 주소로 접속했을 때 human에 해당하는 데이터들을
    //화면에 보여줄 수 있는 .jsp파일을 직접 작성해주세요.
    //해당주소로 접속하면 form페이지가 나오고 여기서 제출버튼을 누르면
    //커맨드객체 human이 해당 페이지에서 보낸 자료를 받습니다.
    @GetMapping("HumanForm")
    public String goHumanForm(){
        return "reqres/HumanForm";
    }

    @GetMapping("book/{page}")
    public String digitalBook(@PathVariable int page, Model model){
        model.addAttribute("page", page);
        return "digital-book";
    }

    @GetMapping("naver")
    public String goNaver(){
        //네이버로 강제 이동 시키기
        return "redirect:https://www.naver.com";
    }

    //서울여대 홈페이지로 리다이렉트되는 엔드포인트 설정
    @GetMapping("swu")
    public String goSwu(){
        //서울여대로 강제 이동시키기
        return "redirect:https://www.swu.ac.kr";
    }
}
