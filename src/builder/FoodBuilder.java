package src.builder;

import src.products.IFood;

public interface FoodBuilder {

    void prepareBatter();
    void addButter();
    void addSyrup();
    void addBerries();

    IFood build();
}
