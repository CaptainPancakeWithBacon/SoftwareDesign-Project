package src.decorators;

import src.products.IFood;

public class ChocolateDecorator extends FoodDecorator {

    public ChocolateDecorator(IFood food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return food.getDescription() + " met chocolade";
    }

    @Override
    public double getPrice() {
        return food.getPrice() + 0.75;
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Chocolade toevoegen...");
    }
}
