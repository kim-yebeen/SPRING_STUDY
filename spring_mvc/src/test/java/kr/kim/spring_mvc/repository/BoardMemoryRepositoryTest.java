package kr.kim.spring_mvc.repository;

import kr.kim.spring_mvc.domain.Board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 테스트 코드를 작성하는 클래스 상단에는 @SpringBootTest 애너테이션을 붙여줍니다.
@SpringBootTest
public class BoardMemoryRepositoryTest {

    // 테스트할 클래스를 아래에 선언하고, 의존성 주입을 위해 @Autowired 애너테이션을
    // 위쪽에 붙여줍니다.
    @Autowired
    private BoardRepository boardRepository;

    // 해당 클래스의 특정 기능을 호출하기 위해서는
    // @Test애너테이션을 위에 붙인 메서드를 하단에 선언해줍니다.
    // 마치 이 메서드가 메인메서드처럼 동작해서 검증을 돕습니다.
    @Test
    // 테스트 결과 창에서 보여질 멘트를 지정하는 애너테이션
    @DisplayName("전체 글을 가져와서 첫 번째 글의 글쓴이를 조회하면 서울여대일것이다.")
    public void getBoardListTest(){
        // given : when절에서 활용할 테스트 코드에 대한 사전 준비
        // getBoardList는 제공해야하는 파라미터나 사전조건이 없습니다.

        // when : 실제로 기능을 돌려서 수행시키는 단계
        List<Board> boardList = boardRepository.getBoardList();

        // then : when절에서 돌린 기능이 의도대로 돌았는지 검증하는 부분
        // 보통 단언문인 assertEquals 등으로 검증합니다.
        // assertEquals(); 라고 작성 후 alt + enter를 누르고
        // import static methods 클릭 후 jupiter... 를 입력해주세요.
        // expect와 actual 2개의 데이터를 입력하면 됩니다.
        // 혹시 임포트가 제대로 되지 않으면 아래 import 구문입니다.
        // import static org.junit.jupiter.api.Assertions.assertEquals;

        // when절에서 얻어온 boardList의 첫 자료의 writer는 "서울여대" 일것이라고 단언한다
        assertEquals("kim", boardList.get(0).getWriter());
    }

    @Test
    public void findBoardByBoardNumTest(){
        // given : 사전준비
        // 대부분의 코드에서 매직넘버를 직접 쓰지 않는것이 좋습니다.
        // findBoardByBoardNum() 호출시 int자료를 하나 넘겨야 하므로
        // given절에서 해당 자료를 미리 선언해둡니다.
        final int BOARD_NUM = 2;// 2번글에 대한 조회를 할 예정임

        // when : 실제 기능 호출
        Board board = boardRepository.findBoardByBoardNum(BOARD_NUM);

        // then : when절 결과에 대한 단언
        assertEquals("김민재 뮌헨 직관가고 싶다.", board.getContent());
        assertEquals("choi", board.getWriter());
    }

    // 테스트코드 양식을 직접 만들어보세요.
    @Test
    public void deleteBoardByBoardNumTest(){
        // given : 삭제할 글을 아래에 변수로 저장해주세요.
        final int BOARD_NUM = 2;// 2번글에 대한 조회를 할 예정임

        // when : 삭제 후에 전체 데이터의 개수를 .size()로 조회해 변수에 저장해주세요.
        //        그 다음, 이미 삭제된 글 번호로 또 삭제를 수행하고 결과를 변수에 저장해주세요.
        boardRepository.deleteBoardByBoardNum(BOARD_NUM);
        int boardListSize = boardRepository.getBoardList().size();
        boolean deleteBool = boardRepository.deleteBoardByBoardNum(BOARD_NUM);

        // then : 단언문에서 데이터 개수를 단언해주시고, boolean결과도 단언해주세요.
        assertEquals(2, boardListSize);
        assertEquals(false, deleteBool);
    }

    // save 로직에 대해서 테스트코드를 임의로 작성해보세요.





}