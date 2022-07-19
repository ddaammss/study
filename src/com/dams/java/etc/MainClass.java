package com.dams.java.etc;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class MainClass {

    public static void main(String[] args) throws IOException {
        String dateStr = "2022062711";
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

        if(date.isBefore(currentDate) ){
            System.out.println("date2 = " + date);
            System.out.println("currentDate = " + currentDate);
        }
        MainClass mc = new MainClass();
        int c = mc.testMethod();
        System.out.println("c = " + c);
        System.out.println(" 11111111111111111111111111111111");
        /*LocalDateTime date = LocalDateTime.now();
        String sDate = "Tue Jun  7 11:09:52 KST 2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss").withLocale(Locale.forLanguageTag("ko"));
        String text = date.format(formatter);
        LocalDateTime  parsedDate = LocalDateTime.parse(text, formatter);
        System.out.println("text = " + text);
        
        System.out.println("parsedDate = " + parsedDate);*/


    }
    private Integer  testMethod(){
        System.out.println("true = " + true);
        return 0;
    }
}
