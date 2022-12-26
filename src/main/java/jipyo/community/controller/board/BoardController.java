package jipyo.community.controller.board;

import jipyo.community.domain.ResponseBoardVO;
import jipyo.community.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService board) {
        this.boardService = board;
    }

    @RequestMapping(value = "board/", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> boardList() {
        HttpHeaders headers = new HttpHeaders();

        List<ResponseBoardVO> boards = boardService.findBoardList();

        Map<String, Object> body = new HashMap<>();
        body.put("board-list", boards);
        body.put("boards-length", boards.size());

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "board/{board-index}", method = RequestMethod.GET)
    public ResponseEntity<ResponseBoardVO> boardDetails(@PathVariable(value = "board-index") Long index) {
        HttpHeaders headers = new HttpHeaders();
        ResponseBoardVO vo = boardService.findBoard(index);

        return new ResponseEntity<>(vo, headers, HttpStatus.OK);
    }
}
