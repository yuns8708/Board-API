package com.sparta.board.domain;

import com.sparta.board.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Member {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    // 회원 1명이 여러 개의 게시글을 가질 수 있음
//    @OneToMany
//    private List<Board> boards;
    public Member(String username, String memberPw, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Member(SignupRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.email = getEmail();
    }
}
