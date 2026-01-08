package src.test;

import src.builder.FoodBuilder;
import src.builder.PancakeBuilder;
import src.products.IFood;

public class BakeryTest {

    public static void main(String[] args) {

        FoodBuilder builder = new PancakeBuilder();

        builder.prepareBatter();
        IFood pancake = builder.build();

        pancake.prepare();

        System.out.println(pancake.getDescription());
        System.out.println("Price: €" + pancake.getPrice());
    }
}
