package crms.lib;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalManager {

    private final Database<Rental> database;
    private final IReportMediator reporter;

    public RentalManager(Database<Rental> database, IReportMediator reporter) {
        this.database = database;
        this.reporter = reporter;
    }

    public Database<Rental> getDatabase() {
        return database;
    }

    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        if (car == null) {
            return false;
        }
        for (Rental rental : database.dataList) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && (startDate.isBefore(rental.getEndDate()) && endDate.isAfter(rental.getStartDate()))) {
                return false;
            }
        }
        return true;
    }

    public boolean isCarAvailableNow(Car car) {
        if (car == null) {
            return false;
        }
        for (Rental rental : database.dataList) {
            if ((rental.getCar().getId() == null ? car.getId() == null : rental.getCar().getId().equals(car.getId()))
                    && ((LocalDate.now().isBefore(rental.getEndDate()) || LocalDate.now().isEqual(rental.getEndDate()))
                    && (LocalDate.now().isAfter(rental.getStartDate()) || LocalDate.now().isEqual(rental.getStartDate())))) {
                return false;
            }
        }
        return true;
    }

    public boolean tryRentCar(Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            Rental rental = new Rental(car, startDate, endDate);
            System.out.println("Added rental");
            database.dataList.add(rental);
            return true;
        }
        return false;
    }

    public boolean tryRemoveRental(Rental rental) {
        for (Rental r : database.dataList) {
            if (r.getId() == null ? rental.getId() == null : r.getId().equals(rental.getId())) {
                database.dataList.remove(r);
                return true;
            }
        }
        return false;
    }

    public ArrayList<RentalReport> generateReport() {
        return reporter.requestRentalReport();
    }
}
