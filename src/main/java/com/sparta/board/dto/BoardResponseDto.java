package com.sparta.board.dto;

import com.sparta.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardResponseDto {
    // 제목
    private String title;

    // 작성자명
    private String username;
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    // Entity -> dto
    public BoardResponseDto (Board board) {
        this.title = board.getTitle();
        this.username = board.getUsername();
        this.content = board.getContent();
        this.createdAt = board.getModifiedAt();
        this.modifiedAt = board.getCreatedAt();
    }
}
