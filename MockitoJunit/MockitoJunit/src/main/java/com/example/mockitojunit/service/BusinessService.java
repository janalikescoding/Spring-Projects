package com.example.mockitojunit.service;

import com.example.mockitojunit.repository.DataRepository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class BusinessService {

    private DataRepository dataRepository;

    public BusinessService(DataRepository dataRepository){
        super();
        this.dataRepository = dataRepository;
    }

    public int findTheGreatestNumber(){
        int[] data  = dataRepository.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for(int value : data){
            if(value > greatest){
                greatest = value;
            }
        }
        return greatest;
    }
}
