package src.builder;

import src.products.IFood;

public interface FoodBuilder {

    void prepareBatter();

    IFood build();
}
