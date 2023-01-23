package rasing;

import rasing.driver.LoadCapacity;

public class Truck extends Transport implements Competing {

    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineSize, LoadCapacity loadCapacity) {
        super(brand, model, engineSize);
        this.loadCapacity = loadCapacity;
    }


    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void start() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void printType() {
        if (loadCapacity == null) {
            System.out.println("Данных по авто не достаточно");
        } else {
            System.out.println("Грузоподъемность: " + getLoadCapacity());
        }
    }


    @Override
    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + " прошел пит-стоп");

    }

    @Override
    public int bestLoopTime() {
        return (int) ((Math.random() + 1) * 20);
    }

    @Override
    public int maxSpeed() {
        return (int) ((Math.random() + 1) * 90);
    }
}
