package com.example.presidentvote;

import com.example.presidentvote.repository.MemberRepository;
import com.example.presidentvote.repository.MemoryMemberRepository;
import com.example.presidentvote.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
