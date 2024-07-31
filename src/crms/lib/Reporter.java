package crms.lib;

import java.util.ArrayList;

public class Reporter implements IReportMediator {

    private CarManager carManager;
    private RentalManager rentalManager;

    public void setCarManager(CarManager carManager) {
        this.carManager = carManager;
    }

    public void setRentalManager(RentalManager rentalManager) {
        this.rentalManager = rentalManager;
    }

    @Override
    public ArrayList<CarReport> requestCarReport() {
        var reports = new ArrayList<CarReport>();
        for (Car car : carManager.getDatabase().dataList) {
            var report = new CarReport(car, rentalManager.isCarAvailableNow(car));
            reports.add(report);
        }
        return reports;
    }

    @Override
    public ArrayList<RentalReport> requestRentalReport() {
        var newList = new ArrayList<RentalReport>();
        for (Rental rental : rentalManager.getDatabase().dataList) {
            newList.add(new RentalReport(rental));
        }
        return newList;
    }
}
