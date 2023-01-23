package rasing;

import rasing.driver.BodyType;

public class Car extends Transport implements Competing {

    private BodyType bodyType;


    public Car(String brand,
               String model,
               double engineSize,
               BodyType bodyType) {
        super(brand, model, engineSize);
        this.bodyType = bodyType;
    }


    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public void start() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void printType() {
        if (getBodyType() == null) {
            System.out.println("Данных по авто не достаточно");
        } else {
            System.out.println("Тип кузова авто: " + getBodyType());
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.7;
    }

    @Override
    public void repair() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " починен.");
    }

    @Override
    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + " прошел пит-стоп");

    }

    @Override
    public int bestLoopTime() {
        return (int) ((Math.random() + 1) * 10);
    }

    @Override
    public int maxSpeed() {
        return (int) ((Math.random() + 1) * 200);
    }


}
