package com.example.test0518;

import com.example.test0518.model.dto.BoardReq;
import com.example.test0518.model.dto.BoardRes;
import com.example.test0518.model.dto.BoardListRes;
import com.example.test0518.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Tag(name = "Board API", description = "게시판 관련 API")
public class BoardController {
    private final BoardService boardService;

    // 게시글 목록 조회
    @Operation(summary = "게시글 목록 조회", description = "모든 게시글 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<BoardListRes>> getBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    // 게시글 상세 조회
    @Operation(summary = "게시글 상세 조회", description = "게시글 ID로 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<BoardRes> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    // 게시글 작성
    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    @PostMapping
    public ResponseEntity<BoardRes> createBoard(@RequestBody BoardReq request) {
        return ResponseEntity.ok(boardService.createBoard(request));
    }
}
