package com.sparta.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    // 제목
    private String title;

    // 작성자명
    private String username;

    // 작성 내용
    private String content;

    // 비밀번호
    private String password;

    // 비교할 비밀번호 받기
    private String checkPassword;
}
