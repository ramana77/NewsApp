package com.NewsApp.Screens;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.mobile.NetworkConnection;

public class Wifi{
    public String turnWifiOff(){
    	String adbCommand = "adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable";
    	runCommand(adbCommand);
    	public String runCommand(String command) throws InterruptedException, IOException {
    	p = Runtime.getRuntime().exec(command);
    	// get std output
    	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	String line = "";
    	String allLine = "";
    	int i = 1;
    	while ((line = r.readLine()) != null) {
    	allLine = allLine + "" + line + "\n";
    	if(line.contains("Console LogLevel: debug") && line.contains("Complete")) {
    	break;
    	}
    	i++
    	}
    	return allLine;
    	}

    }
    
    public String turnWifiOn(){
    	String adbCommand = "adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable";
    	runCommand(adbCommand);
    	public String runCommand(String command) throws InterruptedException, IOException {
    	p = Runtime.getRuntime().exec(command);
    	// get std output
    	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
    	String line = "";
    	String allLine = "";
    	int i = 1;
    	while ((line = r.readLine()) != null) {
    	allLine = allLine + "" + line + "\n";
    	if(line.contains("Console LogLevel: debug") && line.contains("Complete")) {
    	break;
    	}
    	i++
    	}
    	return allLine;
    	}

    }
    
}
