package com.example.presidentvote.repository;

import com.example.presidentvote.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
        //jdbcInsert.withTableName("member").usingColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", member.getId());
        parameters.put("password", member.getPassword());
        parameters.put("name", member.getName());
        parameters.put("RRN", member.getRRN());
        parameters.put("number", member.getNumber());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(String.valueOf(key.longValue()));
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
        System.out.println("~~id : "+ id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        List<Member> result = jdbcTemplate.query("select * from member where password = ?", memberRowMapper(), password);
        System.out.println("~~password : "+ password);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
        System.out.println("~~name : "+ name);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByRRN(Long RRN) {
        List<Member> result = jdbcTemplate.query("select * from member where RRN = ?", memberRowMapper(), RRN);
        System.out.println("~~RRN : "+ RRN);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByNumber(Long number) {
        List<Member> result = jdbcTemplate.query("select * from member where number = ?", memberRowMapper(), number);
        System.out.println("~~number : "+ number);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
        //return jdbcTemplate.query("insert into member(id, password, name, number, RRN) values('huiji', 'asfd', 'huijikim', '1111', '1111')", memberRowMapper());
    }


    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getString("id"));
            member.setPassword(rs.getString("password"));
            member.setName(rs.getString("name"));
            member.setRRN(rs.getLong("RRN"));
            member.setNumber(rs.getLong("number"));
            return member;
        };
    }

}
