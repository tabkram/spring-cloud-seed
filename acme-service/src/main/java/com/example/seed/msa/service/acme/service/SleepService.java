package com.example.seed.msa.service.acme.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SleepService {

    public static int sleepAndCrash(Optional<Float> failureProbability) throws Exception {
        failureProbability.ifPresent(pr -> {
            if(pr > Math.random()){
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("damn it!");
            }
        });
        return 1;
    }
}
