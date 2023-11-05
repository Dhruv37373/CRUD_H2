package com.h2.cruddemo.firstcrud.entity;

import javax.persistence.*;


@Entity
@Table(name = "Userstable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passwd;

    public Integer getId(){
        return id;
    }
    public String getUserName(){
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setUserName(String abc){
        this.userName = abc;
    }

    public void setPasswd(String pass){
        this.passwd  = pass;
    }

    public User() {
    }

    public User(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }


}
