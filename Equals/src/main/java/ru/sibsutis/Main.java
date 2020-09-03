package ru.sibsutis;

public class Main {
    String model;
    int speed;

    public boolean equals(Main car) {
        return this.model == car.model && this.speed == car.speed;
    }

    public static void main(String[] args) {
        Main car1 = new Main();
        car1.model = "BMW";
        car1.speed = 300;

        Main car2 = new Main();
        car2.model = "BMW";
        car2.speed = 200;

//        System.out.println(car1 == car2); //false
        System.out.println(car1.equals(car2));
    }
}
