package com.example.junitmockito.service;

import com.example.junitmockito.repository.DataService;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private DataService dataService;

    public BusinessService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for (int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }
}