package com.qob.Service;

import com.qob.Dao.TLoginLogDao;
import com.qob.Dao.TUserDao;
import com.qob.Pojo.TLoginLog;
import com.qob.Pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TUserService {
    private TUserDao userDao;
    private TLoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(TUserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(TLoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public TUser findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(TUser user){
        user.setCredits(5 + user.getCredits());

        TLoginLog loginLog = new TLoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
