package com.cn.pojo;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 14:50
 */
public class User {
    private String name;

    private String address;

    private Pig pig;

    public User() {
    }

    public User(String name, Pig pig) {
        this.name = name;
        this.pig = pig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pig getPig() {
        return pig;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pig=" + pig +
                '}';
    }
}
