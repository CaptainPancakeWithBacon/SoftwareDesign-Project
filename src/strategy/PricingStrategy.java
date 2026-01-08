package src.strategy;

import src.products.IFood;

public interface PricingStrategy {
    double calculatePrice(IFood food);
    String getStrategyDescription();
}
