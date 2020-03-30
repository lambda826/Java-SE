package optional;

import optional.pojos.Car;
import optional.pojos.Insurance;
import optional.pojos.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                      .map(Person::getCar)
                      .map(optCar -> optCar.flatMap(Car::getInsurance))
                      .map(optInsurance -> optInsurance.map(Insurance::getName))
                      .flatMap(Optional::stream)
                      .collect(toSet());
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    private Insurance findCheapestInsurance(Person person, Car car) {
        // queries services provided by the different insurance companies compare all those data
        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }

    /**
     * You invoke a flatMap on the first optional, so if this optional is empty, the lambda expression passed to it won’t be executed, and this invocation will return an empty optional.
     * Conversely, if the person is present, flatMap uses it as the input to a Function returning an Optional<Insurance> as required by the flatMap method.
     * The body of this function invokes a map on the second optional, so if it doesn't contain any Car, the Function returns an empty optional, and so does the whole nullSafeFindCheapestInsurance method.
     * Finally, if both the Person and the Car are present, the lambda expression passed as an argument to the map method can safely invoke the original findCheapestInsurance method with them.
     */
    public Optional<Insurance> nullSafeFindCheapestInsuranceQuiz(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                     .flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

}
