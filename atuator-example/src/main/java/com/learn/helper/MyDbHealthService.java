package com.learn.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyDbHealthService implements HealthIndicator {
    public  static final String DB_Service="Database Service";
    public boolean isHealthGood(){
        //custom logic
        return true;
    }


    @Override
    public Health health() {
        if(isHealthGood()){
            return Health.up().withDetail(DB_Service,"Database service is running").build();
        }
        return Health.down().withDetail(DB_Service,"Database service is down").build();
    }
}
