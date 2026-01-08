package src.decorators;

import src.products.IFood;

public abstract class FoodDecorator implements IFood {

    protected final IFood food;

    protected FoodDecorator(IFood food) {
        this.food = food;
    }

    @Override
    public void prepare() {
        food.prepare(); // delegate by default
    }
}
