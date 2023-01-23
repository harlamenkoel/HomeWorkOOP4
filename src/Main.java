import rasing.Bus;
import rasing.Car;
import rasing.Truck;
import rasing.driver.BodyType;
import rasing.driver.DriverB;
import rasing.driver.DriverC;
import rasing.driver.DriverD;

public class Main {
    public static void main(String[] args) {
        Car nissan = new Car("Nissan", "GT-R", 3.8, BodyType.COUPE);
        Car chevrolet = new Car("Chevrolet", "Camaro", 6.2, BodyType.COUPE);
        Car ford = new Car("Ford", "Mustang", 4.2, BodyType.COUPE);
        Car dodge = new Car("Dodge", "Charger", 3.6, BodyType.COUPE);

        Truck international = new Truck("International", "9400i", 15.0,63);
        Truck freightliner = new Truck("Freightliner", "Classic XL", 14.0,90);
        Truck volvo = new Truck("Volvo", "VT 880", 16.0,57);
        Truck kamaz = new Truck("КамАЗ", "4326-9", 16.2,3.5);

        Bus mercedes = new Bus("Mercedes-Benz", "Connect", 10.7,150);
        Bus liaz = new Bus("ЛиАЗ", "6274", 11,30);
        Bus olimp = new Bus("Олимп", "4252", 6.7,100);
        Bus hyundai = new Bus("Hyundai", "Богдан", 3.9,48);

        DriverB petr = new DriverB("Петр Анисимов", true, 15);
        DriverC ivan = new DriverC("Иван Климов", true, 20);
        DriverD vasya = new DriverD("Василий Олежко", true, 12);

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
    }
}