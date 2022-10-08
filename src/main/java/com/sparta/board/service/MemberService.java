package com.sparta.board.service;

import com.sparta.board.domain.Member;
import com.sparta.board.dto.SignupRequestDto;
import com.sparta.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String email = requestDto.getEmail();

        // 회원 ID 중복 확인
        Optional<Member> found = memberRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        // 사용자 ROLE 관리자인지 확인
        if (requestDto.isAdmin()) {
            // requestDto의 adminToken과 Service의 ADMIN_TOKEN이 같지 않을 경우
            if(!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀렸습니다.");
            }

            // 토큰 확인 후 같았을 경우는, role에 ADMIN(관리자)값을 부여
//            role = UserRoleEnum.ADMIN;
        }

        Member member = new Member(username, password, email);
        memberRepository.save(member);
    }
}
