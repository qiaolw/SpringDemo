package com.qob.Pojo;

import org.springframework.stereotype.Component;

@Component("liuDeHua")
public class TLiuDeHua implements TGeLi {

    @Override
    public void responseAsk(String respAsk) {
        System.out.println("TLiuDeHua " + respAsk);
    }
}
