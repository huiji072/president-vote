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
        store.put(member.getId(), member);
//        store.put(member.getPassword(), member);
        //store.put(member.getName(), member); //인식안됨
//        store.put(String.valueOf(member.getNumber()), member);
//        store.put(String.valueOf(member.getRRN()), member);
        return member;
    }

//    @Override
//    public Optional<Member> findByNum(Long num) {
//        return Optional.ofNullable(store.get(num));
//    }

    @Override
    public Optional<Member> findById(String id){
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name)  {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public Optional<Member> findByPassword(String password)   {
        return Optional.ofNullable(store.get(password));
    }


    @Override
    public Optional<Member> findByNumber(Long number) {
        return Optional.ofNullable(store.get(number));
    }

    @Override
    public Optional<Member> findByRRN(Long RRN) {
        return Optional.ofNullable(store.get(RRN));
    }

    public void clearStore() {
        store.clear();
    }

}
