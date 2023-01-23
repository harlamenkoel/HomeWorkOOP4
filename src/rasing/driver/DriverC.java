package rasing.driver;

import rasing.Truck;

public class DriverC extends Driver<Truck> {
    public DriverC(String name, boolean hasDrivingLicense, int experience, Category category) {
        super(name, hasDrivingLicense, experience,category);
    }

    @Override
    public void startMove(Truck transport) {
        transport.start();
    }

    @Override
    public void stopMove(Truck transport) {
        transport.stop();
    }

    @Override
    public void refill(Truck transport) {
        System.out.println("Водитель " + getName() + " заправляет грузовой автомобиль " + transport.getBrand() + " " + transport.getModel());
    }
}
