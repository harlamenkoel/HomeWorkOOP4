package rasing;

public class Bus extends Transport implements Competing {
    public Bus(String brand,
               String model,
               double engineSize) {
        super(brand, model, engineSize);
    }

    @Override
    public void start() {
        System.out.println("Автобус "+getBrand()+" "+getModel()+ " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Автобус "+getBrand()+" "+getModel()+ " закончил движение");
    }
    @Override
    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + " прошел пит-стоп");

    }

    @Override
    public int bestLoopTime() {
        return (int) ((Math.random()+1) * 20);
    }

    @Override
    public int maxSpeed() {
        return (int) ((Math.random()+1) * 80);
    }
}
