package com.sparta.board.service;

import com.sparta.board.domain.Board;
import com.sparta.board.domain.BoardRepository;
import com.sparta.board.dto.BoardListResponseDto;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    // 글 등록
    @Transactional
    public BoardResponseDto create(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        BoardResponseDto responseDto = new BoardResponseDto(board);
        return responseDto;
    }

    // 전체 글 조회
    @Transactional
    public List<BoardListResponseDto> readAll() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    ///글 하나 조회
    @Transactional
    public BoardResponseDto readOne(Long id) {
        // 조회한 id로 게시판 가져오기
        Board board =  boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return new BoardResponseDto(board);
    }

    // 글 수정
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    // 삭제
    @Transactional
    public Long delete(Long id) {
        boardRepository.deleteById(id);
        return id;
    }

    // 비밀번호 일치 확인
    @Transactional
    public boolean checkPassword(Long id, String inputPassword) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (inputPassword.equals(board.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
