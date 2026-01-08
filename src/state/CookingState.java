package src.state;

import src.products.IFood;

public class CookingState implements FoodState {

    @Override
    public void prepare(IFood food) {
        System.out.println("Het voedsel wordt gekookt...");
        // Transition to Ready state
        food.setState(new ReadyState());
    }

    @Override
    public String getStateName() {
        return "Aan het koken";
    }
}