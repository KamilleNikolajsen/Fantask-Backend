package com.example.fantaskbackend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AllServiceTest {

    @Autowired
    private AllService allService;

    @Test
    public void convertDateTest() throws Exception {
        String s = "11/05/2022";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(s);

        LocalDate localDate = LocalDate.of(2022,5,11);

        assertEquals(date,allService.convertToDate(localDate));
    }
}
