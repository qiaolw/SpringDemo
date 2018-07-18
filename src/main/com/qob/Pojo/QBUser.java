package com.qob.Pojo;

public class QBUser {
    public int userId;
    public String userName;
    public int userAge;
    public int userSex;

    @Override
    public String toString() {
        return "userId " + userId + " userName " + userName + " userAge " + userAge + " userSex " + userSex;
    }
}
