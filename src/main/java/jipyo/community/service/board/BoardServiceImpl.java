package jipyo.community.service.board;

import jipyo.community.domain.entity.Board;
import jipyo.community.domain.ResponseBoardVO;
import jipyo.community.repository.board.BoardRepoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{
    private final BoardRepoImpl boardRepo;

    public BoardServiceImpl(BoardRepoImpl board) {
        this.boardRepo = board;
    }


    @Override
    public ResponseBoardVO findBoard(Long id) {
        return boardRepo.findById(id).toResponseBoardDTO();
    }

    @Override
    public List<ResponseBoardVO> findBoardList() {
        return boardRepo.find()
                .stream()
                .map(Board::toResponseBoardDTO)
                .collect(Collectors.toList());
    }
}
