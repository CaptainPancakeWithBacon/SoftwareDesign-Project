package src.builder;

import src.products.IFood;
import src.products.Waffle;

public class WaffleBuilder implements FoodBuilder {

    private boolean batterPrepared;

    private String type = "Brussels";
    private double basePrice = 5.00;

    @Override
    public void prepareBatter() {
        System.out.println("Wafelbeslag maken...");
        batterPrepared = true;
    }

    @Override
    public void addButter() {}
    @Override
    public void addSyrup() {}
    @Override
    public void addBerries() {}

    @Override
    public IFood build() {
        if (!batterPrepared) {
            throw new IllegalStateException("Batter not prepared");
        }
        return new Waffle(type, basePrice);
    }
}
