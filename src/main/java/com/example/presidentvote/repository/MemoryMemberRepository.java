package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<String, Member> store = new HashMap<>();
    //private static long sequence = 0L;


    @Override
    public Member save(Member member) {
       // member.setId(++sequence);
        store.put(member.getId(), member);
        store.put(String.valueOf(member.getNumber()), member);
        store.put(String.valueOf(member.getRRN()), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
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
    public Optional<Member> findByPassword(String password) {
        return Optional.empty();
    }


    @Override
    public Optional<Member> findByNumber(Long Number) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByRNN(Long RNN) {
        return Optional.empty();
    }


}
