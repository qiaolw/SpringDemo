package com.qob.Service;

/**
 * https://blog.csdn.net/gavin_john/article/details/79517418
 */
public class UserService {
    private String name;
    private ByeService mByeService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
        mByeService.sayBye();
    }

    public ByeService getmByeService() {
        return mByeService;
    }

    public void setmByeService(ByeService mByeService) {
        this.mByeService = mByeService;
    }
}
