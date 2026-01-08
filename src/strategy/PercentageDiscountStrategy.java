package src.strategy;

import src.products.IFood;

public class PercentageDiscountStrategy implements PricingStrategy {
    private final int discountPercentage;

    public PercentageDiscountStrategy(int discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(IFood food) {
        double basePrice = food.getPrice();
        double discount = basePrice * (discountPercentage / 100.0);
        return basePrice - discount;
    }

    @Override
    public String getStrategyDescription() {
        return discountPercentage + "% korting";
    }
}
