package com.softserve.edu.utilities;

public class ProcessUtilities {
    public static void presentationSleep() {
        ProcessUtilities.presentationSleep(1);
    }

    public static void presentationSleep(int seconds) {
        long oneSecondDelay = 1000L;
        try {
            Thread.sleep(seconds * oneSecondDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
