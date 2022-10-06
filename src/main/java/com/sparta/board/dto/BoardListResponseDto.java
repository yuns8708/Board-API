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




    // Entity -> dto
    public BoardListResponseDto (Board board) {
        this.title = board.getTitle();
        this.username = board.getUsername();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.username = board.get().getUsername();
    }
}
