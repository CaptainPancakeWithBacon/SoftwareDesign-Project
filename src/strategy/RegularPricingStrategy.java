package src.strategy;

import src.products.IFood;

public class RegularPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(IFood food) {
        return food.getPrice();
    }

    @Override
    public String getStrategyDescription() {
        return "Normale prijs";
    }
}
