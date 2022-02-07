package com.example.presidentvote.service;

import com.example.presidentvote.domain.Member;
import com.example.presidentvote.repository.MemberRepository;
import com.example.presidentvote.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public String join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        validateDuplicateMember2(member);
        memberRepository.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    private void validateDuplicateMember2(Member member) {
        memberRepository.findByRNN(member.getRRN())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 주민등록번호입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }

}
