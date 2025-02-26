package com.example.test0518.model.dto;

import com.example.test0518.model.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardReq {
    private String title;
    private String content;
    private String writer; // 작성자

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
