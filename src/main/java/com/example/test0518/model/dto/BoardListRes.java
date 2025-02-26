package com.example.test0518.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListRes {
    private Long id;
    private String title;
    private String writer;
    private Integer commentCount;
}
