package com.example.presidentvote.repository;

//회원 리포지토리 인터페이스

import com.example.presidentvote.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //회원 저장
    Member save(Member member);
    //회원 반환
    Optional<Member> findById(String id);
    Optional<Member> findByPassword(String password);
    Optional<Member> findByName(String name);
    Optional<Member> findByNumber(Long Number);
    Optional<Member> findByRNN(Long RNN);
    List<Member> findAll();

}