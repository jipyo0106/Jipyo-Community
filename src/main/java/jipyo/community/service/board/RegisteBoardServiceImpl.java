package jipyo.community.service.board;

import jipyo.community.domain.RegisteBoardDTO;
import jipyo.community.repository.board.RegisteBoard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class RegisteBoardServiceImpl implements RegisteBoardService {
    private final RegisteBoard registeBoard;

    public RegisteBoardServiceImpl(RegisteBoard registeBoard) {
        this.registeBoard = registeBoard;
    }

    @Override
    public Long registeBoardService(RegisteBoardDTO board) {
        return registeBoard.save(board.toBoardEntity());
    }
}
