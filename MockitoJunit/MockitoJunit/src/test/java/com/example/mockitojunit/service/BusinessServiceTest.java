package com.example.mockitojunit.service;

import com.example.mockitojunit.repository.DataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusinessServiceTest {
    @MockitoBean
    DataRepository dataRepository;

    @Autowired
    BusinessService businessService;

    @Test
    public void testFindTheGreatestFromAllData(){
        when(dataRepository.retrieveAllData()).thenReturn(new int[]{24,5,3});
        assertEquals(25,businessService.findTheGreatestNumber());
    }

    @Test
    public void testFindTheGreatest_fromOneValue(){
        when(dataRepository.retrieveAllData()).thenReturn(new int[]{15});
        assertEquals(15,businessService.findTheGreatestNumber());
    }

    @Test
    public void testFindTheGreatest_NoValues(){
        when(dataRepository.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE,businessService.findTheGreatestNumber());
    }
}
