package jipyo.community.controller.board;

import jipyo.community.domain.ResponseBoardVO;
import jipyo.community.service.board.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "board")
public class BoardController {
    private final BoardServiceImpl boardService;

    @Autowired
    public BoardController(BoardServiceImpl board) {
        this.boardService = board;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model) {
        List<ResponseBoardVO> vo = boardService.getBoardList();
        model.addAttribute("list", vo);
        return "board";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBoard (@RequestParam(value = "id") Long id, Model model) {
        ResponseBoardVO vo = boardService.getBoard(id);

        System.out.println(vo.getDate());
        model.addAttribute("name", vo.getName());
        model.addAttribute("title", vo.getTitle());
        model.addAttribute("content", vo.getContent());
        model.addAttribute("date", vo.getDate());

        return "detailBoard";
    }
}
