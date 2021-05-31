package com.e17cn2.anti_covid.model;

public class User {
    private int id;
    private String address;
    private int age;
    private String phoneNumber;

    public User(int id, String address, int age, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
