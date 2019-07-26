package com.cn.pojo;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 14:34
 */
public class Cat {
    private String skin;
    private String leg;

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "skin='" + skin + '\'' +
                ", leg='" + leg + '\'' +
                '}';
    }
}
