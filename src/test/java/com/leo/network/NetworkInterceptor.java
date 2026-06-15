package com.leo.network;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

public class NetworkInterceptor {

    private DevTools devTools;

    public NetworkInterceptor(WebDriver driver){

        devTools = ((HasDevTools)driver).getDevTools();

        devTools.createSession();

    }

    public void enableNetwork(){

        System.out.println("Network Listener Enabled");

    }

}