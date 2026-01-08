package src.builder;

import src.products.IFood;

public interface FoodBuilder {

    void prepareBatter();
    public void addButter();
    public void addSyrup();
    public void addBerries();
    IFood build();
}
