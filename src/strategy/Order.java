package src.strategy;

import src.products.IFood;

public class Order {
    private IFood food;
    private PricingStrategy pricingStrategy;

    public Order(IFood food, PricingStrategy pricingStrategy) {
        this.food = food;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public double calculateFinalPrice() {
        return pricingStrategy.calculatePrice(food);
    }

    public IFood getFood() {
        return food;
    }

    public void printOrderDetails() {
        System.out.println("=== Bestelling Details ===");
        System.out.println("Items: " + food.getDescription().split("\n")[0]);
        System.out.println("Basis prijs: €" + String.format("%.2f", food.getPrice()));
        System.out.println("Prijsstrategie: " + pricingStrategy.getStrategyDescription());
        System.out.println("Finale prijs: €" + String.format("%.2f", calculateFinalPrice()));

        double savings = food.getPrice() - calculateFinalPrice();
        if (savings > 0.01) {
            System.out.println("Je bespaart: €" + String.format("%.2f", savings));
        }
        System.out.println("========================");
    }
}
