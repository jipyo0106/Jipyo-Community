package jipyo.community.repository.board;

import jipyo.community.domain.entity.Board;

import java.util.List;

public interface BoardRepo {
    Board findById(Long id);
    List<Board> find();
}
