package src.decorators;

import src.products.IFood;
import src.state.FoodState;

public abstract class FoodDecorator implements IFood {

    protected final IFood food;

    protected FoodDecorator(IFood food) {
        this.food = food;
    }

    @Override
    public void prepare() {
        food.prepare(); // delegate by default
    }

    @Override
    public void setState(FoodState state) {
        food.setState(state);
    }

    @Override
    public FoodState getState() {
        return food.getState();
    }
}
