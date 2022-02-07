package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setId("huijii");
        member.setPassword("131423fqw32");
        member.setName("huiji");
        member.setNumber(20662846L);
        member.setRRN(92010387532L);

        //when
        repository.save(member);

        //then
        Member resultId = repository.findById(member.getId()).get();
        assertThat(resultId).isEqualTo(member);
        System.out.println("id : " + member.getId() + "\npassword : " + member.getPassword() + "\nname : " + member.getName()
        + "\nnumber : " + member.getNumber() + "\nRRN : " + member.getRRN());

    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2); //다시하기
    }
}