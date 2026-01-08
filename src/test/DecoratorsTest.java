package src.test;

import src.products.IFood;
import src.products.Pancake;
import src.products.Waffle;
import src.decorators.SyrupDecorator;
import src.decorators.ChocolateDecorator;
import src.decorators.BerriesDecorator;

public class DecoratorsTest {

    public static void main(String[] args) {
        System.out.println("=== Single Decorator Tests ===");
        testSingleDecorators();

        System.out.println("\n=== Stacked Decorators Test ===");
        testStackedDecorators();
    }

    private static void testSingleDecorators() {
        IFood pancake = new Pancake("Naturel", 4.0);

        IFood pancakeWithSyrup = new SyrupDecorator(pancake);
        pancakeWithSyrup.prepare();
        System.out.println(pancakeWithSyrup.getDescription() + " | Price: €" + pancakeWithSyrup.getPrice());

        IFood pancakeWithChocolate = new ChocolateDecorator(pancake);
        pancakeWithChocolate.prepare();
        System.out.println(pancakeWithChocolate.getDescription() + " | Price: €" + pancakeWithChocolate.getPrice());

        IFood pancakeWithBerries = new BerriesDecorator(pancake);
        pancakeWithBerries.prepare();
        System.out.println(pancakeWithBerries.getDescription() + " | Price: €" + pancakeWithBerries.getPrice());
    }

    private static void testStackedDecorators() {
        IFood waffle = new Waffle("Brussels", 5.0);

        // Stack multiple decorators
        IFood deluxeWaffle = new SyrupDecorator(new ChocolateDecorator(new BerriesDecorator(waffle)));
        deluxeWaffle.prepare();
        System.out.println(deluxeWaffle.getDescription() + " | Price: €" + deluxeWaffle.getPrice());

        // Another combination
        IFood fancyPancake = new ChocolateDecorator(new SyrupDecorator(new Pancake("Naturel", 4.0)));
        fancyPancake.prepare();
        System.out.println(fancyPancake.getDescription() + " | Price: €" + fancyPancake.getPrice());
    }
}
