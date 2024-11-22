package com.cydeo.utilities;

public class MobileUtils {


    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
