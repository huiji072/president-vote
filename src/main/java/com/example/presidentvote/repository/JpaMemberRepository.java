package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        Member member = em.find(Member.class, id);
        System.out.println(id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        List<Member> result = em.createQuery("select m from Member m where m.password = :password", Member.class)
                .setParameter("password", password)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByNumber(Long number) {
        List<Member> result = em.createQuery("select m from Member m where m.number = :number", Member.class)
                .setParameter("number", number)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByRRN(Long RRN) {
        List<Member> result = em.createQuery("select m from Member m where m.RRN = :RRN", Member.class)
                .setParameter("RRN", RRN)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();

    }
}
