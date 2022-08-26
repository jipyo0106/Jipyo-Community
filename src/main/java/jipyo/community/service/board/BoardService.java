package jipyo.community.service.board;

import jipyo.community.domain.ResponseBoardVO;

import java.util.List;

public interface BoardService {

    ResponseBoardVO getBoard(Long id);

    List<ResponseBoardVO> getBoardList();

}
