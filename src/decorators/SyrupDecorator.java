package src.decorators;

import src.products.IFood;

public class SyrupDecorator extends FoodDecorator {

    public SyrupDecorator(IFood food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return food.getDescription() + " met siroop";
    }

    @Override
    public double getPrice() {
        return food.getPrice() + 0.50;
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Siroop toevoegen...");
    }
}
