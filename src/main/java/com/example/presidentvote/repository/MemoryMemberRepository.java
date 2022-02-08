package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<String, Member> store = new HashMap<>();
    //private static long sequence = 0L;


    @Override
    public Member save(Member member) {
       // member.setId(++sequence);
        store.put(member.getId(), member);
//        store.put(member.getPassword(), member);
        store.put(member.getName(), member); //인식안됨
//        store.put(String.valueOf(member.getNumber()), member);
//        store.put(String.valueOf(member.getRRN()), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
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

    @Override
    public Optional<Member> findByPassword(String password) {
        return store.values().stream()
                .filter(member -> member.getPassword().equals(password))
                .findAny();
    }


    @Override
    public Optional<Member> findByNumber(Long number) {
        return store.values().stream()
                .filter(member -> member.getNumber().equals(number))
                .findAny();
    }

    @Override
    public Optional<Member> findByRNN(Long RRN) {
        return store.values().stream()
                .filter(member -> member.getRRN().equals(RRN))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }

}
