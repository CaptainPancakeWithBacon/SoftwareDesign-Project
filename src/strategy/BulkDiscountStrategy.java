package src.strategy;

import src.products.IFood;

public class BulkDiscountStrategy implements PricingStrategy {
    private final double threshold;
    private final int discountPercentage;

    public BulkDiscountStrategy(double threshold, int discountPercentage) {
        this.threshold = threshold;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(IFood food) {
        double basePrice = food.getPrice();

        if (basePrice >= threshold) {
            double discount = basePrice * (discountPercentage / 100.0);
            return basePrice - discount;
        }

        return basePrice;
    }

    @Override
    public String getStrategyDescription() {
        return "Bulk korting: " + discountPercentage + "% korting bij orders boven €" +
               String.format("%.2f", threshold);
    }
}
