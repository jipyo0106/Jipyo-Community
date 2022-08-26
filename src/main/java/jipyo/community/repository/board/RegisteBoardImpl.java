package jipyo.community.repository.board;

import jipyo.community.domain.entity.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RegisteBoardImpl implements RegisteBoard {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Board board) {
        entityManager.persist(board);
        return board.getId();
    }
}
