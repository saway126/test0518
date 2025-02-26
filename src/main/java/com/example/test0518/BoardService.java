package com.example.test0518;

import com.example.test0518.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 목록 조회
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    // 게시글 생성
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 상세 조회
    public Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }
}
