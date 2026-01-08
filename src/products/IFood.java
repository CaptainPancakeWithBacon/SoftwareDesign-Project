package src.products;

import src.state.FoodState;

public interface IFood {
    String getDescription();
    double getPrice();
    void prepare();

    void setState(FoodState state);
    FoodState getState();
}
