package com.cn.dao;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 15:42
 */
public class ProviderDao {

    private String url;
    private String driver;
    private String user;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void update(){
        System.out.println("数据库更新...........");
    }
}
