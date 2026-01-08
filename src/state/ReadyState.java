package src.state;

import src.products.IFood;

public class ReadyState implements FoodState {

    @Override
    public void prepare(IFood food) {
        System.out.println("Het voedsel is al klaar!");
    }

    @Override
    public String getStateName() {
        return "Klaar";
    }
}