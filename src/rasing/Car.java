package rasing;

public class Car extends Transport implements Competing {


    public Car(String brand,
               String model,
               double engineSize) {
        super(brand, model, engineSize);
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
        return (int) ((Math.random()+1) * 10);
    }

    @Override
    public int maxSpeed() {
        return (int) ((Math.random()+1) * 200);
    }
}
