package com.example.presidentvote;

import com.example.presidentvote.repository.JdbcTemplateMemberRepository;
import com.example.presidentvote.repository.JpaMemberRepository;
import com.example.presidentvote.repository.MemberRepository;
import com.example.presidentvote.repository.MemoryMemberRepository;
import com.example.presidentvote.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}
