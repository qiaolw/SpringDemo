package com.qob.Dao;

import com.qob.Pojo.TLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TLoginLogDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final static String INSERT_LOGIN_LOG_SQL = "INSERT INTO login_log(user_id,ip,login_datetime) VALUES(?,?,?)";

    public void insertLoginLog(TLoginLog loginLog){
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }
}
