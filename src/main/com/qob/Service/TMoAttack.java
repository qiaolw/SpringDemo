package com.qob.Service;

import com.qob.Pojo.TGeLi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TMoAttack {
    @Autowired
    private TGeLi geli;

    public void setGeli(TGeLi geli) {
        this.geli = geli;
    }

    public void cityGateAsk(){
        geli.responseAsk("墨者革离");
    }
}
