package rasing;

import rasing.driver.BodyType;

public class Car extends Transport implements Competing {

    private BodyType bodyType;


    public Car(String brand,
               String model,
               double engineSize,
               BodyType bodyType) {
        super(brand, model, engineSize);
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
