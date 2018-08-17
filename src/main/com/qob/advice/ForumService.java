package com.qob.advice;

import java.sql.SQLException;

public class ForumService {
    public void removeTopic(int topicId)
    {
        throw new RuntimeException("运行异常");
    }
    public void removeForum(int forumId) throws Exception
    {
        throw  new SQLException("数据更新操作异常");
    }
}
