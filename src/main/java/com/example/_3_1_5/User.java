package com.example._3_1_5;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private Byte age;

    public User() {
    }
    public User(Long id, String name, String lastname, Byte age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
    public User(Long id) {

        this.id = id;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getLastname() {

        return lastname;
    }
    public void setLastname(String lastname) {

        this.lastname = lastname;
    }
    public Byte getAge() {

        return age;
    }
    public void setAge(Byte age) {

        this.age = age;
    }
}
