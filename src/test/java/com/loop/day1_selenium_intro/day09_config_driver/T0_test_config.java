package com.loop.day1_selenium_intro.day09_config_driver;


import Utility.ConfigurationReader;

public class T0_test_config {

    public static void main(String[] args) {
        System.out.println(ConfigurationReader.getProperty("env"));
    }
}