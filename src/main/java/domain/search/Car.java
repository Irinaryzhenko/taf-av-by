package domain.search;

import java.util.Objects;

public class Car {
    private String name;
       private double capacity;
    private int year;
    private int price;

    public Car(String brand, double capacity, int year, int price) {
        this.name = brand;
        this.capacity = capacity;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.capacity, capacity) == 0 && year == car.year && Objects.equals(name, car.name) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, year, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
