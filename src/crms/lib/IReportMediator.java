package crms.lib;

import java.util.ArrayList;

public interface IReportMediator {

    ArrayList<CarReport> requestCarReport();

    ArrayList<RentalReport> requestRentalReport();
}
