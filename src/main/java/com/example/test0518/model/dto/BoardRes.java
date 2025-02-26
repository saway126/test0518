package com.example.test0518.model.dto;

import com.example.test0518.model.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardRes {
    private Long id;
    private String title;
    private String content;
    private String writer;

    public static BoardRes of(Board board) {
        return BoardRes.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
    }
}
