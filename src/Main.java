import rasing.Bus;
import rasing.Car;
import rasing.Transport;
import rasing.Truck;
import rasing.driver.*;

public class Main {
    public static void main(String[] args) {
        Car nissan = new Car("Nissan", "GT-R", 3.8, BodyType.COUPE);
        Car chevrolet = new Car("Chevrolet", "Camaro", 6.2, BodyType.COUPE);
        Car ford = new Car("Ford", "Mustang", 4.2, BodyType.COUPE);
        Car dodge = new Car("Dodge", "Charger", 3.6, BodyType.COUPE);

        Truck international = new Truck("International", "9400i", 15.0, LoadCapacity.getValue(63));
        Truck freightliner = new Truck("Freightliner", "Classic XL", 14.0, LoadCapacity.getValue(90));
        Truck volvo = new Truck("Volvo", "VT 880", 16.0, LoadCapacity.getValue(57));
        Truck kamaz = new Truck("КамАЗ", "4326-9", 16.2, LoadCapacity.getValue(3.5));

        Bus mercedes = new Bus("Mercedes-Benz", "Connect", 10.7, Size.getValue(45));
        Bus liaz = new Bus("ЛиАЗ", "6274", 11, Size.getValue(30));
        Bus olimp = new Bus("Олимп", "4252", 6.7, Size.getValue(100));
        Bus hyundai = new Bus("Hyundai", "Богдан", 3.9, Size.getValue(48));

        service(nissan, chevrolet, ford, dodge,
                international, freightliner, volvo, kamaz,
                mercedes, liaz, olimp, hyundai);

        DriverB petr = new DriverB("Петр Анисимов", true, 15, Category.B);
        DriverC ivan = new DriverC("Иван Климов", true, 20, Category.C);
        DriverD vasya = new DriverD("Василий Олежко", true, 10, Category.D);


        nissan.start();
        nissan.stop();
        System.out.println();
        kamaz.start();
        kamaz.stop();
        System.out.println();
        mercedes.start();
        mercedes.stop();
        System.out.println();
        chevrolet.pitStop();
        international.pitStop();
        liaz.pitStop();
        System.out.println();
        System.out.println("Лучшее время круга " + ford.getBrand() + " " + ford.getModel() + " " + ford.bestLoopTime() + " минут");
        System.out.println("Лучшее время круга " + freightliner.getBrand() + " " + freightliner.getModel() + " " + freightliner.bestLoopTime() + " минут");
        System.out.println("Лучшее время круга " + olimp.getBrand() + " " + olimp.getModel() + " " + olimp.bestLoopTime() + " минут");
        System.out.println();
        System.out.println("Максимальная скорость " + dodge.getModel() + " " + dodge.getBrand() + " " + dodge.maxSpeed() + " км/ч");
        System.out.println("Максимальная скорость " + volvo.getModel() + " " + volvo.getBrand() + " " + volvo.maxSpeed() + " км/ч");
        System.out.println("Максимальная скорость " + hyundai.getModel() + " " + hyundai.getBrand() + " " + hyundai.maxSpeed() + " км/ч");
        System.out.println();
        petr.startMove(chevrolet);
        petr.refill(chevrolet);
        petr.stopMove(chevrolet);
        ivan.startMove(freightliner);
        ivan.refill(freightliner);
        ivan.stopMove(freightliner);
        vasya.stopMove(olimp);
        ivan.printInfoDriver(volvo);
        petr.printInfoDriver(chevrolet);
        vasya.printInfoDriver(olimp);
        chevrolet.printType();
        volvo.printType();
        olimp.printType();
    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }

    private static void serviceTransport(Transport transport) {
        if (!transport.service()) {
            try {
                throw new RuntimeException("Транспорт" + transport.getBrand() + " " + transport.getModel() + " не прошел ТО");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}