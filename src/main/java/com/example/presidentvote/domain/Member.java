package com.example.presidentvote.domain;

//회원 객체
public class Member {

    private String id; //아이디
    private String password; //비밀번호
    private String name; //이름
    private int number; //전화번호
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getRRN() { return RRN; }

    public void setRRN(Long RRN) { this.RRN = RRN; }
}