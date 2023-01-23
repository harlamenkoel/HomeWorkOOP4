package rasing.driver;

import rasing.Transport;

public abstract class Driver<T extends Transport> {
    private final String name;
    private boolean hasDrivingLicense;
    private int experience;
    private Category category;


    public Driver(String name, boolean hasDrivingLicense, int experience, Category category) {
        this.name = name;
        this.hasDrivingLicense = hasDrivingLicense;
        this.experience = experience;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public boolean isHasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }

    public int getExperience() {
        return experience;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setExperience(int experience) {
        if (category == null) {
            throw new IllegalArgumentException("Необходимо указать категортию прав!");
        } else {
            this.experience = experience;
        }
    }


    public abstract void startMove(T transport);

    public abstract void stopMove(T transport);

    public abstract void refill(T transport);

    public void printInfoDriver(T transport) {
        System.out.println("Водитель " + name + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участвовать в заезде");
    }
}