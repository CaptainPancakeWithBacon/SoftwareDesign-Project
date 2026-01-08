package src.products;

import src.state.FoodState;
import src.state.RawState;

public class Waffle implements IFood {
    private String type;
    private double basePrice;
    private FoodState state;

    public Waffle(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
        this.state = new RawState();
    }

    @Override
    public String getDescription() {
        return type + " wafel (" + state.getStateName() + ")";
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void prepare() {
        state.prepare(this);
    }

    @Override
    public void setState(FoodState state) {
        this.state = state;
    }

    @Override
    public FoodState getState() {
        return state;
    }
}
