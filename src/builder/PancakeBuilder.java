package src.builder;

import src.products.IFood;
import src.products.Pancake;

public class PancakeBuilder implements FoodBuilder {
    private boolean batterPrepared;

    private String type = "Naturel";
    private double basePrice = 4.00;

    @Override
    public void prepareBatter() {
        System.out.println("Pannenkoekenbeslag maken...");
        batterPrepared = true;
    }

    @Override
    public void addButter() {

    }

    @Override
    public void addSyrup() {

    }

    @Override
    public void addBerries() {

    }

    @Override
    public IFood build() {
        if (!batterPrepared) {
            throw new IllegalStateException("Pancake batter not prepared");
        }
        return new Pancake(type, basePrice);
    }
}
