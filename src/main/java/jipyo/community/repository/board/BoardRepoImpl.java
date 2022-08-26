package jipyo.community.repository.board;

import jipyo.community.domain.entity.Board;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BoardRepoImpl implements SelectBoard {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Board findById(Long id) {
        Board board = entityManager.find(Board.class, id);
        return board;
    }

    @Override
    public List<Board> find() {
        Query query = entityManager.createQuery("SELECT b FROM Board b", Board.class);
        return query.getResultList();
    }
}
