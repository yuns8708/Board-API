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
public class BoardListResponseDto {
    // 제목
    private String title;
    // 작성자명
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;



    // Entity -> dto
    public BoardListResponseDto (Board board) {
        this.title = board.getTitle();
        this.username = board.getUsername();
        this.createdAt = board.getModifiedAt();
        this.modifiedAt = board.getCreatedAt();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.username = board.get().getUsername();
        this.createdAt = board.get().getModifiedAt();
        this.modifiedAt = board.get().getCreatedAt();
    }
}
