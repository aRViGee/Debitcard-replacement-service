package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)

@TestPropertySource(locations = "classpath:application.properties")
public class CardArrangementServiceImplTest {

    @Autowired
    private CardArrangementService cardArrangementService;

    @Test
    public void testCanAddCardArrangement(){

    }

}
