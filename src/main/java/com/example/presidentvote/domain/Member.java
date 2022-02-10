package com.example.presidentvote.domain;

import javax.persistence.*;

//회원 객체
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id")
    private String id; //아이디
    @Column(name="password")
    private String password; //비밀번호
    @Column(name="name")
    private String name; //이름
    @Column(name="number")
    private Long number; //전화번호
    @Column(name="RRN")
    private Long RRN; //주민등록번호


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getRRN() { return RRN; }

    public void setRRN(Long RRN) { this.RRN = RRN; }
}