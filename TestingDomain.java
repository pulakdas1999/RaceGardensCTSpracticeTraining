package com.RaceGardens.Home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestingDomain {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String dat = sc.next();
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dat);
        Date today = new Date();
        System.out.println("Today's date = "+today+" Entered date = "+date);
        System.out.println("Press enter to continue...");
        try{System.in.read();}catch (Exception e){}
    }
}
