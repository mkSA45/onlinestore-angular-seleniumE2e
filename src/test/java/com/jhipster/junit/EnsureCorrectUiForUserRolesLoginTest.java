package com.jhipster.junit;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jhipster.SignInOutActionsExample;

public class EnsureCorrectUiForUserRolesLoginTest {

    private static SignInOutActionsExample seleniumExample;
//    private String expectedTitle = "About Baeldung | Baeldung";
    private String expectedTitle = "Welcome, Java Hipster!";

    @BeforeClass
    public static void setUpBeforeClass() {
        seleniumExample = new SignInOutActionsExample();
    }

    @AfterClass
    public static void tearDownAfterClass() throws IOException {
        seleniumExample.closeWindow();
    }
    
    @After
    public void tearDown() {
    	seleniumExample.signOutRegardlessOfUserRole();
    }
    
    @Test
    public void whenAdminSignIn_thenAdministrationNavBarItemPresent() {
    	seleniumExample.signInAsAdmin();
    	assertTrue(seleniumExample.isAdministrationDropDownAvailable());
    }
    
    @Test
    public void whenUserSignIn_thenAdministrationNavBarItemMissing() {
    	seleniumExample.signInAsUser();
    	assertTrue(seleniumExample.isAdministrationDropDownMissing());
    }

}
