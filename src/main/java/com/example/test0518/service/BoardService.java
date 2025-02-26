package com.example.test0518.service;

import com.example.test0518.model.Board;
import com.example.test0518.model.dto.BoardReq;
import com.example.test0518.model.dto.BoardRes;
import com.example.test0518.model.dto.BoardListRes;
import com.example.test0518.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 목록 조회 (댓글 개수 포함)
    public List<BoardListRes> getAllBoards() {
        List<Object[]> results = boardRepository.findBoardListWithCommentCount();
        return results.stream()
                .map(result -> new BoardListRes(
                        (Long) result[0], (String) result[1], (String) result[2], (Integer) result[3]))
                .collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public BoardRes getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return BoardRes.of(board);
    }

    // 게시글 작성
    public BoardRes createBoard(BoardReq request) {
        Board board = request.toEntity();
        Board savedBoard = boardRepository.save(board);
        return BoardRes.of(savedBoard);
    }
}