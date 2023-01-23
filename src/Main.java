import rasing.Bus;
import rasing.Car;
import rasing.Transport;
import rasing.Truck;
import rasing.driver.*;

import java.util.*;


public class Main {

    private static final List<String> NAMES = List.of(
            "Питер Паркер",
            "Сергей Капустин",
            "Кларк Кент",
            "Силвестор Сталоне",
            "Федор Смолов",
            "Артем Дзюба",
            "Иван Пупкин",
            "Кощей Кощеевич",
            "Мистер Х",
            "Константин Настьевич"
    );

    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 4;

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

        Mechanic<Car> djuzeppe = new Mechanic<>("Джузеппе ", "Сильвестров", " ChupaCups");
        Sponsor cocaCola = new Sponsor("CocaCola", 200_000);
        nissan.addMechanic(djuzeppe);
        nissan.addSponsor(cocaCola);

        Mechanic<Car> antonio = new Mechanic<>("Антонио ", "Пупков", " KFC");
        Sponsor tamaguchi = new Sponsor("Тамагочи", 300_000);
        Sponsor dolchi = new Sponsor("Дольчи Габана", 300_000);

        ford.addMechanic(antonio);
        ford.addSponsor(tamaguchi, dolchi);

        Mechanic<Bus> sergio = new Mechanic<Bus>("Серджио ", "Островский", " Intel");
        Sponsor lego = new Sponsor("LEGO", 500_000);
        kamaz.addMechanic(sergio);
        kamaz.addSponsor(lego);

        List<Transport> transports = List.of(nissan, ford, liaz, kamaz);

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(nissan);
        serviceStation.addCar(ford);
        serviceStation.addTruck(kamaz);
        serviceStation.service();
        serviceStation.service();


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
        nissan.addDriver(new DriverB("Евгений ", true, 10,Category.B));
        printInfo(nissan);
        printInfo(ford);


        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();

        add("Педро Шакирович", queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();

        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();
    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }

    private static void serviceTransport(Transport transport) {
        if (!transport.service()) {
            try {
                throw new RuntimeException("Транспорт " + transport.getBrand() + " " + transport.getModel() + " не прошел ТО");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю: " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водители: " + NAMES);
        System.out.println("Механики: " + transport.getMechanics());
        System.out.println("Спонсоры: " + transport.getSponsors());
        System.out.println();

    }

    private static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, ((i + j) % 2 == 1 ? "●" : "◯"));
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void example1() {

        List<List<Integer>> biDemArrList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    biDemArrList.get(i).add(j, 1);
                } else if (i % 2 != 0 && j % 2 != 0) {
                    biDemArrList.get(i).add(j, 1);
                } else {
                    biDemArrList.get(i).add(j, 0);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
        }
    }

    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2) {

        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Нужно крикнуть Галю! ");
            return;
        }

        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove(Queue<String> queue1,
                               Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
}