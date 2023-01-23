package rasing;

import rasing.driver.Driver;
import rasing.driver.Mechanic;
import rasing.driver.Sponsor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineSize;
    private final List<Driver<?>> drivers = new ArrayList<>();
    private final List<Mechanic<?>> mechanics = new ArrayList<>();
    private final List<Sponsor> sponsors = new ArrayList<>();

    public Transport(String brand,
                     String model,
                     double engineSize) {
        this.brand = brand;
        this.model = model;
        this.engineSize = engineSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void addDriver(Driver<?>... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));
    }

    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public List<Driver<?>> getDrivers() {
        return drivers;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void start();

    public abstract void stop();

    public abstract void printType();

    public abstract boolean service();


    public abstract void repair();
}
