package src.products;

public class Pancake implements IFood {
    private String type;
    private double basePrice;

    public Pancake(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return type + " pannenkoek";
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void prepare() {
        System.out.println("Beslag maken voor " + type + " pannenkoek...");
        System.out.println("Pannenkoek bakken in de pan...");
    }
}
