package src.products;

public class Waffle implements IFood {
    private String type;
    private double basePrice;

    public Waffle(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return type + " wafel";
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void prepare() {
        System.out.println("Beslag maken voor " + type + " wafel...");
        System.out.println("Wafel bakken in de wafelijzer...");
    }
}
