package com.liwei.gmall.bean;

import java.io.Serializable;

public class UserAddress implements Serializable {

    private Integer id;
    private String userAddress;//用户地址
    private String userId;//用户id
    private String userSignee;//收货人
    private String phoneNum;//电话号码
    private String idDefault;//是否为默认地址 Y-是 N-否

    public UserAddress(){
        super();
    }

    public UserAddress(Integer id, String userAddress, String userId, String userSignee, String phoneNum, String idDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.userSignee = userSignee;
        this.phoneNum = phoneNum;
        this.idDefault = idDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSignee() {
        return userSignee;
    }

    public void setUserSignee(String userSignee) {
        this.userSignee = userSignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdDefault() {
        return idDefault;
    }

    public void setIdDefault(String idDefault) {
        this.idDefault = idDefault;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", userSignee='" + userSignee + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", idDefault='" + idDefault + '\'' +
                '}';
    }
}