package com.qob.Dao;

import com.qob.Pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TUserDao {
    private JdbcTemplate jdbcTemplate;
    private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user WHERE user_name=? and password=?";
    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit=?,last_ip=?,credits=? WHERE user_id=?";
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password){

        System.out.println("userName " + userName + " password " + password);
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, int.class);
    }

    public TUser findUserByUserName(String userName){
        TUser tUser = new TUser();
        jdbcTemplate.query(" SELECT * FROM t_user WHERE user_name=?", new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                tUser.setUserId(rs.getInt("user_id"));
                tUser.setUserName(userName);
                tUser.setCredits(rs.getInt("credits"));
            }
        });

        return tUser;
    }

    public void updateLoginInfo(TUser user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{
                user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()
        });
    }
}
