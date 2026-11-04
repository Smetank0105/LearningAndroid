package com.academy.learningandroid;

public class Contact {
    private String name;
    private String phone;
    private int avatar;

    public Contact(String name, String phone, int avatar) {
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatar() {
        return avatar;
    }
}
