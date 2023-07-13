package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class AuthorizationLevelTests {

    @Test
    void testAuthorizationLevelGivesCorrectBoolean(){
        assertFalse(AuthorizationLevel.checkAllowedActions(AuthorizationLevel.LEVEL_1));
        assertTrue(AuthorizationLevel.checkAllowedActions(AuthorizationLevel.LEVEL_2));
        assertTrue(AuthorizationLevel.checkAllowedActions(AuthorizationLevel.LEVEL_3));
    }

}
