package src.decorators;

import src.products.IFood;

public class BerriesDecorator extends FoodDecorator {

    public BerriesDecorator(IFood food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return food.getDescription() + " met bessen";
    }

    @Override
    public double getPrice() {
        return food.getPrice() + 0.80;
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Bessen toevoegen...");
    }
}
