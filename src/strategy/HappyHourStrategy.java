package src.strategy;

import src.products.IFood;

public class HappyHourStrategy implements PricingStrategy {
    private final int discountPercentage;
    private final boolean isHappyHour;

    public HappyHourStrategy(int discountPercentage, boolean isHappyHour) {
        this.discountPercentage = discountPercentage;
        this.isHappyHour = isHappyHour;
    }

    @Override
    public double calculatePrice(IFood food) {
        double basePrice = food.getPrice();

        if (isHappyHour) {
            double discount = basePrice * (discountPercentage / 100.0);
            return basePrice - discount;
        }

        return basePrice;
    }

    @Override
    public String getStrategyDescription() {
        if (isHappyHour) {
            return "Happy Hour: " + discountPercentage + "% korting!";
        }
        return "Happy Hour: Niet actief (normale prijs)";
    }
}
