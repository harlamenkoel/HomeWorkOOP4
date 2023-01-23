package rasing.driver;

import rasing.Bus;

public class DriverD extends Driver<Bus> {
    public DriverD(String name, boolean hasDrivingLicense, int experience, Category category) {
        super(name, hasDrivingLicense, experience, category);
    }

    @Override
    public void startMove(Bus transport) {
        transport.start();
    }

    @Override
    public void stopMove(Bus transport) {
        transport.stop();
    }

    @Override
    public void refill(Bus transport) {
        System.out.println("Водитель " + getName() + " заправляет автобус " + transport.getBrand() + " " + transport.getModel());
    }
}
