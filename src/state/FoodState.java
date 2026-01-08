package src.state;

import src.products.IFood;

public interface FoodState {
    void prepare(IFood food);
    String getStateName();
}