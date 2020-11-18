package com.company;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Semaphore parking = new Semaphore(4);
        Random rand = new Random();

        for(int i = 1;  i < 11; i++){
            new Car(i, parking, 5, 1).start();
      
            Double d = new Double("0.0");
        }


    }
}
