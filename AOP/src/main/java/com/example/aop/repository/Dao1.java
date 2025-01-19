package com.example.aop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    public String retrieveSomething(){
        return "Dao 1";
    }
}
