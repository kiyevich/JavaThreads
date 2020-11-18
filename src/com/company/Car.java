package com.company;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private int carId;
    private int parkingTime;
    private int timeToWaitFreePlace;
    private Semaphore semaphore;

    public Car(int carId, Semaphore sem, int parkingTime, int timeToWaitFreePlace) {
        this.carId = carId;
        this.semaphore = sem;
        this.parkingTime = parkingTime;
        this.timeToWaitFreePlace = timeToWaitFreePlace;

    }

    public int getCarId() {
        return carId;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Car %d is waiting any place\n", carId);
            if(semaphore.tryAcquire(this.timeToWaitFreePlace, TimeUnit.SECONDS)) {

                System.out.printf("Car %d  | | <-  \n", carId);

                sleep(parkingTime * 1000);

                System.out.printf("Car %d | | -> \n", carId);

                semaphore.release();
            }
            else{
                System.out.printf("Car %d  X \n", carId);

            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}


