package com.example.aop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    public String retrieveSomething(){
        return "Dao 2";
    }
}
