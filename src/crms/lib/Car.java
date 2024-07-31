package crms.lib;

public class Car {

    private final String id;
    private final String description;
    private final String brand;
    private final String model;
    private final double price;

    public Car(String id, String brand, String model, String description, double price) {
        this.id = id;
        this.description = description.trim();
        this.brand = brand.trim();
        this.model = model.trim();
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
