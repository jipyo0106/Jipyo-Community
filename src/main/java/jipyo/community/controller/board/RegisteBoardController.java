package jipyo.community.controller.board;

import jipyo.community.domain.RegisteBoardDTO;
import jipyo.community.service.board.BoardServiceImpl;
import jipyo.community.service.board.RegisteBoardService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "board/registe")
public class RegisteBoardController {
    private final BoardServiceImpl boardService;
    private final RegisteBoardService registeBoardService;

    public RegisteBoardController(BoardServiceImpl boardService, RegisteBoardService registeBoardService) {
        this.boardService = boardService;
        this.registeBoardService = registeBoardService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registeForm() {
        return "registeForm";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registeBoard(@Valid RegisteBoardDTO board) {
        long id = registeBoardService.registeBoardService(board);
        return "redirect:/board?id=" + id;
    }
}
