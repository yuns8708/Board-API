package com.sparta.board.repository;

import com.sparta.board.domain.Board;
import com.sparta.board.dto.BoardListResponseDto;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
//    List<Board> findAllByOrderByModifiedAtDesc();
//    List<BoardResponseDto> findAllByOrderByModifiedAtDesc();
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}
