package com.dams.java.chapter14;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try{
            String filename = "text.txt";
            FileInputStream fis = new FileInputStream(filename);

            int data = 0;

            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(" =============== ");
            fis.close();

            FileReader fr = new FileReader(filename);

            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(" =============== ");
            fr.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
