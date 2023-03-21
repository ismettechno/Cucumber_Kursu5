package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;

public class Hooks {


    @After  // her senaryodan sonra çalışacak bölüm
    public void after(){
        System.out.println("Senaryo bitti");
        GWD.quitDriver();
    }

}
