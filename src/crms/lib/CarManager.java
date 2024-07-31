package crms.lib;

import java.util.ArrayList;
import java.util.Random;

public class CarManager {

    private final Database<Car> carDatabase;
    private final IReportMediator reporter;

    public CarManager(Database<Car> carDatabase, IReportMediator reporter) {
        this.carDatabase = carDatabase;
        this.reporter = reporter;
    }

    public Database<Car> getDatabase() {
        return carDatabase;
    }

    public boolean tryAddCar(Car car) {
        for (Car c : carDatabase.dataList) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                return false;
            }
        }
        carDatabase.dataList.add(car);
        return true;
    }

    public boolean tryRemoveCar(Car car) {
        for (Car c : carDatabase.dataList) {
            if (c.getId() == null ? car.getId() == null : c.getId().equals(car.getId())) {
                carDatabase.dataList.remove(c);
                return true;
            }
        }
        return false;
    }

    public Car createCar(String brand, String model, String description, double price) {
        String id;
        do {
            Random random = new Random();
            int randomNumber = random.nextInt(0x10000);
            id = String.format("%04X", randomNumber);
        } while (carDatabase.getItemById(id) != null);//Regenerate if it returns a car object
        return new Car(id, brand, model, description, price);
    }

    public ArrayList<CarReport> generateReport() {
        return reporter.requestCarReport();
    }
}
