package crms.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentalDatabase extends Database<Rental> {

    private final String filename = "rentals.txt";
    private static RentalDatabase instance;

    private RentalDatabase() {
        dataList = new ArrayList<>();
    }

    public static RentalDatabase getInstance() {
        if (instance == null) {
            instance = new RentalDatabase();
            instance.fetchFromDisk();
        }
        return instance;
    }

    @Override
    public Rental getItemById(String id) {
        for (Rental r : dataList) {
            if (r.getId() == null ? id == null : r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void fetchFromDisk() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while (reader.ready()) {
                String text = reader.readLine();
                String[] lineComponents = text.split("###");
                var carDatabase = CarDatabase.getInstance();
                try {
                    Car car = carDatabase.getItemById(lineComponents[2]);
                    if (car == null) {
                        return;
                    }
                    dataList.add(new Rental(car, LocalDate
                            .parse(lineComponents[0]),
                            LocalDate.parse(lineComponents[1])
                    )
                    );
                } catch (Exception e) {
                }

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An exception has occurred while reading " + filename);
        }
    }

    @Override
    public void saveToDisk() {
        try {
            try (FileWriter fileWriter = new FileWriter(filename)) {
                StringBuilder toWrite = new StringBuilder();
                for (Rental rental : dataList) {
                    toWrite.append(rental.getStartDate().toString())
                            .append("###")
                            .append(rental.getEndDate().toString())
                            .append("###")
                            .append(rental.getCar().getId()).append("\n");
                }
                fileWriter.write(toWrite.toString());
            }
        } catch (IOException e) {
            System.out.println("An exception has occured while saving to disk.");
        }
    }
}
