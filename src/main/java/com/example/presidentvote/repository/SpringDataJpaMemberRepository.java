package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    Optional<Member> findById(String id);
    Optional<Member> findByPassword(String password);
    Optional<Member> findByName(String name);
    Optional<Member> findByRRN(Long RRN);
    Optional<Member> findByNumber(Long number);

}
