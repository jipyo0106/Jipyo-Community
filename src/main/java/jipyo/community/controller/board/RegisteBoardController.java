package jipyo.community.controller.board;

import jipyo.community.domain.RegisteBoardDTO;
import jipyo.community.service.board.BoardService;
import jipyo.community.service.board.RegisteBoardService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "board/registe")
public class RegisteBoardController {
    private final BoardService boardService;
    private final RegisteBoardService registeBoardService;

    public RegisteBoardController(BoardService boardService, RegisteBoardService registeBoardService) {
        this.boardService = boardService;
        this.registeBoardService = registeBoardService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registeBoard(@RequestBody @Valid RegisteBoardDTO board) {
        HttpHeaders headers = new HttpHeaders();

        long index = registeBoardService.registeBoardService(board);
        headers.setLocation(URI.create("/board/" + index));

        return new ResponseEntity(null, headers, HttpStatus.CREATED);
    }
}
