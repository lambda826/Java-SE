package utility_class.optinal;

import utility_class.optinal.pojo.Car;

import java.util.Optional;

public class Create {

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty(); // Empty Optional
        Optional<Car> optCar2 = Optional.of(new Car()); // Optional from a Non-null Value
        Optional<Car> optCar3 = Optional.ofNullable(null); // Optional from Null
    }
}
