package com.qob.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("byeService")
public class ByeService {
    @Value("aaaaaaaaaaaaaaaaaaaaa")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayBye() {
        System.out.println("Bye, " + name);
    }
}
