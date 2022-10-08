package com.sparta.board.controller;

import com.sparta.board.dto.BoardListResponseDto;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    // 글 등록
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    // 전체 글 조회
    @GetMapping("/boards")
    public List<BoardListResponseDto> getAllBoards() {

        return boardService.readAll();
    }

    // 글 하나 조회 : 제목, 작성자명, 작성 날짜, 작성 내용 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.readOne(id);
    }

    // 글 수정
    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id,requestDto);
    }
    
    // 글 삭제
    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return  boardService.delete(id);
    }

    // 비밀번호 확인
    @GetMapping("/boards/check/{id}/{inputPassword}")
    public boolean checkPassword(@PathVariable Long id,@PathVariable String inputPassword) {
        return boardService.checkPassword(id, inputPassword);
    }
}
