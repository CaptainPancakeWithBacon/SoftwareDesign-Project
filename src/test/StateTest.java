package src.test;

import src.builder.PancakeBuilder;
import src.products.IFood;
import src.decorators.SyrupDecorator;

public class StateTest {

    public static void main(String[] args) {
        PancakeBuilder builder = new PancakeBuilder();
        builder.prepareBatter();
        IFood pancake = builder.build();

        // Decorate
        pancake = new SyrupDecorator(pancake);

        // Prepare through states
        System.out.println(pancake.getDescription());
        pancake.prepare(); // Raw → Cooking
        System.out.println(pancake.getDescription());
        pancake.prepare(); // Cooking → Ready
        System.out.println(pancake.getDescription());
        pancake.prepare(); // Already Ready
    }
}