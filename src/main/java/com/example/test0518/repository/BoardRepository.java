package com.example.test0518.repository;

import com.example.test0518.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b.id, b.title, b.writer, COUNT(c) " +
            "FROM Board b LEFT JOIN Comment c ON b.id = c.board.id " +
            "GROUP BY b.id")
    List<Object[]> findBoardListWithCommentCount();
}
