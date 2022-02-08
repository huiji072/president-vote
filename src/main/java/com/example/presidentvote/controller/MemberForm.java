package com.example.presidentvote.controller;

public class MemberForm {

    private String id;
    private String password;
    private String name;
    private Long number;
    private Long RRN;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getRRN() {
        return RRN;
    }

    public void setRRN(Long RRN) {
        this.RRN = RRN;
    }
}