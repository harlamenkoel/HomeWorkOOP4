package rasing;

import rasing.driver.Size;

public class Bus extends Transport implements Competing {

    private Size size;

    public Bus(String brand,
               String model,
               double engineSize, Size size) {
        super(brand, model, engineSize);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public void start() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public void printType() {
        if (size == null) {
            System.out.println("Данных по авто не достаточно");
        } else {
            System.out.println("Пассажировместимость: " + getSize());
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " в диагностики не тебуеться");
        return true;
    }


    @Override
    public void repair() {

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
        return (int) ((Math.random() + 1) * 80);
    }
}
