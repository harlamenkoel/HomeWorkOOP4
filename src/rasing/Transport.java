package rasing;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineSize;

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

    public abstract void start();

    public abstract void stop();

    public abstract void printType();
}
