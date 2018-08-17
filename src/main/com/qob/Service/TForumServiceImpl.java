package com.qob.Service;

public class TForumServiceImpl implements TForumService {
    public void removeTopic(int topicId){
//        TPerformanceMonitor.begin("com.qob.Service.TForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录: " + topicId);
        try{
            Thread.currentThread().sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

//        TPerformanceMonitor.end();
    }

    public void removeForum(int forumId){
//        TPerformanceMonitor.begin("com.qob.Service.TForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录: " + forumId);
        try{
            Thread.currentThread().sleep(40);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

 //       TPerformanceMonitor.end();
    }
}
