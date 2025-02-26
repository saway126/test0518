package com.example.test0518.model.dto;

import com.example.test0518.model.Board;
import lombok.Builder;
import lombok.Getter;

public class BoardDto {

    @Getter
    public static class BoardReq {  // 내부 클래스 이름 추가
        private String title;
        private String content;
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class BoardRes {
        private Long id;
        private String title;
        private String contents;

        }
    }
