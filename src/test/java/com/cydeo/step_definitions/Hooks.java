package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void SetUp(){
        System.out.println("Steps that needs to before each scenario can be put here");
    }

    @After
    public void tearDown(){
        System.out.println("Steps that need to run after each scenario");
        Driver.closeDriver();
    }

}
