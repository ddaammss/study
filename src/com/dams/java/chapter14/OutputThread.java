package com.dams.java.chapter14;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class OutputThread extends Thread {
    PipedWriter output = new PipedWriter();

    OutputThread(String name) {
        super(name);
    }
    public void run() {
        try{
            String msg = "Hello";
            System.out.println(getName() + "sent :" + msg);
            output.write(msg);
            output.close();
        }catch (IOException e){
        }
    }

    public PipedWriter getOutput(){
        return output;
    }
    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        InputThread inThread = new InputThread("InputThread");
        OutputThread outThread = new OutputThread("OutputThread");

        inThread.connect(outThread.getOutput());
        inThread.start(); outThread.start();

    }
}
