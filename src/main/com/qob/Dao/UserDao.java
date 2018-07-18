package com.qob.Dao;

import com.qob.Pojo.QBUser;

public interface UserDao {
    //根据用户id查询用户信息
    public QBUser findUserById(int id);
}
