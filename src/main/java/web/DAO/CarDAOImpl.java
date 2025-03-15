package web.DAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAOImpl implements CarDAO {
    private static List<Car> cars = new ArrayList<>();
    static {
        cars.add(new Car(1, "HYUNDAI", "белый", 2023));
        cars.add(new Car(2, "BMW", "черный", 2021));
        cars.add(new Car(3, "Toyota", "феолетовый", 2018));
        cars.add(new Car(4, "Ferrari", "красный", 2022));
        cars.add(new Car(5, "Mazda", "желтый", 2020));
    }
    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
