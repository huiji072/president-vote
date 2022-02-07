package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }

    @Override
    public Optional<Member> findByPassword(Long password) {
        return Optional.empty();
    }


    @Override
    public Optional<Member> findByNumber(Long Number) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findBySex(Long sex) {
        return Optional.empty();
    }


}
