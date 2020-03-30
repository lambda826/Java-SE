package utility_class.optinal;

import utility_class.optinal.pojo.Car;

import java.util.Optional;

public class Unwrap {

    public static Car get(Optional<Car> opt) {
        return opt.get();
    }

    public static Car orElse(Optional<Car> opt) {
        Optional<Car> optCar = Optional.of(new Car());
        return optCar.orElse(null);
    }

    public static void main(String[] args) {
        Optional<Car> opt = Optional.empty();
        System.out.println(get(opt));
    }
}
