package src.state;

import src.products.IFood;

public class RawState implements FoodState {

    @Override
    public void prepare(IFood food) {
        System.out.println("Beslag is rauw, klaar om te bakken...");
        // Transition to Cooking state
        food.setState(new CookingState());
    }

    @Override
    public String getStateName() {
        return "Rauw";
    }
}